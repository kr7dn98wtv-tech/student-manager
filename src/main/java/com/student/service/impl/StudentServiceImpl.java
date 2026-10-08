package com.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public PageInfo<Student> list(Integer pageNum, Integer pageSize, String name, Integer gender, String className) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.list(name, gender, className);
        return new PageInfo<>(list);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }


}
