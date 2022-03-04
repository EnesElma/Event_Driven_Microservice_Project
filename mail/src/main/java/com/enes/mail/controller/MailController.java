package com.enes.mail.controller;

import com.enes.mail.entity.Mail;
import com.enes.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private IMailService service;


    @PostMapping("all")
    public ResponseEntity<?> listMailByUser(@RequestBody String email){
        return ResponseEntity.ok(service.findMailByUserMail(email));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findMailById(@PathVariable String id){
        return ResponseEntity.ok(service.findMail(id));
    }
}
