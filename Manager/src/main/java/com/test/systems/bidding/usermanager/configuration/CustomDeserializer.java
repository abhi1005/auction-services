package com.test.systems.bidding.usermanager.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.systems.bidding.usermanager.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.json.JSONObject;

import java.util.HashMap;

@Slf4j
public class CustomDeserializer<T> implements Deserializer<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T deserialize(String topic, byte[] data) {
        UserDto value = null;
        try {
            JSONObject jsonNode = new JSONObject(new String(data));
            log.info("json = {}",jsonNode);
            value = new UserDto(jsonNode.getString("username"), jsonNode.getString("password"), jsonNode.getString("type"));
        } catch (Exception e) {
            log.error("Exception occured during deserializing : {}",e.getMessage());
            log.error("value = {}",value);
            //e.printStackTrace();
        }
        return (T) value;
    }

}