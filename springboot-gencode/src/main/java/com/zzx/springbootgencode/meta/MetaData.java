package com.zzx.springbootgencode.meta;

import cn.hutool.core.collection.CollectionUtil;
import com.zzx.springbootgencode.configuration.TypeMapping;
import com.zzx.springbootgencode.db.DbConnection;
import org.apache.commons.text.CaseUtils;

import java.sql.*;
import java.util.List;

public class MetaData {
    public static Table getTableInfo(String tableName, TypeMapping typeMapping) {
        String result = "";
        Connection conn = DbConnection.getConnection();
        Table table = new Table();
        try {
            table.setCode(tableName);
            // 表元数据
            Statement stmt = conn.createStatement();
            String sql = "select table_comment from information_schema.tables where table_name = '" + tableName + "'";
            ResultSet tableResultSet = stmt.executeQuery(sql);
            while (tableResultSet.next()) {
                table.setComment(tableResultSet.getString("table_comment"));
                break;
            }

            // 字段元数据
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, table.getCode(), "%");
            List<TableColumn> tableColumnList = CollectionUtil.newArrayList();
            while (resultSet.next()) {
                TableColumn tableColumn = new TableColumn();
                tableColumn.setCode(resultSet.getString("column_name").toLowerCase());
                tableColumn.setType(typeMapping.getJavaType(resultSet.getString("type_name")));
                tableColumn.setComment(resultSet.getString("remarks"));
                String attrName = CaseUtils.toCamelCase(resultSet.getString("column_name"), false, new char[]{'_'});
                tableColumn.setAttrName(attrName);
                tableColumnList.add(tableColumn);
            }
            table.setColumnList(tableColumnList);

            tableResultSet.close();
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.CloseConn(conn);
        }
        return table;
    }
}
