package com.test.systems.bidding.usermanager.controller;

import com.test.systems.bidding.usermanager.entity.AuctionEvent;
import com.test.systems.bidding.usermanager.model.AuctionDto;
import com.test.systems.bidding.usermanager.model.BidDto;
import com.test.systems.bidding.usermanager.model.UserDto;
import com.test.systems.bidding.usermanager.service.AuctionService;
import com.test.systems.bidding.usermanager.service.BidUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/auction_services")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidUpdateService bidUpdateService;

    @PostMapping("/place_bid/{event_id}")
    public ResponseEntity<BidDto> placeBid(@RequestParam("event_id") String eventId, @RequestBody UserDto userDto, Double amount){
        BidDto bidDto = bidUpdateService.updateBid(eventId, amount, userDto);
        return new ResponseEntity<>(bidDto, HttpStatus.ACCEPTED);
    }

    /**
     * this method is for registering item for auction
     * this will create a scheduled event as per the time entered by the user
     * @param auctionDto
     * @return
     */
    @PostMapping("/register_item")
    public ResponseEntity<AuctionEvent> registerItem(@RequestBody AuctionDto auctionDto){
        AuctionEvent auctionEvent =  auctionService.registerItem(auctionDto);
        return new ResponseEntity<>(auctionEvent, HttpStatus.CREATED);
    }

    @GetMapping("/get_all_pending_auctions")
    public ResponseEntity<List<AuctionEvent>> getAllPendingAuctionEvents(){
        List<AuctionEvent> auctionEvents = auctionService.getAllPendingAuctionEvents();
        return new ResponseEntity<>(auctionEvents, HttpStatus.OK);
    }

    @GetMapping("/get_all_auctions")
    public ResponseEntity<List<AuctionEvent>> getAllAuctions(){
        List<AuctionEvent> auctionEvents = auctionService.getAllAuctions();
        return new ResponseEntity<>(auctionEvents, HttpStatus.OK);
    }

}
