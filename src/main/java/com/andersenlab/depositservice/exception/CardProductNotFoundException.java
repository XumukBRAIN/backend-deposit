package com.andersenlab.depositservice.exception;

public class CardProductNotFoundException extends RuntimeException{

    public CardProductNotFoundException(String message) {
        super(message);
    }

}
