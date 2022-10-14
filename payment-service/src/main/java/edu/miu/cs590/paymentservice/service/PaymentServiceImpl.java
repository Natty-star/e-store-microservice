package edu.miu.cs590.paymentservice.service;

import edu.miu.cs590.paymentservice.dao.PaymentRequest;
import edu.miu.cs590.paymentservice.entity.Payment;
import edu.miu.cs590.paymentservice.repository.PaymentRepository;
import edu.miu.cs590.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String createPayment(PaymentRequest paymentRequest) {

       String conformation=null;

        try {

            switch (paymentRequest.getDefaultPaymentMethod()) {


                case "credit-card": {
                    conformation = restTemplate
                            .getForObject("http://localhost:8088/credit-card/pay/"
                                            + paymentRequest.getUserId()
                                            + "/" + paymentRequest.getPrice(),
                                    String.class);
                    log.info("Payment redirecting to credit card service");
                    break;
                }
                case "paypal": {
                    conformation = restTemplate
                            .getForObject("http://localhost:8089/paypal/pay/"
                                            + paymentRequest.getUserId() + "/"
                                            + paymentRequest.getPrice(),
                                    String.class);
                    log.info("Payment redirecting to Paypal service");
                    break;
                }
                case "bank-transfer": {
                    conformation = restTemplate
                            .getForObject("http://localhost:8090/bank-transfer/pay/"
                                            + paymentRequest.getUserId() + "/"
                                            + paymentRequest.getPrice(),
                                    String.class);
                    log.info("Payment redirecting to Bank service");
                    break;
                }
                default: {
                    conformation = "Invalid payment type";
                   log.warn("Invalid payment type provided");
                    break;
                }
            }

        } catch (RestClientException e) {
            conformation= "Rejected";

            log.error("Error redirecting request to payment Services ", e);

        }


        Payment payment = Payment.builder()

                .userId(paymentRequest.getUserId())
                .orderId(paymentRequest.getOrderId())
                .preferredPaymentMethod(paymentRequest.getDefaultPaymentMethod())
                .paymentAmount(paymentRequest.getPrice())
                .paymentDate(LocalDate.now(Clock.systemDefaultZone()))
                .paymentStatus(conformation)
                .build();

        paymentRepository.save(payment);



        return conformation;
    }

    @Override
    public String getStatusByOrderId(Long id) {

        String status=paymentRepository.findAll().stream()
                .filter(payment -> payment.getOrderId().equals(id))
                .findFirst().get().getPaymentStatus();

        if(status.equals("Accepted")) {
           return "Accepted";
        }

        return "Rejected";
    }


    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getAllPaymentsByUserId(Long userId) {
        return paymentRepository.findAllByUserId(userId);
    }

    @Override
    public Payment getPaymentByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

}
