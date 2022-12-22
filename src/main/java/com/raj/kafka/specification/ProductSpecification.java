package com.raj.kafka.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.raj.kafka.model.Product;

import dto.SearchCriteriaDto;

@Component
public class ProductSpecification {

	
	public Specification<Product> getProducts(SearchCriteriaDto searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();         
            
            if(searchCriteria.getSearch() != null) {
                searchCriteria.getSearch().forEach(search -> {
                	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(search.getKey())), "%" + search.getValue().toLowerCase() + "%"));
                });
            }
            
//            UserRequest request;
//            
//            
//            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
//                predicates.add(criteriaBuilder.equal(root.get("email"), request.getEmail()));
//            }
//            if (request.getName() != null && !request.getName().isEmpty()) {
//                predicates.add(
//                		criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")),
//                                "%" + request.getName().toLowerCase() + "%")
//                		
//                		);
//            }
//            if (request.getGender() != null && !request.getGender().isEmpty()) {
//                predicates.add(criteriaBuilder.equal(root.get("gender"), request.getGender()));
//            }
            query.orderBy(criteriaBuilder.desc(root.get(searchCriteria.getSort())));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
