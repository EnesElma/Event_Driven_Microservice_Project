package com.enes.user.service;

import com.enes.user.entity.User;

import java.util.List;

public interface IUserService {
    Object saveOrUpdateUser(User user);

    void deleteUser(long id);

    List<User> findAll();

    User findByEmail(String email);
}
