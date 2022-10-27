package com.nbd.plantstore;


import com.nbd.plantstore.services.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaleTest {
    @Autowired
    private SaleService saleService;

    @Test
    public void addSaleTest() {
        String name = "Ula";
        String surname = "Fraczek";
        String email = "ula@poczta.pl";
        String city = "Lodz";
        String street = "Sierakowskiego";
        Integer street_num = 1;
//        saleService.addSale();
    }

    @Test
    public void deleteClientTest() {
    }
}
