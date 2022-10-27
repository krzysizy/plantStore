package com.nbd.plantstore.services;


import com.nbd.plantstore.Exceptions.addressNotExistById;
import com.nbd.plantstore.Exceptions.addressNotExistbyAll;
import com.nbd.plantstore.Exceptions.thisAddressAlreadyExist;
import com.nbd.plantstore.entities.Address;
import com.nbd.plantstore.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Address findAddressByIdIfExist (Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new addressNotExistById(id));
    }

    public void deleteAddress(Long id) {
        addressRepository.delete(findAddressByIdIfExist(id));
    }

    public Address findAddressByAllIfExist (String city, String street, Integer street_number) {
        return addressRepository.findByCityAndStreetAndStreet_number(city,street,street_number).orElseThrow(() -> new addressNotExistbyAll(city,street,street_number));
    }

    public Address addAddress (String city, String street, int street_number) {
        if(addressRepository.existsAddressByCityAndStreetAndStreet_number(city,street,street_number))
            throw new thisAddressAlreadyExist(city,street,street_number);
        return addressRepository.save(Address.builder()
                        .street(street)
                        .street_number(street_number)
                        .city(city)
                        .build());
    }

}
