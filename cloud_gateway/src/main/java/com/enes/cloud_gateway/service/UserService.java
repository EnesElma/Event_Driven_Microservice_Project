package com.enes.cloud_gateway.service;

import com.enes.cloud_gateway.entity.User;
import com.enes.cloud_gateway.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService{


    @Autowired
    private IUserRepository repository;


    @Override
    public Object saveOrUpdateUser(User user){

        try {
            return repository.save(user);
        }
        catch (Exception e) {
            return "Eksik veya duplicate kayıt";
        }
    }

    @Override
    public void deleteUser(long id){
        repository.deleteById(id);
    }

    @Override
    public Flux<User> findAll(){
        return repository.findAll();
    }

    @Override
    public Mono<User> findByEmail(String email){
        return repository.findByEmail(email);
    }

}
