package com.example.iitu.pizza.exception;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class OrderNotFoundException extends PSQLException {

    public OrderNotFoundException() {
        super("Pet not found", PSQLState.DATA_ERROR);
    }

    public OrderNotFoundException(String s) {
        super(s, PSQLState.DATA_ERROR);
    }
}
