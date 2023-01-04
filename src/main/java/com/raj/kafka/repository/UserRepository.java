package com.raj.kafka.repository;

import com.raj.kafka.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository<T extends Users> extends JpaRepository<T,String>, JpaSpecificationExecutor<T> {
}
