package com.zzx.springbootgencode.command;

import com.zzx.springbootgencode.configuration.TypeMapping;
import com.zzx.springbootgencode.meta.MetaData;
import com.zzx.springbootgencode.output.ConsoleOutput;
import org.junit.jupiter.api.Test;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

public class CommandTest {

    @Test
    public void testCommand() {
        Command command = new GenVoCommand();
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        IDialect dialect = new SpringStandardDialect();
        springTemplateEngine.setDialect(dialect);
        // 文本解析器
        StringTemplateResolver resolverText = new StringTemplateResolver();
        resolverText.setCacheable(true);
        resolverText.setTemplateMode(TemplateMode.TEXT);
        // 添加解析器
        springTemplateEngine.addTemplateResolver(resolverText);
        command.execute(MetaData.getTableInfo("mysql_persons", new TypeMapping()), springTemplateEngine, new ConsoleOutput());
    }
}
