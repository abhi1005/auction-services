package com.test.systems.bidding.usermanager.repository;

import com.test.systems.bidding.usermanager.entity.AuctionDetails;
import com.test.systems.bidding.usermanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionDetailsRepository extends JpaRepository<AuctionDetails, String> {
}
