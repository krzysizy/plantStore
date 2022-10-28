package com.nbd.plantstore;


import com.nbd.plantstore.Exceptions.nbdExceptions;
import com.nbd.plantstore.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private EntityManager em;


    @Test
    public void addSeedTest() {
        Double price = 7.5;
        Integer count = 500;
        String name = "Marchewka17";
        Integer weight = 17;
        productService.addSeed(price,count, name, weight);
        productService.deleteProduct(productService.findProductByNameIfExist(name).getId());
    }

    @Test
    public void addPlateTest() {
        Double price = 7.5;
        Integer count = 500;
        String name = "Sosna17";
        Integer height = 17;
        String period = "wiosna";
        productService.addPlate(price,count, name, height, period);
        productService.deleteProduct(productService.findProductByNameIfExist(name).getId());
    }

}
