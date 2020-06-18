package com.zzx.springbootgencode.command;

import cn.hutool.core.bean.BeanUtil;
import com.zzx.springbootgencode.meta.Table;
import com.zzx.springbootgencode.output.CodeOutput;
import com.zzx.springbootgencode.template.CodeTemplate;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

public class SingleCommand extends Command {
    protected CodeTemplate codeTemplate;

    @Override
    public void execute(Table tableInfo, SpringTemplateEngine springTemplateEngine, CodeOutput codeOutput) {
        Map map = BeanUtil.beanToMap(tableInfo);
        Context context = new Context();
        context.setVariables(map);
        String result = springTemplateEngine.process(codeTemplate.read(), context);
        codeOutput.out(tableInfo, result, codeTemplate);
    }
}
