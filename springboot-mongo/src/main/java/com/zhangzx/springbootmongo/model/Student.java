package com.zhangzx.springbootmongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "student")
public class Student {
    private String id;
    private String name;
    private int age;
    private Date brithday;
}
