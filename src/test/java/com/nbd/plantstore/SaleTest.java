package com.nbd.plantstore;


import com.nbd.plantstore.Exceptions.NotEnoughtProductException;
import com.nbd.plantstore.Exceptions.addressNotExistbyAll;
import com.nbd.plantstore.Exceptions.clientAlreadyExist;
import com.nbd.plantstore.services.ClientService;
import com.nbd.plantstore.services.ProductService;
import com.nbd.plantstore.services.SaleService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SaleTest {
    @Autowired
    private SaleService saleService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;


    @Test
    public void addSaleTest() {

        String email = "145@poczta";
        String name= "Marchewka90";
        if (!clientService.clientExists(email)) {
            clientService.addClientAndAddress("Ula", "Fraczek", email, "Lodz", "Piotrkowska", 34);
        }
        if (!productService.productExists(name)) {
            productService.addSeed(7.8,500, name, 70);
        }
        else {
            productService.addProductCount(500, productService.findProductByNameIfExist(name).getId());
        }
        saleService.addSale(200, clientService.findClientByEmailIfExist(email), productService.findProductByNameIfExist(name));

        assertThrows(NotEnoughtProductException.class, () -> {
            saleService.addSale(400, clientService.findClientByEmailIfExist(email), productService.findProductByNameIfExist(name));
        });

        assertTrue(productService.findProductByNameIfExist(name).getP_count() == 300);

        productService.addProductCount(500, productService.findProductByNameIfExist(name).getId());

        assertTrue(productService.findProductByNameIfExist(name).getP_count() == 500);
    }

}
