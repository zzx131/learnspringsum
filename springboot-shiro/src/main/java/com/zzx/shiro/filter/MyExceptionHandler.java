package com.zzx.shiro.filter;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map ErrorHandler(AuthorizationException e) {
        Map map = new HashMap();
        map.put("code", 500);
        //判断异常的类型,返回不一样的返回值
        map.put("msg", "没有权限 ");
        return map;
    }
}