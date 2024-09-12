package com.olik.backend.service;

import com.olik.backend.model.Rent;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Rent rentProduct(Rent rent) {
        return rentRepository.save(rent);
    }
}
