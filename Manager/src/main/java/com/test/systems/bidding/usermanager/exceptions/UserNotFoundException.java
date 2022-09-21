package com.test.systems.bidding.usermanager.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String username){
        super(username);
    }

    public UserNotFoundException(Throwable cause){
        super(cause);
    }
}
