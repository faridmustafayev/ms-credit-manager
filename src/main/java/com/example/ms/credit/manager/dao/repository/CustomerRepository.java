package com.example.ms.credit.manager.dao.repository;

import com.example.ms.credit.manager.dao.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByPin(String pin);
}
