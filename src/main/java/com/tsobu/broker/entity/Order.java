package com.tsobu.broker.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String orderNumber;
    private String productId;
    private double amount;
}
