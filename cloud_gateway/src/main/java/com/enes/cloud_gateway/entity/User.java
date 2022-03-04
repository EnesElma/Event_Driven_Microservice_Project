package com.enes.cloud_gateway.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("users")
public class User {

    @Id
    private long id;
    private String name;
    private String surname;
    private String email;
    private String passwd;

}
