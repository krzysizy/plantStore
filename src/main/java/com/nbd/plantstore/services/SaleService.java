package com.nbd.plantstore.services;

import com.nbd.plantstore.repositories.SaleRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
}
