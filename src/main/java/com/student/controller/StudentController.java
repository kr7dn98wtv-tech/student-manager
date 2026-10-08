package com.student.controller;

import com.student.common.Result;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/students")
    Result list(@RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "10")Integer pageSize,
            String name,Integer gender,String className){
        return Result.success(studentService.list(pageNum,pageSize,name, gender, className));
    }

    @PostMapping("/students")
    Result insert(@RequestBody Student student){
        studentService.insert(student);
        return Result.success();
    }

    @PutMapping("/students/{id}")
    Result update(@PathVariable Long id , @RequestBody Student student){
        student.setId(id);
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/students/{id}")
    Result delete (@PathVariable Long id){
        studentService.delete(id);
        return Result.success();
    }


}
