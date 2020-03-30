package com.zzx.springbootgencode.output;

import com.zzx.springbootgencode.meta.Table;
import com.zzx.springbootgencode.template.CodeTemplate;

public abstract class CodeOutput {
    protected String outputCode;

    public abstract void out(Table table, String centent, CodeTemplate codeTemplate);

    public String getOutputCode() {
        return outputCode;
    }

    public void setOutputCode(String outputCode) {
        this.outputCode = outputCode;
    }
}
