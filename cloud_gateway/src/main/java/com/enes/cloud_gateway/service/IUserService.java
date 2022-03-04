package com.enes.cloud_gateway.service;

import com.enes.cloud_gateway.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    Object saveOrUpdateUser(User user);

    void deleteUser(long id);

    Flux<User> findAll();

    Mono<User> findByEmail(String email);
}
