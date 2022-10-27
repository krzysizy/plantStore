package com.nbd.plantstore;


import com.nbd.plantstore.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductService productService;

    @Test
    public void addSeedTest() {
        Double price = 7.5;
        Integer count = 500;
        String name = "Marchewka130";
        Integer weight = 130;
        productService.addSeed(price,count, name, weight);
    }

    @Test
    public void addPlateTest() {
        Double price = 7.5;
        Integer count = 500;
        String name = "Sosna1";
        Integer height = 100;
        String period = "wiosna";
        productService.addPlate(price,count, name, height, period);
    }

    @Test
    public void deleteClientTest() {
    }
}
