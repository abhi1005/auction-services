package com.test.systems.bidding.usermanager.service;

import com.test.systems.bidding.usermanager.constants.Status;
import com.test.systems.bidding.usermanager.model.AuctionDto;

public interface ValidationService {
    Status checkStatus(AuctionDto auctionDto);
}
