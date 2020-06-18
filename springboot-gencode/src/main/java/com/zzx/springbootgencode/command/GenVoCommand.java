package com.zzx.springbootgencode.command;

import com.zzx.springbootgencode.template.VoCodeTemplate;

public class GenVoCommand extends SingleCommand {

    public GenVoCommand() {
        this.commandName = "vo生成命令";
        this.commandCode = "04";
        this.codeTemplate = new VoCodeTemplate();
    }
}
