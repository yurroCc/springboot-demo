package com.example.springbootdemo1.web;

import com.example.springbootdemo1.domian.User;
import com.example.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // GET请求代表着是查询数据
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userService.listUsers();
    }

    // GET请求+{id}代表的是查询某个用户
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    // POST请求代表着是新增数据
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "success";
    }

    // PUT请求代表的是更新
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("userId") Long userId, User user) {
        user.setUserId(userId);
        userService.updateUser(user);
        return "success";
    }

    // DELETE请求代表的是删除
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
        return "success";
    }
}
