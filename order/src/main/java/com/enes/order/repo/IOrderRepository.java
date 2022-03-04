package com.enes.order.repo;

import com.enes.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByUserMail(String email);
}
