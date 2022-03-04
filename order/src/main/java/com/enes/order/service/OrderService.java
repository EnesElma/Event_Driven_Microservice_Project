package com.enes.order.service;

import com.enes.order.entity.Order;
import com.enes.order.repo.IOrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService implements IOrderService{

    private String product_validate_url = "localhost:8081/product/validate";

    @Autowired
    private IOrderRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public List<Order> findAllByMail(String email){
        System.out.println(email);
        return repository.findAllByUserMail(email);
    }

    @Override
    public Order createOrder(Order order){
        Map<String, String> json = new HashMap<>();
        json.put("id",String.valueOf(order.getProductId()));
        json.put("quantity",String.valueOf(order.getQuantity()));


        //product servisi açık olmalıdır!!!!!
        boolean result= webClientBuilder.build()
                .post().uri(product_validate_url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(json))
                .retrieve()
                .bodyToMono(Boolean.class).block();


        Order order1;
        if (result){
            order1 = repository.save(order);
            kafkaTemplate.send("order_create",order1);
            System.out.println("Dolu:" + order1.getUserMail());
        }else {
            order1 = null;
            order.setQuantity(0); //başarısız sipariş sonucu 0 ürün satılır
            kafkaTemplate.send("order_create",order);
            System.out.println("Boş:");
        }

        return order1;
    }

}
