package com.olik.backend.dao;

import com.olik.backend.model.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final MongoTemplate mongoTemplate;
    public ProductRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public List<Product> findAvailableProductsBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        Criteria criteria = Criteria.where("availableFromDate").gte(startDate)
                .andOperator(Criteria.where("availableToDate").lte(endDate));

        Query query = new Query(criteria);
        return mongoTemplate.find(query, Product.class);
    }
}
