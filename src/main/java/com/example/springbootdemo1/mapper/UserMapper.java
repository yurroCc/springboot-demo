package com.example.springbootdemo1.mapper;

import com.example.springbootdemo1.domian.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chenlu
 */

@Mapper
public interface UserMapper {
    /*
     * 查询所有用户
     * @return 用户信息
     * */

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userId", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<User> listUsers();

    @Select("SELECT * FROM user WHERE id = #{userId}")
    @Results({
            @Result(property = "userId", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    User getUserById(Long userId);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    void saveUser(User user);

    @Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{userId}")

    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{userId}")
    void removeUser(@Param("userId") Long userId);

}
