package com.enes.user.service;

import com.enes.user.entity.User;
import com.enes.user.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

}
