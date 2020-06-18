package com.zzx.springbootgencode.template;

import org.junit.jupiter.api.Test;

public class TemplateTest {
    @Test
    public void testVoTemplate() {
        VoCodeTemplate voCodeTemplate = new VoCodeTemplate();
        System.out.println(voCodeTemplate.read());
    }
}
