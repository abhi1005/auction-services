package com.test.systems.bidding.usermanager.repository;

import com.test.systems.bidding.usermanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends JpaRepository<User, String> {
    User findByUserName(String username);
}
