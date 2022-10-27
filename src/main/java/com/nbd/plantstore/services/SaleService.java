package com.nbd.plantstore.services;

import com.nbd.plantstore.Exceptions.*;
import com.nbd.plantstore.entities.Address;
import com.nbd.plantstore.entities.Client;
import com.nbd.plantstore.entities.Product;
import com.nbd.plantstore.entities.Sale;
import com.nbd.plantstore.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sale findSaleByIdIfExist (Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new saleNotExistById(id));
    }

    public Client findSaleClient (Long id) {
        return findSaleByIdIfExist(id).getClient();
    }

    public Product findSaleProduct (Long id) {
        return findSaleByIdIfExist(id).getProducts();
    }

    public void deleteSale(Long id) {
        saleRepository.delete(findSaleByIdIfExist(id));
    }

    public Sale findSaleByClientAndAddressIfExist (Client client, Product product) {
        return saleRepository.findSaleByEmailAndPName(client.getEmail(), product.getP_name()).orElseThrow(() -> new saleNotExistbyEmailAndPName(client, product));
    }

    @Transactional
    public Sale addSale (Integer sProductCount, Double finalCost, Client client, Product product) {

        if (saleRepository.existsByEmailAndPName(client.getEmail(), product.getP_name()))
            throw new saleAlreadyExist(client, product);

        return saleRepository.save(Sale.builder()
                .s_product_count(sProductCount)
                .s_final_cost(finalCost)
                .client(client)
                .products(product)
                .build());

    }
}
