package com.olik.backend.dao;

import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List findAvailableProductsBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return entityManager.createQuery("SELECT p FROM Product p WHERE p.availableFromDateTime >= :startDate AND p.availableToDateTime <= :endDate")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}


