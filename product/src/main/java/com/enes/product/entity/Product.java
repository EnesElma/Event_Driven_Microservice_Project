package com.enes.product.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int stock;

    public void setStock(int stock) {
        if (stock < 0) this.stock = 0;
        else this.stock = stock;
    }
}
