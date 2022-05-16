package com.example.springbootdemo1.domian;

import lombok.Builder;
import lombok.Data;

/**
 * @author chenlu
 */
@Data
@Builder
public class User {
    private Long userId;
    private String name;
    private Integer age;
}
