package com.test.systems.bidding.usermanager.service.impl;

import com.test.systems.bidding.usermanager.constants.UserType;
import com.test.systems.bidding.usermanager.entity.AuctionEvent;
import com.test.systems.bidding.usermanager.entity.User;
import com.test.systems.bidding.usermanager.exceptions.AuctionNotFoundException;
import com.test.systems.bidding.usermanager.exceptions.UserAlreadyExistsException;
import com.test.systems.bidding.usermanager.exceptions.UserNotFoundException;
import com.test.systems.bidding.usermanager.model.UserDto;
import com.test.systems.bidding.usermanager.repository.AuctionEventRepository;
import com.test.systems.bidding.usermanager.repository.UserManagementRepository;
import com.test.systems.bidding.usermanager.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Autowired
    private AuctionEventRepository auctionEventRepository;

    @Override
    public User createUser(UserDto userDto) {
        User user = userManagementRepository.findByUserName(userDto.getUsername());
        if(user != null){
            throw new UserAlreadyExistsException(user.getUserName()+" already exists in the system");
        }
        user = new User(userDto.getUsername(), userDto.getPassword(), UserType.valueOf(userDto.getType().toUpperCase()));
        user.setUserId(userDto.getUsername()+"_"+new Random().nextInt());
        return userManagementRepository.save(user);
    }

    @Override
    public User registerUser(UserDto userDto, String eventId) {
        return null;
    }

    @Override
    public User updateUser(UserDto userDto, String userId) {
        Optional<User> optionalUser = userManagementRepository.findById(userId);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }else{
            throw new UserNotFoundException(userId + " not found in the system");
        }
        User existingUser = userManagementRepository.findByUserName(userDto.getUsername());//checking if username already exists
        if(existingUser != null){
            throw new UserAlreadyExistsException(userDto.getUsername()+ " already exists in the system, cannot use this username");
        }
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setType(UserType.valueOf(userDto.getType().toUpperCase()));
        userManagementRepository.save(user);
        return user;
    }

    @Override
    public void removeUser(String userId) {
        Optional<User> optionalUser = userManagementRepository.findById(userId);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }else{
            throw new UserNotFoundException(String.valueOf(userId));
        }
        userManagementRepository.delete(user);
    }

    @Override
    public List<String> getAllRegisteredUser(String eventId) {
        Optional<AuctionEvent> optionalAuctionEvent = auctionEventRepository.findById(eventId);
        AuctionEvent auctionEvent = null;
        if(optionalAuctionEvent.isPresent()){
            auctionEvent = optionalAuctionEvent.get();
        }else{
            throw new AuctionNotFoundException(eventId);
        }
        return auctionEvent
                .getUsers()
                .stream()
                .map(User::getUserName)
                .collect(Collectors.toList());
    }
}
