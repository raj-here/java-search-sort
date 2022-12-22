package com.raj.kafka.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.kafka.model.Product;
import com.raj.kafka.service.ProductService;

import dto.SearchCriteriaDto;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("")
	public Page<Product> getAllProduct(Pageable pageable, SearchCriteriaDto searchCriteriaDto) {
		return this.productService.findAll(searchCriteriaDto, pageable);
	}

	@PostMapping("")
	public void saveProduct(@RequestBody Product product) {
		this.productService.saveProduct(product);
	}

}
