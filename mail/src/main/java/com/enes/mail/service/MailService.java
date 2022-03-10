package com.enes.mail.service;

import com.enes.mail.entity.Mail;
import com.enes.mail.entity.Order;
import com.enes.mail.entity.Product;
import com.enes.mail.repo.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MailService implements IMailService{

    @Value("${product.find.url}")
    private String product_url;

    @Autowired
    private IMailRepository repository;

    @Autowired
    private WebClient.Builder builder;


    @Override
    @KafkaListener(topics = "order_create")
    public Mail createMail(Order order){
        System.out.println(order.getUserMail());

        Mail mail = new Mail();
        mail.setUserid(order.getUserId());
        mail.setEmail(order.getUserMail());
        if (order.getQuantity() == 0) {
            mail.setText("Stok yetersizliği nedeniyle siparişiniz oluşturulamadı.");
        }else {
            mail.setText(findProductName(order.getProductId()) +" isimli ürününüze ait siparişiniz başarıyla oluşturuldu.");
        }
        System.out.println(mail);
        return repository.save(mail);
    }

    @Override
    public List<Mail> findMailByUserMail(String email){
        return repository.findAllByEmail(email);
    }

    @Override
    public Optional<Mail> findMail(String id){
        return repository.findById(id);
    }

    private String findProductName(long id){
        Product product = builder.build()
                .get().uri(product_url+"/"+id)
                .retrieve()
                .bodyToMono(Product.class).share().block();
        System.out.println(product.getName());

        return product.getName();
    }
}
