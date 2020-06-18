package com.zzx.springbootgencode.template;

import cn.hutool.core.io.IoUtil;

import java.io.InputStream;

public abstract class CodeTemplate {

    protected String tplName;

    protected String tplPath;

    protected String frileSuffix;

    protected String fileTag;

    /**
     * 读取模板文件的内容
     *
     * @return
     */
    public String read() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.tplPath);
        String tpl = IoUtil.read(is, "UTF-8");
        return tpl;
    }

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    public String getTplPath() {
        return tplPath;
    }

    public void setTplPath(String tplPath) {
        this.tplPath = tplPath;
    }

    public String getFrileSuffix() {
        return frileSuffix;
    }

    public void setFrileSuffix(String frileSuffix) {
        this.frileSuffix = frileSuffix;
    }

    public String getFileTag() {
        return fileTag;
    }

    public void setFileTag(String fileTag) {
        this.fileTag = fileTag;
    }
}
