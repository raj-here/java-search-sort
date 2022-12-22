package com.raj.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.raj.kafka.model.Product;
import com.raj.kafka.service.ProductService;

@SpringBootApplication
public class KafkaApplication {

	private final ProductService productService;

	public KafkaApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

		for (int i = 0; i < 55; i++) {
			Product product = new Product();
			product.setName("Test " + i);
			product.setPrice(i);
			this.productService.saveProduct(product);

		}
	}

}
