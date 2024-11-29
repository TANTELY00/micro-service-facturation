package com.project.customer_service;

import com.project.customer_service.entities.Customer;
import com.project.customer_service.repository.CustomerRepository;
import org.apache.hc.core5.reactor.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
							.name("ravoson")
							.email("rasoa@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("ravoson")
					.email("rasoa@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("ravoson")
					.email("rasoa@gmail.com")
					.build());

			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
			});
		};
	}
}
