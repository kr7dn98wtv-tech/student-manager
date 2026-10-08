package com.student.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Integer gender;
    private String className;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
