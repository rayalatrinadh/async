package com.trinadh.AsyncDemo.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int productId;
    private String name;
    private String productType;
    private int quantity;
    private double price;
    private String trackingId;

}
