package com.zzx.springbootgencode.command;

import com.zzx.springbootgencode.meta.Table;
import com.zzx.springbootgencode.output.CodeOutput;
import org.thymeleaf.spring5.SpringTemplateEngine;

public abstract class Command {
    // 命令名称
    protected String commandName;
    protected String commandCode;

    public abstract void execute(Table tableInfo, SpringTemplateEngine springTemplateEngine, CodeOutput codeOutput);

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }
}
