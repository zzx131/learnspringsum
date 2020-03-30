package com.zzx.springbootgencode.configuration;

import com.zzx.springbootgencode.command.Command;
import com.zzx.springbootgencode.output.CodeOutput;

import java.util.Collection;

public class GenCodeConfiguration {

    private CommandRegister commandRegister;

    private CodeOutputRegister codeOutputRegister;

    private TypeMapping typeMapping;

    public GenCodeConfiguration() {
        commandRegister = new CommandRegister();
        codeOutputRegister = new CodeOutputRegister();
        typeMapping = new TypeMapping();
    }

    /**
     * 命令
     */
    public void registerCommand(Command command) {
        commandRegister.registerCommand(command);
    }

    public Command getCommand(String commandCode) {
        return commandRegister.getCommand(commandCode);
    }

    public Command getCommand(Class<? extends Command> commandClass) {
        return commandRegister.getCommand(commandClass);
    }

    public Collection<Command> getCommands() {
        return commandRegister.getCommands();
    }

    /**
     * 输出
     */
    public void registerOutput(CodeOutput codeOutput) {
        codeOutputRegister.registerCodeOutput(codeOutput);
    }

    public CodeOutput getOutput(String outputCode) {
        return codeOutputRegister.getOutput(outputCode);
    }

    /**
     * 类型映射
     */
    public void addTypeMappiing(String dbType, String javaType) {
        typeMapping.addMapping(dbType, javaType);
    }

    public void overriedTypeMapping(String dbType, String javaType) {
        typeMapping.overriedTypeMapping(dbType, javaType);
    }

    public TypeMapping getTypeMapping() {
        return typeMapping;
    }
}
