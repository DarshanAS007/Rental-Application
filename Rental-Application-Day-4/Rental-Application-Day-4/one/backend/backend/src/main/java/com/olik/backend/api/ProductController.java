package com.olik.backend.api;

import com.olik.backend.model.Product;
import com.olik.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("products")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Product createProduct = productService.createProduct(product);
        return ResponseEntity.ok(createProduct);
    }

    @GetMapping
    public List<Product> searchProducts(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime searchFromDate, LocalDateTime searchToDate) {
        return productService.getAvailableProducts(searchFromDate, searchToDate);
    }
}