package com.nbd.plantstore;


import com.nbd.plantstore.services.ClientService;
import com.nbd.plantstore.services.ProductService;
import com.nbd.plantstore.services.SaleService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Integer product_count = 1;
        saleService.addSale(200, clientService.findClientByEmailIfExist("ula@edu.pl"), productService.findProductByNameIfExist("Marchewka13"));
    }

    @Test
    public void deleteClientTest() {
    }
}
