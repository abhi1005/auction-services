package com.test.systems.bidding.usermanager.exceptions;

public class AuctionNotFoundException extends RuntimeException{

    public AuctionNotFoundException(String auctionId){
        super(auctionId);
    }

    public AuctionNotFoundException(Throwable cause){
        super(cause);
    }

}
