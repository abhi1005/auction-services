package com.test.systems.bidding.usermanager.model;

import com.test.systems.bidding.usermanager.constants.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String type;
}
