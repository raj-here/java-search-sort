package com.raj.kafka.controller;

import com.raj.kafka.dto.SearchCriteriaDto;
import com.raj.kafka.model.Product;
import com.raj.kafka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController<T> {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Page<T> getAllProduct(@RequestBody SearchCriteriaDto searchCriteriaDto) {
		return this.productService.findAll(searchCriteriaDto);
	}

	@PostMapping("/allUsers")
	public Page<T> getAllUser(@RequestBody SearchCriteriaDto searchCriteriaDto) {
		return this.productService.findAllUser(searchCriteriaDto);
	}

	@PostMapping("/save")
	public void saveProduct(@RequestBody Product product) {
		this.productService.saveProduct(product);
	}

}
