package com.test.systems.bidding.usermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.systems.bidding.usermanager.constants.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id", length = 40)
    private String userId;
    private String userName;
    @JsonIgnore
    private String password;
    private UserType type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_auctions",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "event_id", referencedColumnName = "event_id",
                            nullable = false, updatable = false)})
    private List<AuctionEvent> auctions = new ArrayList<>();

    public User(String userName, String password, UserType type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
