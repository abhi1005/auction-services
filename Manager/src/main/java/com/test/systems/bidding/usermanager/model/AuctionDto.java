package com.test.systems.bidding.usermanager.model;

import com.test.systems.bidding.usermanager.constants.Category;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class AuctionDto implements Serializable {

    private String itemName;
    private Category category;
    private Double startingAmount;
    private long startTime;
    private long endTime;

}
