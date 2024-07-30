package com.trinadh.AsyncDemo.controller;


import com.trinadh.AsyncDemo.dto.Order;
import com.trinadh.AsyncDemo.service.OrderFulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderTransactionController {

    @Autowired
    private OrderFulfillmentService service;

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException{
        service.processOrder(order);
        service.assignVendor(order);
        service.packaging(order);
        service.assignDeliveryPartner(order);
        service.dispatchTheOrder(order);

        return ResponseEntity.ok(order);
    }
}
