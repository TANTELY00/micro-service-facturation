package com.project.inventory_service;

import com.project.inventory_service.entities.Product;
import com.project.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("computer")
							.price(1500)
							.quantity(1+new Random().nextInt(10))
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("printer")
					.price(500)
					.quantity(1+new Random().nextInt(10))
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("smart phone")
					.price(100)
					.quantity(1+new Random().nextInt(10))
					.build());

			productRepository.findAll().forEach(product -> {
				System.out.println(product.getId());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				System.out.println(product.getQuantity());
			});
		};
	}
}
