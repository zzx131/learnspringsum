package com.zzx.springbootbasedemo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {
    Integer id;

    String name;

    LocalDate createTime;
}
