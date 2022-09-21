package com.test.systems.bidding.usermanager.service;

import com.test.systems.bidding.usermanager.entity.AuctionEvent;
import com.test.systems.bidding.usermanager.model.AuctionDto;
import com.test.systems.bidding.usermanager.model.BidDto;
import com.test.systems.bidding.usermanager.model.UserDto;

import java.util.List;

public interface AuctionService {
    AuctionEvent registerItem(AuctionDto auctionDto);
    List<AuctionEvent> getAllPendingAuctionEvents();
    List<AuctionEvent> getAllAuctions();

    void scheduleAuction();
}
