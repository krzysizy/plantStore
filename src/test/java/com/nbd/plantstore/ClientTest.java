package com.nbd.plantstore;


import com.nbd.plantstore.Exceptions.addressNotExistbyAll;
import com.nbd.plantstore.Exceptions.clientAlreadyExist;
import com.nbd.plantstore.Exceptions.clientNotExistbyEmail;
import com.nbd.plantstore.services.AddressService;
import com.nbd.plantstore.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientTest {
    @Autowired
    private ClientService clientService;

    @Autowired
    private AddressService addressService;

    String name = "Ula";
    String surname = "Fraczek";
    String email = "ula@edu.pl";
    String city = "Lodz";
    String street = "Sierakowskiego";
    Integer street_num = 7;
    @Test
    public void addClientTest() {
        clientService.addClientAndAddress(name, surname, email, city, street, street_num);
        assertThrows(clientAlreadyExist.class, () -> {
            clientService.addClientAndAddress(name, surname, email, city, "Konikowa", street_num);
        });
        //RollbackTest
        assertThrows(addressNotExistbyAll.class, () -> {
            addressService.findAddressByAllIfExist(city, "Konikowa", street_num);
        });
    }

    @Test
    public void deleteClientTest() {
        clientService.deleteClient(clientService.findClientByEmailIfExist(email).getId());
        assertThrows(clientNotExistbyEmail.class, () -> {
            clientService.findClientByEmailIfExist(email);
        });
        assertThrows(addressNotExistbyAll.class, () -> {
            addressService.findAddressByAllIfExist(city, street, street_num);
        });
    }
}
