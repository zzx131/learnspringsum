package com.zhangzx.springbootmongo.controller;


import com.zhangzx.springbootmongo.model.Student;
import com.zhangzx.springbootmongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class MgDbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/save.do")
    public void save() {
        Student student = new Student();
        student.setId("2");
        student.setAge(30);
        student.setBrithday(new Date());
        student.setName("张三");
        // mongoTemplate.save(student, "student");  //向MongoDB里面插入数据
        studentService.save(student);
    }
}
