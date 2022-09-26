package com.test.systems.bidding.usermanager.service.impl;

import com.test.systems.bidding.usermanager.constants.AuctionStatus;
import com.test.systems.bidding.usermanager.constants.Category;
import com.test.systems.bidding.usermanager.entity.AuctionDetails;
import com.test.systems.bidding.usermanager.entity.AuctionEvent;
import com.test.systems.bidding.usermanager.entity.Item;
import com.test.systems.bidding.usermanager.model.AuctionDto;
import com.test.systems.bidding.usermanager.repository.AuctionDetailsRepository;
import com.test.systems.bidding.usermanager.repository.AuctionEventRepository;
import com.test.systems.bidding.usermanager.repository.ItemRepository;
import com.test.systems.bidding.usermanager.service.AuctionService;
import com.test.systems.bidding.usermanager.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionEventRepository auctionEventRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AuctionDetailsRepository auctionDetailsRepository;

    @Autowired
    private ValidationService validationService;

    private static long startTime;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AuctionEvent registerItem(AuctionDto auctionDto) {
        AuctionEvent auctionEvent = new AuctionEvent();

        Item item = new Item();
        item.setItemId(UUID.randomUUID().toString());
        item.setName(auctionDto.getItemName());
        item.setStatus(validationService.checkStatus(auctionDto));
        item.setCategory(Category.valueOf(auctionDto.getCategory()));
        item.setStartingAmount(auctionDto.getStartingAmount());
        item.setAuctionEvent(auctionEvent);

        auctionEvent.setAuctionStatus(AuctionStatus.SCHEDULED);
        auctionEvent.setEventId(UUID.randomUUID().toString());
        auctionEvent.setItem(item);


        AuctionDetails auctionDetails = new AuctionDetails();
        auctionDetails.setId(UUID.randomUUID().toString());
        auctionEvent.setAuctionDetails(auctionDetails);

        itemRepository.save(item);
        //auctionEventRepository.save(auctionEvent);

        return auctionEvent;
    }

    @Override
    public List<AuctionEvent> getAllPendingAuctionEvents() {
        return auctionEventRepository.findByAuctionStatus(AuctionStatus.SCHEDULED);
    }

    @Override
    public List<AuctionEvent> getAllAuctions() {
        return auctionEventRepository.findAll();
    }

    @Override
    public void scheduleAuction() {

    }
}
