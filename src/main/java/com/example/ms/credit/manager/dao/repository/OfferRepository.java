package com.example.ms.credit.manager.dao.repository;

import com.example.ms.credit.manager.dao.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
