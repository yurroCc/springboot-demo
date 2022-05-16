package com.example.springbootdemo1;

import com.example.springbootdemo1.config.DruidDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author chenlu
 */
@SpringBootApplication
@Import(DruidDBConfig.class)
public class SpringbootDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1Application.class, args);
    }

}
