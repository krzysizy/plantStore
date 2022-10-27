package com.nbd.plantstore.Exceptions;

import com.nbd.plantstore.entities.Client;
import com.nbd.plantstore.entities.Product;

public class saleNotExistbyEmailAndPName extends nbdExceptions{
    public saleNotExistbyEmailAndPName(Client client, Product product) {
        super(String.format("%s %s sale of %s doen't exist!", client.getC_name(), client.getC_surname(), product.getP_name()));
    }
}
