package com.zzx.springbootbasedemo.controller;

import com.zzx.springbootbasedemo.model.Foo;
import com.zzx.springbootbasedemo.model.FooParent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Date: 2020/3/11
 * @Author: zhangzexin
 */
@RestController
@Slf4j
public class FooController {

    @GetMapping("/foo")
    public String foo(@Validated Foo foo, BindingResult bindingResult){
        log.info("hhhhhhhhhnnn");
        if (bindingResult.hasErrors()){
            for (FieldError fieldError: bindingResult.getFieldErrors()){
                System.out.println(fieldError.toString());
                fieldError.getDefaultMessage();
            }
            return "fail";
        }
        log.info("gggg");
        return "success";
    }

    @PostMapping("/fooParent")
    public String fooParent(@RequestBody @Validated FooParent fooParent, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for (FieldError fieldError: bindingResult.getFieldErrors()){
                System.out.println(fieldError.toString());
                fieldError.getDefaultMessage();
            }
            return "fail";
        }
        return "success";
    }
}
