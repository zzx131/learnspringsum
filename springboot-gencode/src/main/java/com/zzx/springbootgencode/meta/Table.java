package com.zzx.springbootgencode.meta;

import cn.hutool.core.date.DateUtil;

import java.util.List;

public class Table {
    // 编码
    private String code;
    // 类名
    private String className;
    // 备注
    private String comment;
    // 时间
    public String createDate = DateUtil.today();
    // 列字段
    public List<TableColumn> columnList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<TableColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<TableColumn> columnList) {
        this.columnList = columnList;
    }
}
