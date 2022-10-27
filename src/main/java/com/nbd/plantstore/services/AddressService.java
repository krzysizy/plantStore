package com.nbd.plantstore.services;


import com.nbd.plantstore.Exceptions.addressNotExistById;
import com.nbd.plantstore.Exceptions.addressNotExistbyAll;
import com.nbd.plantstore.Exceptions.canNotDeleteAddress;
import com.nbd.plantstore.Exceptions.thisAddressAlreadyExist;
import com.nbd.plantstore.entities.Address;
import com.nbd.plantstore.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientService clientService;

    public Address findAddressByIdIfExist (Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new addressNotExistById(id));
    }

    public void deleteAddress(Long id) {
        if(clientService.checkIsClientExistByAddress(id))
            throw new canNotDeleteAddress();
        addressRepository.delete(findAddressByIdIfExist(id));
    }

    public Address findAddressByAllIfExist (String city, String street, Integer street_number) {
        return addressRepository.findByCityAndStreetAndStreet_number(city,street,street_number).orElseThrow(() -> new addressNotExistbyAll(city,street,street_number));
    }

    @Transactional
    public void streetUpdate (String newStreet, Address address) {
        if(addressRepository.existsAddressByCityAndStreetAndStreet_number(address.getCity(), address.getStreet(), address.getStreet_number()))
            throw new thisAddressAlreadyExist(address.getCity(), address.getStreet(), address.getStreet_number());
        addressRepository.updateStreet(newStreet, address.getId());
    }

    @Transactional
    public void cityUpdate (String newCity, Address address) {
        if(addressRepository.existsAddressByCityAndStreetAndStreet_number(address.getCity(), address.getStreet(), address.getStreet_number()))
            throw new thisAddressAlreadyExist(address.getCity(), address.getStreet(), address.getStreet_number());
        addressRepository.updateCity(newCity, address.getId());
    }

    @Transactional
    public void streetNumUpdate (Integer newStreetNum, Address address) {
        if(addressRepository.existsAddressByCityAndStreetAndStreet_number(address.getCity(), address.getStreet(), address.getStreet_number()))
            throw new thisAddressAlreadyExist(address.getCity(), address.getStreet(), address.getStreet_number());
        addressRepository.updateStreetNum(newStreetNum, address.getId());
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
