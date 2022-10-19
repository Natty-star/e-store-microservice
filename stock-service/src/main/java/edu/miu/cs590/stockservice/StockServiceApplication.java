package edu.miu.cs590.stockservice;

import edu.miu.cs590.stockservice.domain.Stock;
import edu.miu.cs590.stockservice.stockRepo.StockRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData (StockRepo stockRepo){
		/**
		 private Long id;
		 private Long productId;
		 private Long quantity;
		 private Boolean isAvailable;
		 private Long thresholdQuantity;
		 */
		return args -> {
			Stock stock = new Stock();
			stock.setProductId(1L);
			stock.setQuantity(150L);
			stock.setThresholdQuantity(10L);
//			stock.setIsAvailable(true);

			stockRepo.save(stock);

			Stock stock2 = new Stock();
			stock2.setProductId(2L);
			stock2.setQuantity(50L);
			stock2.setThresholdQuantity(30L);
//			stock.setIsAvailable(true);

			stockRepo.save(stock2);

			Stock stock3 = new Stock();
			stock3.setProductId(3L);
			stock3.setQuantity(100L);
			stock3.setThresholdQuantity(20L);
//			stock.setIsAvailable(true);

			stockRepo.save(stock3);

		};
	}

}
