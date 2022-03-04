package com.enes.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private String userMail;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private int quantity;
}
