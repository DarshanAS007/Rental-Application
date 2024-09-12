package com.olik.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Product ID is required")
    private Long productId;
    @NotBlank(message = "Renter's name is required")
    private String renterName;
    @NotNull(message = "Renting from date is required")
    private LocalDateTime rentingFromDate;
    @NotNull(message = "Renting to date is required")
    private LocalDateTime rentingToDate;

    public Rent(@JsonProperty("productId") Long productId, @JsonProperty("renterName") String renterName, @JsonProperty("rentingFromDate") LocalDateTime rentingFromDate, @JsonProperty("rentingToDate") LocalDateTime rentingToDate) {
        this.productId = productId;
        this.renterName = renterName;
        this.rentingFromDate = rentingFromDate;
        this.rentingToDate = rentingToDate;
    }

    public Rent() {

    }


    public Long getproductId() {
        return productId;
    }

    public String getrenterName() {
        return renterName;
    }

    public LocalDateTime getrentingFromDate() {
        return rentingFromDate;
    }

    public LocalDateTime getrentingToDate() {
        return rentingToDate;
    }
}
