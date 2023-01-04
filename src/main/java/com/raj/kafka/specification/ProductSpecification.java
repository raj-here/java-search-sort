package com.raj.kafka.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.raj.kafka.dto.SearchCriteriaDto;

@Component
public class ProductSpecification<T> {

	
	public Specification<T> getSpecification(SearchCriteriaDto searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();         
            
            if(searchCriteria.getSearch() != null) {
                searchCriteria.getSearch().forEach(search -> {

                    if(search.getKey()!=null && search.getValue()!=null) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(search.getKey())), "%" + search.getValue().toLowerCase() + "%"));
                    }
                });
            }

            query.orderBy(criteriaBuilder.desc(root.get(searchCriteria.getSort())));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
