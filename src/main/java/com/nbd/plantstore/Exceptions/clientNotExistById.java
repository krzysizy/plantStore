package com.nbd.plantstore.Exceptions;

public class clientNotExistById extends nbdExceptions{

    public clientNotExistById(Long id) {
        super(String.format("Client id : %L doesn't exist!", id));
    }
}
