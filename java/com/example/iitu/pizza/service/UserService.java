package com.example.iitu.pizza.service;

import com.example.iitu.pizza.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
