package com.nbd.plantstore;


import com.nbd.plantstore.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Autowired
    private ClientService clientService;

    @Test
    public void addClientTest() {
        String name = "Ula";
        String surname = "Fraczek";
        String email = "ula@edu.pl";
        String city = "Lodz";
        String street = "Sierakowskiego";
        Integer street_num = 1;
        clientService.addClientAndAddress(name, surname, email, city, street, street_num);
    }

    @Test
    public void deleteClientTest() {
    }
}
