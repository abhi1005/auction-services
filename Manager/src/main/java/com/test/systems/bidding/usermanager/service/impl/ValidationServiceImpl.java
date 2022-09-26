package com.test.systems.bidding.usermanager.service.impl;

import com.test.systems.bidding.usermanager.constants.Status;
import com.test.systems.bidding.usermanager.model.AuctionDto;
import com.test.systems.bidding.usermanager.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public Status checkStatus(AuctionDto auctionDto) {
        return Status.FUNCTIONAL;
    }
}
