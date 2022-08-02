package com.app.toyshop.exceptions;

public class ToyException extends Exception {

    public ToyException(String message) {
        super(message);
    }

    public ToyException() {
        super("The requested toy was not found");
    }

}
