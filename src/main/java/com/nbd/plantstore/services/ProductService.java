package com.nbd.plantstore.services;

import com.nbd.plantstore.Exceptions.clientAlreadyExist;
import com.nbd.plantstore.Exceptions.clientNotExistById;
import com.nbd.plantstore.Exceptions.clientNotExistbyEmail;
import com.nbd.plantstore.entities.*;
import com.nbd.plantstore.repositories.ClientRepository;
import com.nbd.plantstore.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductRepository productRepository;

    public Product findProductByIdIfExist (Long id) {
        return productRepository.findById(id).orElseThrow(() -> new clientNotExistById(id));
    }
    public void deleteProduct(Long id) {
        productRepository.delete(findProductByIdIfExist(id));
    }

    public Product findProductByNameIfExist (String name) {
        return productRepository.findProductByName(name).orElseThrow(() -> new clientNotExistbyEmail(name));
    }

    @Transactional
    public void updateProductCount (Integer soldCount, Long id ) {
        productRepository.changeCount(soldCount, id);
    }


    public void updateProductBasePrice (Double basePrice, Long id ) {
        productRepository.updateBasePrice(basePrice, id);
    }

    public Product addSeed(Double base_price, Integer count, String name, Integer weight ) {
        if (productRepository.existsByName(name))
            throw new clientAlreadyExist(name);
        return productRepository.save(Seed.builder()
                .p_name(name)
                .p_base_price(base_price)
                .p_count(count)
                .weight(weight)
                .build());
    }

    public Product addPlate(Double base_price, Integer count, String name, Integer height, String period ) {
        if (productRepository.existsByName(name))
            throw new clientAlreadyExist(name);
        return productRepository.save(Plate.builder()
                .p_name(name)
                .p_base_price(base_price)
                .p_count(count)
                .height(height)
                .period(period)
                .build());
    }


}
