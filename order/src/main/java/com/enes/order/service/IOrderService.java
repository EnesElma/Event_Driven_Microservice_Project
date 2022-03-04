package com.enes.order.service;

import com.enes.order.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAllByMail(String email);

    Order createOrder(Order order);
}
