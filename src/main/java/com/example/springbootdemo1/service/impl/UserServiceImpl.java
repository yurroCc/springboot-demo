package com.example.springbootdemo1.service.impl;

import com.example.springbootdemo1.dao.UserDAO;
import com.example.springbootdemo1.domian.User;
import com.example.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenlu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public User getUserById(Long userId) {

        return userDAO.getUserById(userId);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void removeUser(Long userId) {
        userDAO.removeUser(userId);
    }
}
