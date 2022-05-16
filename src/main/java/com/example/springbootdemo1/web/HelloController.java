package com.example.springbootdemo1.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenlu
 */
@RestController
public class HelloController {
    @RequestMapping("hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "hello," + name;
    }
}
