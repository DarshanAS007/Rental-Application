package com.olik.backend.dao;

import com.olik.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositorys extends MongoRepository<Product, String>, ProductRepositoryCustom {
}
