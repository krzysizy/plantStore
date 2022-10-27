package com.nbd.plantstore.Exceptions;

public class thisAddressAlreadyExist extends nbdExceptions{
    public thisAddressAlreadyExist(String city, String street, int street_number) {
        super(String.format("This address: %s %s %i already exist!", city,street,street_number));
    }
}
