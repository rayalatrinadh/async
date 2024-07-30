package com.trinadh.AsyncDemo.service;

import com.trinadh.AsyncDemo.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void paymentProcess(Order order) throws InterruptedException{
        log.info("order initiated for payment : " + order.getProductId());

        //call external payment gateway and assume this gateway will wait for
        Thread.sleep(3000L);
        log.info("Order payment completed: " + order.getProductId());
    }
}
