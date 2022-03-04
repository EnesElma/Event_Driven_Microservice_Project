package com.enes.mail.entity;

import lombok.Data;

@Data
public class Order {

    private long id;
    private long userId;
    private String userMail;
    private long productId;
    private int quantity;
}
