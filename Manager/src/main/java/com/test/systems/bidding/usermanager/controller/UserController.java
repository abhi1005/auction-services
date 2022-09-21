package com.test.systems.bidding.usermanager.controller;

import com.test.systems.bidding.usermanager.entity.User;
import com.test.systems.bidding.usermanager.model.UserDto;
import com.test.systems.bidding.usermanager.service.UserManagementService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user_services")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/check")
    public String checking(){
        return "checked";
    }

    @PostMapping("/create_user")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
        User user = userManagementService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update_user/{user_id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto, @PathVariable("user_id") String userId){
        User user = userManagementService.updateUser(userDto, userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove_user/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") String userId) {
        userManagementService.removeUser(userId);
        return new ResponseEntity<>(userId + "deleted", HttpStatus.ACCEPTED);
    }

    @PostMapping("/register_user/{event_id}")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto, @PathVariable("event_id") String eventId){
        User user = userManagementService.registerUser(userDto, eventId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get_registered_user_for_auction/{event_id}")
    public ResponseEntity<List<String>> getAllRegisteredUser(@PathVariable("event_id") String eventId){
        List<String> registeredUsers = userManagementService.getAllRegisteredUser(eventId);
        return new ResponseEntity<>(registeredUsers, HttpStatus.ACCEPTED);
    }

}
