package com.olik.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotNull(message = "Price per hour is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price per hour must be greater that 0")
    private Double pricePerHour;
    @NotNull(message = "Available from date is required")
    private LocalDateTime availableFromDateTime;
    @NotNull(message = "Available to date is required")
    private LocalDateTime availableToDateTime;

    public Product(@JsonProperty("productName") String productName, @JsonProperty("pricePerHour") Double pricePerHour, @JsonProperty("availableFromDateTime") LocalDateTime availableFromDateTime, @JsonProperty("availableToDateTime") LocalDateTime availableToDateTime) {
        this.productName = productName;
        this.pricePerHour = pricePerHour;
        this.availableFromDateTime = availableFromDateTime;
        this.availableToDateTime = availableToDateTime;
    }

    public Product() {

    }

    public String getproductName() {
        return productName;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public LocalDateTime getAvailableFromDateTime() {
        return availableFromDateTime;
    }

    public LocalDateTime getAvailableToDateTime() {
        return availableToDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
