package com.zzx.springbootgencode.meta;

import com.zzx.springbootgencode.configuration.TypeMapping;
import org.junit.jupiter.api.Test;

public class MeTaTest {

    @Test
    public void getMetaTest(){
        MetaData.getTableInfo("mysql_persons",new TypeMapping());
    }
}
