package com.nbd.plantstore;

import com.nbd.plantstore.Exceptions.addressNotExistbyAll;
import com.nbd.plantstore.Exceptions.thisAddressAlreadyExist;
import com.nbd.plantstore.services.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressService addressService;

    String city = "Lodz";
    String street = "Piotrkowska";
    Integer street_num = 34;

    @Test
    public void addAddressTest() {

        assertThat(addressService.addAddress(city, street, street_num)).isNotNull();
        assertThrows(thisAddressAlreadyExist.class, () -> {
            addressService.addAddress(city, street, street_num);
        });
    }

    @Test
    public void updateAddressTest() {
        addressService.streetUpdate("Kilinskiego",addressService.findAddressByAllIfExist(city, street, street_num));
        street = "Kilinskiego";
        addressService.cityUpdate("Zgierz", addressService.findAddressByAllIfExist(city, street, street_num));
        city = "Zgierz";
        addressService.streetNumUpdate(11,  addressService.findAddressByAllIfExist(city, street, street_num));
        street_num = 11;
    }

    @Test
    public void deleteAddressTest() {
        addressService.deleteAddress(addressService.findAddressByAllIfExist(city, street, street_num).getId());
        assertThrows(addressNotExistbyAll.class, () -> {
            addressService.deleteAddress(addressService.findAddressByAllIfExist(city, street, 123456).getId());
        });
    }

}
