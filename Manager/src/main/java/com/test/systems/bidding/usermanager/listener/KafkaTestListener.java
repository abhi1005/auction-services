package com.test.systems.bidding.usermanager.listener;


import com.test.systems.bidding.usermanager.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@Configuration
@Slf4j
public class KafkaTestListener {

    @KafkaListener(id = "Test_Listener", topics = "test",
            containerFactory = "kafkaPoolListenerContainerFactory",
            groupId = "test_group")
    public void listen(ConsumerRecord<?, ?> consumerRecord, Acknowledgment ack){
        UserDto userDto = (UserDto) consumerRecord.value();
        log.info("userDto : {} ",userDto);
    }

}
