package com.raj.kafka;

import com.raj.kafka.model.Product;
import com.raj.kafka.model.Users;
import com.raj.kafka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class KafkaApplication {

	@Autowired
	private ProductService productService;

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

		for (int i = 0; i < 55; i++) {
			Users user = new Users();
			user.setFirstName("Biz" + i);
			user.setLastName("Tecno" + i);
			this.productService.saveUser(user);
			Users user1= new Users();
			user1.setFirstName("Indian" + i);
			user1.setLastName("Bakshi"+ i);
			this.productService.saveUser(user1);
		}
	}

}
