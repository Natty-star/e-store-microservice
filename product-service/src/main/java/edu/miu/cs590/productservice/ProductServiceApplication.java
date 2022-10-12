package edu.miu.cs590.productservice;

import edu.miu.cs590.productservice.domain.Category;
import edu.miu.cs590.productservice.domain.Product;
import edu.miu.cs590.productservice.productRepo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData (ProductRepo productRepo){
		/**
		 *  private Long id;
		 *     private String name;
		 *     private double price;
		 *     private String vender;
		 */
		return args -> {
			Product product = new Product();
			product.setName("jordan");
			product.setPrice(100.00);
			product.setVender("Adidas");

			Category category = new Category();
			category.setName("shoe");
			category.setDescription("jordan brand shoe by Adidas");

			product.setCategory(category);
			productRepo.save(product);
		};
	}

}
