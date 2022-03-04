package com.enes.cloud_gateway.securtiy.details;

import com.enes.cloud_gateway.entity.User;
import com.enes.cloud_gateway.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomUserDetailsService implements ReactiveUserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    public Mono<UserDetails> findByUsername(String username) {
        Mono<User> userMono = userRepository.findByEmail(username);
        User user = userMono.share().block();
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return Mono.just(customUserDetails);
    }
}






















