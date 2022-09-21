package com.test.systems.bidding.usermanager.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auction_details")
public class AuctionDetails {

    @Id
    @Column(length = 100)
    private String id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private AuctionEvent auctionEvent;

    private Double highestBid;
    private String userId;

}
