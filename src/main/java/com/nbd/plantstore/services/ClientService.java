package com.nbd.plantstore.services;

import com.nbd.plantstore.Exceptions.*;
import com.nbd.plantstore.entities.Address;
import com.nbd.plantstore.entities.Client;
import com.nbd.plantstore.repositories.AddressRepository;
import com.nbd.plantstore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressService addressService;

    public Client findClientByIdIfExist (Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new clientNotExistById(id));
    }

    public Address findClientAddress (Long id) {
        return findClientByIdIfExist(id).getAddress();
    }

    public void deleteClient(Long id) {
        clientRepository.delete(findClientByIdIfExist(id));
    }

    public Client findClientByEmailIfExist (String email) {
        return clientRepository.findClientByEmail(email).orElseThrow(() -> new clientNotExistbyEmail(email));
    }

    @Transactional
    public Client addClientAndAddress (String name, String surname, String email, String city, String street, Integer street_number) {

        if (clientRepository.existsByEmail(email))
            throw new clientAlreadyExist(email);

        return clientRepository.save(Client.builder()
                .c_name(name)
                .c_surname(surname)
                .email(email)
                .address(addressService.addAddress(city, street, street_number))
                .build());

    }
}
