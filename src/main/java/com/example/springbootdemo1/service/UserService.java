package com.example.springbootdemo1.service;

import com.example.springbootdemo1.domian.User;

import java.util.List;

/**
 * @author chenlu
 */
public interface UserService {
    List<User> listUsers();

    User getUserById(Long userId);

    void saveUser(User user);

    void updateUser(User user);

    void removeUser(Long userId);
}
