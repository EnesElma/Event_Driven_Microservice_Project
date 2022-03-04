package com.enes.mail.service;

import com.enes.mail.entity.Mail;
import com.enes.mail.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IMailService {
    Mail createMail(Order order);

    List<Mail> findMailByUserMail(String email);

    Optional<Mail> findMail(String id);
}
