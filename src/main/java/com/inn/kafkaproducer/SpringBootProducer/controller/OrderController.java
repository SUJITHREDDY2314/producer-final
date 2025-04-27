package com.inn.kafkaproducer.SpringBootProducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inn.kafkaproducer.SpringBootProducer.service.KafkaOrderProducer;
import com.inn.kafkaproducer.SpringBootProducer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private KafkaOrderProducer producer;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) throws JsonProcessingException {
        producer.sendOrder(order);
        return ResponseEntity.ok("Order placed and sent to Kafka");
    }

    @GetMapping
    public ResponseEntity<String> getOrders() throws JsonProcessingException {
        return ResponseEntity.ok("get order successful");
    }


}

