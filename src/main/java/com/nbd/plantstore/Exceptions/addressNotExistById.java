package com.nbd.plantstore.Exceptions;

public class addressNotExistById extends nbdExceptions{
    public addressNotExistById(Long id) {
        super(String.format("Address id : %d doesn't exist!", id));
    }
}
