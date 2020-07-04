package com.zzx.springbootgencode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class GenCodeController {

    @GetMapping("/index")
    public String helloWord(Map<String, Object> map){
        map.put("hello", "你好");
        return "index";
    }
}
