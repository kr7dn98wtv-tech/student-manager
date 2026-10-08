package com.student.mapper;

import com.student.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_tb where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into user_tb (username,password) values (#{username},#{password})")
    String insert(User user);


}
