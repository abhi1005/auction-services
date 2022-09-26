package com.test.systems.bidding.usermanager.configuration;

import com.google.gson.Gson;
import com.test.systems.bidding.usermanager.model.UserDto;
import org.apache.kafka.common.serialization.Serializer;
import org.json.JSONObject;


public class KafkaTestCustomSerializer<T extends Object> implements Serializer<T> {

	@Override
	public byte[] serialize(String topic, T data) {
		byte[] serializedData = null;
		UserDto userDto = (UserDto) data;
		JSONObject jsonObject = new JSONObject(new Gson().toJson(userDto));
		serializedData = jsonObject.toString().getBytes();
		return serializedData;
	}

}
