package com.raj.kafka.repository;

import com.raj.kafka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T,String>, JpaSpecificationExecutor<T> {


}
