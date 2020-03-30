package com.zhangzx.springbootmongo.service;

import com.zhangzx.springbootmongo.dao.StudentRepository;
import com.zhangzx.springbootmongo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService {
    @Resource
    private StudentRepository repository;

    public void save(Student student){
        repository.save(student);
    }
}
