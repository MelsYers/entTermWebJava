package com.example.iitu.pizza.exception;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;


public class PizzaNotFoundException extends PSQLException {

    public PizzaNotFoundException() {
        super("Pizza not found", PSQLState.DATA_ERROR);
    }

    public PizzaNotFoundException(String s) {
        super(s, PSQLState.DATA_ERROR);
    }

}
