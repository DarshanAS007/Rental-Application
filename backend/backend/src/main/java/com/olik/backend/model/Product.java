package com.olik.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotNull(message = "Price per hour is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price per hour must be greater than 0")
    private Double pricePerHour;
    @NotNull(message = "Available from date is required")
    private LocalDateTime availableFromDate;

    @NotNull(message = "Available to date is required")
    private LocalDateTime availableToDate;

    public Product(@JsonProperty("productName") String productName, @JsonProperty("pricePerHour") Double pricePerHour, @JsonProperty("availableFromDateTime") LocalDateTime availableFromDateTime, @JsonProperty("availableToDateTime") LocalDateTime availableToDateTime) {
        this.productName = productName;
        this.pricePerHour = pricePerHour;
        this.availableFromDate = availableFromDateTime;
        this.availableToDate = availableToDateTime;
    }

    public String getProductName() {
        return productName;
    }
    public Double getPricePerHour() {
        return pricePerHour;
    }
    public LocalDateTime getAvailableFromDate() {
        return availableFromDate;
    }
    public LocalDateTime getAvailableToDate() {
        return availableToDate;
    }
}
