package com.enes.order.controller;

import com.enes.order.entity.Order;
import com.enes.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService service;

    @PostMapping("get/all")
    public ResponseEntity<?> listAllOrder(@RequestBody String email){
        System.out.println(email);
        return ResponseEntity.ok(service.findAllByMail(email));
    }


    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        System.out.println("order controller");
        Order responce_order = service.createOrder(order);
        if (responce_order == null) return ResponseEntity.ok("Hatalı id veya yetersiz stok");
        else return ResponseEntity.ok(responce_order);
    }
}











