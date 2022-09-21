package com.test.systems.bidding.usermanager.repository;

import com.test.systems.bidding.usermanager.constants.AuctionStatus;
import com.test.systems.bidding.usermanager.entity.AuctionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AuctionEventRepository extends JpaRepository<AuctionEvent, String> {
    List<AuctionEvent> findByAuctionStatus(AuctionStatus auctionStatus);
}
