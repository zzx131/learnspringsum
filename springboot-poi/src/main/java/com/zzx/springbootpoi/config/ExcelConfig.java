package com.zzx.springbootpoi.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelConfig {
    /**
     *
     * @return 列名
     */
    String exportName();

    /**
     *
     * @return 列宽
     */
    int exportFieldWidth() default 20;

    /**
     *
     * @return 导出是否字段转换
     */
    boolean exportConvertSign() default false;

    /**
     * 是否合并相同行，在同一列中存在相同的值时是否合并行，默认不合并
     * @return
     */
    boolean isMerge() default false;

    /**
     *  合并判断字段，如果合并相同行，判断值是否相等的字段，默认为当前字段。
     *  如：每个人的姓名不是唯一的，但身份证是唯一的，当出现姓名相同是，可通过身份证判断是否合并
     * @return
     */
    String mergeFlag() default "";
}
