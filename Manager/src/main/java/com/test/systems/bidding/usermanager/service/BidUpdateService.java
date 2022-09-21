package com.test.systems.bidding.usermanager.service;

import com.test.systems.bidding.usermanager.model.BidDto;
import com.test.systems.bidding.usermanager.model.UserDto;

public interface BidUpdateService {
    BidDto updateBid(String eventId, Double amount, UserDto userDto);
}
