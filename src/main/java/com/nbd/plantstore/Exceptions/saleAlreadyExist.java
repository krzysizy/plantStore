package com.nbd.plantstore.Exceptions;

import com.nbd.plantstore.entities.Client;
import com.nbd.plantstore.entities.Product;

public class saleAlreadyExist extends nbdExceptions{

    public saleAlreadyExist(Client client, Product product) {
        super(String.format("ssss"));
    }
}
