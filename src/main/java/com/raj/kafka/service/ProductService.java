package com.raj.kafka.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.raj.kafka.model.Product;

import dto.SearchCriteriaDto;

public interface ProductService {

	public Page<Product> findAll(SearchCriteriaDto searchCriteria, Pageable pageable);

	public void saveProduct(Product product);
}