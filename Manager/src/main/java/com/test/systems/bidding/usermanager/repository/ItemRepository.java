package com.test.systems.bidding.usermanager.repository;

import com.test.systems.bidding.usermanager.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
