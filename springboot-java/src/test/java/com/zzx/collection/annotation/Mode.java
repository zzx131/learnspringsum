package com.zzx.collection.annotation;

import lombok.Data;

/**
 * @Description:
 * @Date: 2020/3/30
 * @Author: zhangzexin
 */
@Data
public class Mode {
    @IsLike(true)
    String id;

    @IsLike(true)
    String name;

    int age;
}
