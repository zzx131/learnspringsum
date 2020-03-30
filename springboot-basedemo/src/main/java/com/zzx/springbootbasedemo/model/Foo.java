package com.zzx.springbootbasedemo.model;


import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Description: 测试校验实体类
 * @Date: 2020/3/11
 * @Author: zhangzexin
 */
@Data
public class Foo {
    @NotEmpty(message = "名字不能为空")
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;

}
