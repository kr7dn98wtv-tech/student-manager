package com.student.mapper;

import com.student.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Autowired
    private StringRedisTemplate s

    List<Student> list(@Param("name")String name,
                       @Param("gender")Integer gender,
                       @Param("className")String className);

    @Insert(" insert into student_tb (name, gender, age, class_name) values (#{name}, #{gender}, #{age}, #{className})")
    void insert(Student student);

    @Update("update student_tb set name=#{name},gender=#{gender},age=#{age},class_name=#{className} where id=#{id}")
    void update(Student student);

    @Delete("delete from student_tb where id=#{id}")
    void delete(Long id);
}
