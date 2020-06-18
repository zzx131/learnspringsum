package com.zzx.swagger2.swagger2.controller;

import com.zzx.swagger2.swagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(description = "用户相关接口")
public class UserController {

    /**
     * 通过id查询用户
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("根据id获取用户")
    public User getUserById(@ApiParam(value = "用户id") Integer id) {
        return new User();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("用户登录")
    public User login(@RequestBody User user) {
        return new User();
    }
}
