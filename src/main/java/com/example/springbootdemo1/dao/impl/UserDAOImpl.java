package com.example.springbootdemo1.dao.impl;

import com.example.springbootdemo1.dao.UserDAO;
import com.example.springbootdemo1.domian.User;
import com.example.springbootdemo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenlu
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private UserMapper userMapper;

    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void removeUser(Long userId) {
        userMapper.removeUser(userId);
    }

}