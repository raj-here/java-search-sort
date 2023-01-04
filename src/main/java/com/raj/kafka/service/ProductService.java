package com.raj.kafka.service;

import com.raj.kafka.dto.SearchCriteriaDto;
import com.raj.kafka.model.Product;
//import com.raj.kafka.repository.ProductRepository;

import com.raj.kafka.model.Users;
import com.raj.kafka.repository.ProductRepository;
import com.raj.kafka.repository.UserRepository;
import com.raj.kafka.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductService<T> {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductSpecification productSpecification;

	public Page<T> findAll(SearchCriteriaDto searchCriteria) {

		Specification<T> filter = this.productSpecification.getSpecification(searchCriteria);
//
		return this.productRepository.findAll(filter, PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize()));

	}

	public Page<T> findAllUser(SearchCriteriaDto searchCriteria) {

		Specification<T> filter = this.productSpecification.getSpecification(searchCriteria);

		return this.userRepository.findAll(filter, PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize()));

	}

	public void saveProduct(Product product) {
		this.productRepository.save(product);
	}

	public void saveUser(Users user){
		this.userRepository.save(user);
	}

}
