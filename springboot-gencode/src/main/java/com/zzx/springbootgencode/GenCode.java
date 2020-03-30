package com.zzx.springbootgencode;

import com.zzx.springbootgencode.command.Command;
import com.zzx.springbootgencode.configuration.GenCodeConfiguration;
import com.zzx.springbootgencode.meta.MetaData;
import com.zzx.springbootgencode.meta.Table;
import com.zzx.springbootgencode.output.CodeOutput;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

public class GenCode {
    //全局配置
    private GenCodeConfiguration configuration;

    // 模板引擎
    protected SpringTemplateEngine springTemplateEngine;

    public GenCode(GenCodeConfiguration configuration){
        this.configuration = configuration;
        this.initTemplateEngine();
    }

    /**
     * 初始化模板
     */
    private void initTemplateEngine(){
        springTemplateEngine = new SpringTemplateEngine();
        IDialect dialect = new SpringStandardDialect();
        springTemplateEngine.setDialect(dialect);
        // 文本解析器
        StringTemplateResolver resolverText = new StringTemplateResolver();
        resolverText.setCacheable(true);
        resolverText.setTemplateMode(TemplateMode.TEXT);
        // 添加解析器
        springTemplateEngine.addTemplateResolver(resolverText);
    }

    /**
     * 命令处理
     * @param tableName
     * @param command
     * @param codeOutput
     */
    public void process(String tableName, Command command, CodeOutput codeOutput){
        Table tableInfo = MetaData.getTableInfo(tableName,configuration.getTypeMapping());
        command.execute(tableInfo,springTemplateEngine,codeOutput);
    }
}
