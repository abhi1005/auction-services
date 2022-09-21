package com.test.systems.bidding.usermanager.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BidDto implements Serializable {
    private String itemName;
    private String userName;
    private Double currentHighest;
}
