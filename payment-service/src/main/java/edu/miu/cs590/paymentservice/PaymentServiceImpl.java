package edu.miu.cs590.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

// to do: notify the order service that the payment is done
// to do: notify the shipping service that the payment is done
// to do: secure the communication between services

@Service

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void createPayment(PaymentRequest paymentRequest) {

       String conformation=null;

        try {

            switch (paymentRequest.getPreferredPaymentMethod()) {


                case "credit-card":
                    conformation = restTemplate
                            .getForObject("http://localhost:8081/credit-card/pay/"
                                    + paymentRequest.getUsername()
                                    + "/" + paymentRequest.getPaymentAmount(),
                                    String.class);
                    break;
                case "paypal":
                    conformation = restTemplate
                            .getForObject("http://localhost:8083/paypal/pay/"
                                    + paymentRequest.getUsername() + "/"
                                    + paymentRequest.getPaymentAmount(),
                                    String.class);
                    break;
                case "bank-transfer":
                    conformation = restTemplate
                            .getForObject("http://localhost:8082/bank-transfer/pay/"
                                    + paymentRequest.getUsername() + "/"
                                    + paymentRequest.getPaymentAmount(),
                                    String.class);
                    break;
                default:
                    conformation = "Invalid payment type";
                    break;
            }

        } catch (RestClientException e) {
            conformation= "Rejected ";
            System.out.println(e.getMessage());
        }


        Payment payment = Payment.builder()

                .username(paymentRequest.getUsername())
                .orderId(paymentRequest.getOrderId())
                .preferredPaymentMethod(paymentRequest.getPreferredPaymentMethod())
                .paymentAmount(paymentRequest.getPaymentAmount())
                .paymentDate(LocalDate.now(Clock.systemDefaultZone()))
                .paymentStatus(conformation)
                .build();

        paymentRepository.save(payment);

    }

    @Override
    public String getStatusByOrderId(int id) {

        String status=paymentRepository.findById(id).get().getPaymentStatus();
        if(status.equals("Accepted")) {
           return "Accepted";
        }

        return "Rejected";
    }


    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

}
