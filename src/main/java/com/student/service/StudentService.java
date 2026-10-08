package com.student.service;

import com.github.pagehelper.PageInfo;
import com.student.entity.Student;


public interface StudentService {

    PageInfo<Student> list(Integer pageNum, Integer pageSize, String name, Integer gender, String className);

    void insert(Student student);

    void update(Student student);

    void delete(Long id);


}
