package com.test.systems.bidding.usermanager.entity;

import com.test.systems.bidding.usermanager.constants.Category;
import com.test.systems.bidding.usermanager.constants.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @Column(length = 100)
    private String itemId;
    private String name;
    private Category category;
    private Double startingAmount;
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private AuctionEvent auctionEvent;

}
