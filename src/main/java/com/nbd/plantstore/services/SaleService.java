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
import java.sql.Timestamp;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductService productService;

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

    @Transactional(rollbackFor = {nbdExceptions.class})
    public Sale addSale (Integer sProductCount, Client client, Product product) {
        if (sProductCount > product.getP_count()) {
            throw new NotEnoughtProductException(product.getP_name());
        }
        productService.updateProductCount(sProductCount, product.getId());
        return saleRepository.save(Sale.builder()
                .s_product_count(sProductCount)
                .s_final_cost(sProductCount * product.getP_base_price())
                .client(client)
                .products(product)
                .s_time(new Timestamp(System.currentTimeMillis()))
                .build());
    }
}
