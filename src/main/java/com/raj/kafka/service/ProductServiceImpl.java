package com.raj.kafka.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.raj.kafka.model.Product;
import com.raj.kafka.repository.ProductRepository;
import com.raj.kafka.specification.ProductSpecification;

import dto.SearchCriteriaDto;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductSpecification productSpecification;

	public ProductServiceImpl(ProductRepository productRepository, ProductSpecification productSpecification) {
		this.productRepository = productRepository;
		this.productSpecification = productSpecification;
	}

	@Override
	public Page<Product> findAll(SearchCriteriaDto searchCriteria, Pageable pageable) {

		Specification<Product> filter = this.productSpecification.getProducts(searchCriteria);

		return this.productRepository.findAll(filter, pageable);
	}

	@Override
	public void saveProduct(Product product) {
		this.productRepository.save(product);
	}

}
