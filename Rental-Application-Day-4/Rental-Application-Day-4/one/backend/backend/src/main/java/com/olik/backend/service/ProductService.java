package com.olik.backend.service;

import com.olik.backend.dao.ProductRepository;
import com.olik.backend.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.saveProduct(product.getproductName(), product.getPricePerHour(), product.getAvailableFromDateTime(), product.getAvailableToDateTime());
    }

    public List<Product> getAvailableProducts(LocalDateTime searchFromData, LocalDateTime searchToData) {
        return productRepository.findAvailableProductsBetweenDates(searchFromData, searchToData);
    }
}
