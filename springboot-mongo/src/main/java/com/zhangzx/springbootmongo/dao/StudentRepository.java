package com.zhangzx.springbootmongo.dao;

import com.zhangzx.springbootmongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
