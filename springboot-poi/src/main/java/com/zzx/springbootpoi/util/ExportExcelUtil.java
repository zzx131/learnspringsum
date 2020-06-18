package com.zzx.springbootpoi.util;

import com.zzx.springbootpoi.config.ExcelConfig;
import com.zzx.springbootpoi.model.PoiModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ExportExcelUtil {

    public static XSSFWorkbook getXSSFWorkbook() {
        XSSFWorkbook xssf_w_book = new XSSFWorkbook();
        return xssf_w_book;
    }

    public static ByteArrayOutputStream getOSWithXSSFWorkbook(XSSFWorkbook xssf_w_book) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            xssf_w_book.write(os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return os;
    }

    /**
     * 导出excel
     *
     * @param title
     * @param pojoClass
     * @param dataSet
     */
    public static XSSFWorkbook exportExcel(String title,
                                           Class<?> pojoClass,
                                           Collection<?> dataSet
    ) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        XSSFWorkbook xssfWorkbook = getXSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet(title);

        List<String> exportFieldTitle = new ArrayList<>();
        List<Integer> exportFieldWidth = new ArrayList<>();

        List<Method> methodObj = new ArrayList<>();
        Field[] fields = pojoClass.getDeclaredFields();

        List<Boolean> isMergeList = new ArrayList<>();
        List<Method> mergeFlagList = new ArrayList<>();

        // 遍历整个filed
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ExcelConfig excelConfig = field.getAnnotation(ExcelConfig.class);

            if (excelConfig != null) {
                exportFieldTitle.add(excelConfig.exportName());
                exportFieldWidth.add(excelConfig.exportFieldWidth());
                // 添加到需要导出的字段的方法
                String fieldName = field.getName();

                StringBuffer getMethodName = new StringBuffer("get");
                getMethodName.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
                Method getMethod = pojoClass.getMethod(getMethodName.toString());
                methodObj.add(getMethod);

                isMergeList.add(excelConfig.isMerge());
                if (excelConfig.isMerge()) {
                    StringBuilder getMergeFlagName = new StringBuilder("get");
                    String mergeFlag;
                    if (excelConfig.mergeFlag() != null) {
                        mergeFlag = getMethodName.toString();
                    } else {
                        getMergeFlagName.append(excelConfig.mergeFlag().substring(0, 1).toUpperCase()).append(excelConfig.mergeFlag().substring(1));
                        mergeFlag = getMergeFlagName.toString();
                    }
                    Method getMergeFlag = pojoClass.getMethod(mergeFlag, new Class[]{});
                    mergeFlagList.add(getMergeFlag);
                } else {
                    mergeFlagList.add(null);
                }
            }
        }

        int index = 0;
        // 产生表格标题行
        Row row = xssfSheet.createRow(index);
        for (int i = 0, exportFieldTitleSize = exportFieldTitle.size(); i < exportFieldTitleSize; i++) {
            Cell cell = row.createCell(i);
            XSSFRichTextString xssfString = new XSSFRichTextString(exportFieldTitle.get(i));
            cell.setCellValue(xssfString);
        }
        // 设置每行的列宽
        for (int i = 0; i < exportFieldWidth.size(); i++) {
            // 256=65280/255
            xssfSheet.setColumnWidth(i, 256 * exportFieldWidth.get(i));
        }
        Iterator its = dataSet.iterator();
        HashMap<String, PoiModel> poiModelMap = new HashMap<>();

        // 设置单元格样色
        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 循环插入剩下的集合
        setDate(dataSet, xssfSheet, methodObj, isMergeList, mergeFlagList, index, its, poiModelMap, cellStyle);
        return xssfWorkbook;
    }

    private static void setDate(Collection<?> dataSet,
                                XSSFSheet xssfSheet,
                                List<Method> methodObj,
                                List<Boolean> isMergeList,
                                List<Method> mergeFlagList,
                                int index, Iterator its,
                                HashMap<String, PoiModel> poiModelMap,
                                CellStyle cellStyle) throws IllegalAccessException, InvocationTargetException {
        while (its.hasNext()) {
            // 从第二行开始写，第一行是标题
            index++;
            Row row = xssfSheet.createRow(index);
            Object t = its.next();
            for (int k = 0; k < methodObj.size(); k++) {
                Cell cell = row.createCell(k);
                Method getMethod = methodObj.get(k);
                Object value = getMethod.invoke(t, new Object[]{});
                cell.setCellValue(value == null ? "" : value.toString());

                // 合并列
                if (isMergeList.get(k)) {
                    String mergeValue;
                    Method cm = mergeFlagList.get(k);
                    mergeValue = cm.invoke(t, new Object[]{}).toString();
                    PoiModel poiModel = poiModelMap.get(getMethod.getName());
                    if (poiModel == null) {
                        poiModel = new PoiModel();
                        poiModel.setRowIndex(index);
                        poiModel.setContent(mergeValue);
                        poiModelMap.put(getMethod.getName(), poiModel);
                    } else {
                        // 判断值是否相等，不相等则合并
                        if (!poiModel.getContent().equals(mergeValue)) {
                            // 合并单元格必须是2个或以上
                            if (poiModel.getRowIndex() != (index - 1)) {
                                CellRangeAddress cra = new CellRangeAddress(poiModel.getRowIndex(), index - 1, k, k);
                                xssfSheet.addMergedRegion(cra);
                                xssfSheet.getRow(poiModel.getRowIndex()).getCell(k).setCellStyle(cellStyle);
                            }
                            poiModel.setContent(mergeValue);
                            poiModel.setRowIndex(index);
                            poiModelMap.put(getMethod.getName(), poiModel);
                        } else {
                            // 最后一行无法在进行比较，直接合并
                            if (index == dataSet.size()) {
                                if (poiModel.getRowIndex() != index) {
                                    CellRangeAddress cra = new CellRangeAddress(poiModel.getRowIndex(), index, k, k);
                                    xssfSheet.addMergedRegion(cra);
                                    xssfSheet.getRow(poiModel.getRowIndex()).getCell(k).setCellStyle(cellStyle);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

