package com.nbd.plantstore.Exceptions;

public class saleNotExistById extends nbdExceptions{

    public saleNotExistById(Long id) {
        super(String.format("Sale with id: %L doesn't exist!", id));
    }
}
