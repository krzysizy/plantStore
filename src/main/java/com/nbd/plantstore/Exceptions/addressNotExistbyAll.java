package com.nbd.plantstore.Exceptions;

public class addressNotExistbyAll extends nbdExceptions{
    public addressNotExistbyAll(String city, String street, int street_number) {
        super(String.format("Adrress: %s %s %i doesn't exist!",city,street,street_number));
    }
}
