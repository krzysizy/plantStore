package com.nbd.plantstore;

import com.nbd.plantstore.services.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addAddressTest() {
        String city = "Lodz";
        String street = "Piotrkowska";
        Integer street_num = 34;
        addressService.addAddress(city, street, street_num);
    }

    @Test
    public void deleteAddressTest() {
        addressService.deleteAddress(addressService.findAddressByAllIfExist("Lodz", "Piotrkowska", 34).getId());
    }

    @Test
    public void updateAddressTest() {
        addressService.streetUpdate("Kilinskiego",addressService.findAddressByIdIfExist(1L));
        addressService.cityUpdate("Zgierz", addressService.findAddressByIdIfExist(1L));
        addressService.streetNumUpdate(11,  addressService.findAddressByIdIfExist(1L));
    }

}
