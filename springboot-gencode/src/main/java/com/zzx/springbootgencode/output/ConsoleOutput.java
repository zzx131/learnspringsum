package com.zzx.springbootgencode.output;

import cn.hutool.core.lang.Console;
import com.zzx.springbootgencode.meta.Table;
import com.zzx.springbootgencode.template.CodeTemplate;

public class ConsoleOutput extends CodeOutput {
    @Override
    public void out(Table table, String centent, CodeTemplate codeTemplate) {
        Console.log("\n");
        Console.log("--------------");
        Console.log(centent);
        Console.log("--------------");
    }
}
