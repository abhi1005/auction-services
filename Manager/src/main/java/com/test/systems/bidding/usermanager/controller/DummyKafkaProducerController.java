package com.test.systems.bidding.usermanager.controller;

import com.test.systems.bidding.usermanager.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka-producer")
public class DummyKafkaProducerController {

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    @PostMapping(value = "/push")
    public String pushDataToKafka(@RequestBody UserDto userDto){
        kafkaTemplate.send("test",userDto.getUsername(),userDto);
        return "success";
    }

}
