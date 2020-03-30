package com.zzx.springbootgencode.configuration;

import com.zzx.springbootgencode.output.CodeOutput;
import com.zzx.springbootgencode.output.ConsoleOutput;

public class CodeOutputRegister {
    public void registerCodeOutput(CodeOutput codeOutput) {
    }

    public CodeOutput getOutput(String outputCode) {
        return new ConsoleOutput();
    }
}
