package com.trinadh.AsyncDemo.service;

import com.trinadh.AsyncDemo.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class OrderFulfillmentService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    public Order processOrder(Order order) throws InterruptedException{
        order.setTrackingId(UUID.randomUUID().toString());
        if(inventoryService.checkProductAVailability(order.getProductId())){
            paymentService.paymentProcess(order);
        }else{
            throw new RuntimeException("sorry for the Technical issue, please retry after sometime..");
        }

        return order;
    }

    public void notifyUser(Order order) throws InterruptedException{
        Thread.sleep(5000L);
        log.info("Notified to the user: "+Thread.currentThread().getName());
    }

    public void assignVendor(Order order) throws InterruptedException{
        Thread.sleep(6000L);
        log.info("Assign order to the vendor: " + Thread.currentThread().getName());
    }

    public void packaging(Order order) throws InterruptedException{
        Thread.sleep(15000L);
        log.info("Your order packaging completed: " + Thread.currentThread().getName());
    }

    public void assignDeliveryPartner(Order order) throws  InterruptedException{
        Thread.sleep(11000L);
        log.info("Delivery partner has been assigned : " + Thread.currentThread().getName());
    }

    public void dispatchTheOrder(Order order) throws  InterruptedException{
        Thread.sleep(21000L);
        log.info("your order has been dispatched... : "+ Thread.currentThread().getName());
    }

}
