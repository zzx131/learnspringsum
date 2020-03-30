package com.zzx.springbootpoi.model;

import com.zzx.springbootpoi.config.ExcelConfig;
import lombok.Data;

@Data
public class ExportModel {
    private Integer id;

    @ExcelConfig(exportName = "姓名", isMerge = true, mergeFlag = "id")
    private String name;
    @ExcelConfig(exportName = "性别", exportConvertSign = true)
    private Integer sex;
    @ExcelConfig(exportName = "学科")
    private String subject;
    @ExcelConfig(exportName = "分数")
    private Integer score;

    public ExportModel(Integer id, String name, Integer sex, String subject, Integer score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.subject = subject;
        this.score = score;
    }

    public ExportModel() {
    }
}
