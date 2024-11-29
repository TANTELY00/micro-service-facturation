package com.project.billing_service;

import com.project.billing_service.DTOs.Customer;
import com.project.billing_service.DTOs.Product;
import com.project.billing_service.entities.Bill;
import com.project.billing_service.entities.ProductItem;
import com.project.billing_service.feign.CustomerRestController;
import com.project.billing_service.feign.ProductRestClient;
import com.project.billing_service.repository.BillRepository;
import com.project.billing_service.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestController customerRestController,
										ProductRestClient productRestClient
										){


		return args -> {

			Collection<Customer> customers = customerRestController.getCustomers().getContent();
			Collection<Product> products = productRestClient.getProducts().getContent();

			// CREATE BILL FOR A CUSTOMER
			customers.forEach(customer -> {
				// CREATE BILL
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);

				// CREATE PRODUCT ITEM
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.quantity(1+new Random().nextInt(20))
							.unitPrice(product.getPrice())
							.bill(bill)
							.build();
				});
			});
		};
	}
}
