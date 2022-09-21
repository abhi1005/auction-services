package com.test.systems.bidding.usermanager.service.impl;

import com.test.systems.bidding.usermanager.constants.AuctionStatus;
import com.test.systems.bidding.usermanager.entity.AuctionDetails;
import com.test.systems.bidding.usermanager.entity.User;
import com.test.systems.bidding.usermanager.exceptions.AuctionNotFoundException;
import com.test.systems.bidding.usermanager.exceptions.UserNotFoundException;
import com.test.systems.bidding.usermanager.model.BidDto;
import com.test.systems.bidding.usermanager.model.UserDto;
import com.test.systems.bidding.usermanager.repository.AuctionDetailsRepository;
import com.test.systems.bidding.usermanager.repository.UserManagementRepository;
import com.test.systems.bidding.usermanager.service.BidUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidUpdateServiceImpl implements BidUpdateService {

    @Autowired
    private AuctionDetailsRepository auctionDetailsRepository;

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Override
    public synchronized BidDto updateBid(String eventId, Double amount, UserDto userDto) {
        Optional<AuctionDetails> optionalAuctionDetails = auctionDetailsRepository.findById(eventId);
        AuctionDetails auctionDetails = null;
        if(optionalAuctionDetails.isPresent()){
            auctionDetails = optionalAuctionDetails.get();
        }else{
            throw new AuctionNotFoundException(eventId);
        }

        User user = userManagementRepository.findByUserName(userDto.getUsername());
        if(user == null){
            throw new UserNotFoundException(userDto.getUsername() + " not registered for the event ");
        }

        Double currentHighest = auctionDetails.getHighestBid();
        BidDto bidDto = new BidDto();
        if(amount > currentHighest){
            bidDto.setCurrentHighest(amount);
            bidDto.setUserName(userDto.getUsername());
            bidDto.setItemName(auctionDetails.getAuctionEvent().getItem().getName());
            auctionDetails.setHighestBid(amount);
            auctionDetails.setUserId(userDto.getUsername());
        }else{
            bidDto.setUserName(auctionDetails.getUserId());
            bidDto.setCurrentHighest(currentHighest);
            bidDto.setItemName(auctionDetails.getAuctionEvent().getItem().getName());
        }
        auctionDetails.getAuctionEvent().setAuctionStatus(AuctionStatus.ONGOING);
        auctionDetailsRepository.save(auctionDetails);
        return bidDto;
    }
}
