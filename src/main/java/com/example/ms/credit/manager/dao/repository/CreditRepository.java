package com.example.ms.credit.manager.dao.repository;

import com.example.ms.credit.manager.dao.entity.CreditEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditRepository extends CrudRepository<CreditEntity, Long> {
//    List<CreditEntity> findAllById(List<Long> creditIds);
}
