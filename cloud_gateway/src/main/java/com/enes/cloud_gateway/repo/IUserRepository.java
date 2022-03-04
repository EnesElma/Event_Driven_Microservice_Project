package com.enes.cloud_gateway.repo;

import com.enes.cloud_gateway.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface IUserRepository extends R2dbcRepository<User,Long> {

    Mono<User> findByEmail(String email);
}
