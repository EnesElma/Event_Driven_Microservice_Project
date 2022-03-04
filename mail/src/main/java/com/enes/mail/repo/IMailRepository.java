package com.enes.mail.repo;

import com.enes.mail.entity.Mail;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface IMailRepository extends CassandraRepository<Mail,String> {
    List<Mail> findAllByEmail(String email);
}
