package com.test.systems.bidding.usermanager.exceptions;

import com.test.systems.bidding.usermanager.entity.User;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String username){
        super(username);
    }

    public UserAlreadyExistsException(Throwable cause){
        super(cause);
    }

}
