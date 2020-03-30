package com.zzx.springbootbasedemo.model;

import lombok.Data;

import javax.validation.Valid;

/**
 * @Description:
 * @Date: 2020/3/11
 * @Author: zhangzexin
 */
@Data
public class FooParent {
    @Valid
    private Foo foo;
}
