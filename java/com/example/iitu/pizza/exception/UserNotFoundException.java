package com.example.iitu.pizza.exception;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class UserNotFoundException extends PSQLException {

    public UserNotFoundException(){
        super("User not found", PSQLState.DATA_ERROR);
    }

    public UserNotFoundException(String s){
        super(s, PSQLState.UNKNOWN_STATE);
    }

}