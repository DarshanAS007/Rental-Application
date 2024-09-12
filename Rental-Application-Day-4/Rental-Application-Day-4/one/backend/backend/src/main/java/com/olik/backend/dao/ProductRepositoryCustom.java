package com.olik.backend.dao;

import com.olik.backend.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAvailableProductsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}