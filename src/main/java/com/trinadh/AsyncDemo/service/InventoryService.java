package com.trinadh.AsyncDemo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {
    public boolean checkProductAVailability(int productId){
        //assume the product id available
        return true;
    }
}
