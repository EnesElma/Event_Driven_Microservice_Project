package com.enes.mail.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table(value = "mail")
public class Mail {

    @Id @PrimaryKey(value = "id") @PrimaryKeyColumn(ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    @Column(value = "userid")
    private long userid;
    @Column(value = "email")
    private String email;
    @Column(value = "text")
    private String text;
}
