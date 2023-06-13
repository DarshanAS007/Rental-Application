package com.olik.backend.service;

import com.olik.backend.dao.ProductRepositorys;
import com.olik.backend.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepositorys productRepositorys;

    public ProductService(ProductRepositorys productRepositorys) {
        this.productRepositorys = productRepositorys;
    }

    public Product createProduct(Product product) {
        return productRepositorys.save(product);
    }

    public List<Product> getAvailableProducts(LocalDateTime searchDate) {
        return productRepositorys.findAvailableProducts(searchDate);
    }
}
