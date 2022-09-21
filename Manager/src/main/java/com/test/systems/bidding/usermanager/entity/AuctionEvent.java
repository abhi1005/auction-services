package com.test.systems.bidding.usermanager.entity;

import com.test.systems.bidding.usermanager.constants.AuctionStatus;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auction_event")
@Data
public class AuctionEvent {

    @Id
    @Column(name = "event_id", length = 40)
    private String eventId;

    private AuctionStatus auctionStatus;

    @OneToOne(mappedBy = "auctionEvent", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Item item;

    @OneToOne(mappedBy = "auctionEvent", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private AuctionDetails auctionDetails;

    @ManyToMany(mappedBy = "auctions", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}
