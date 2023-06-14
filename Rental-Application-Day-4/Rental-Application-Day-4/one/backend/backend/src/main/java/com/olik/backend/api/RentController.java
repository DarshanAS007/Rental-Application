package com.olik.backend.api;

import com.olik.backend.model.Rent;
import com.olik.backend.service.RentService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public Rent rentProduct(@Valid @RequestBody Rent rent, BindingResult result) {
        return rentService.rentProduct(rent);
    }
}