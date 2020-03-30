package com.zzx.springbootpoi;

import com.zzx.springbootpoi.model.ExportModel;
import com.zzx.springbootpoi.util.ExportExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootPoiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testNewUtils() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<ExportModel> list = new ArrayList<>();
        list.add(new ExportModel(1, "王尼玛", 1, "C语言", 22));
        list.add(new ExportModel(1, "王尼玛", 1, "C++", 33));
        list.add(new ExportModel(2, "葫芦娃", 1, "Python", 50));
        list.add(new ExportModel(2, "葫芦娃", 1, "java", 44));
        list.add(new ExportModel(2, "葫芦娃", 1, "PHP", 66));
        XSSFWorkbook xssfWorkbook = ExportExcelUtil.exportExcel("测试", ExportModel.class, list);
        ByteArrayOutputStream osWithXSSFWorkbook = ExportExcelUtil.getOSWithXSSFWorkbook(xssfWorkbook);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\zzx.xlsx");
            fileOutputStream.write(osWithXSSFWorkbook.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
