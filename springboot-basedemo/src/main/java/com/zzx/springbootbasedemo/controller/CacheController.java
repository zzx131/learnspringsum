package com.zzx.springbootbasedemo.controller;

import com.zzx.springbootbasedemo.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CacheController {

    @Value("${keyStorePath}")
    private String keyStorePath;

    @Cacheable("books")
    @GetMapping("/book")
    public Book findBook(String isbn) {
        Book book = new Book();
        book.setId(1);
        book.setName("zzx");
        book.setCreateTime(LocalDate.now());
        return book;
    }
}
