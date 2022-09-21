package com.test.systems.bidding.usermanager.service;

import com.test.systems.bidding.usermanager.entity.User;
import com.test.systems.bidding.usermanager.model.UserDto;

import java.util.List;

public interface UserManagementService {
    User createUser(UserDto userDto);
    User registerUser(UserDto userDto, String eventId);

    User updateUser(UserDto userDto, String userId);

    void removeUser(String userId);

    List<String> getAllRegisteredUser(String eventId);
}
