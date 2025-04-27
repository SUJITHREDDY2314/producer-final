package com.inn.kafkaproducer.SpringBootProducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.kafkaproducer.SpringBootProducer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "kafka1";

    public void sendOrder(Order order) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String orderJson = mapper.writeValueAsString(order);
        String key = order.getOrderId();
        kafkaTemplate.send(topic, key,  orderJson);
    }

}

