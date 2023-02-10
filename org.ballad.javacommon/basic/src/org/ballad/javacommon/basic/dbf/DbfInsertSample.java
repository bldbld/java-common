package org.ballad.javacommon.basic.dbf;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbfInsertSample {


    public static void main(String[] args) {
        try {
//            DbfWriterAndReadUtil.createDbf("b.dbf", fieldList, "GBK");
//            DbfWriterAndReadUtil.writeDbf("b.dbf", rowList, "GBK");
            String[] fieldName = DbfInsertSample.getFieldName("b.dbf", "GBK");
            for (int i = 0; i < fieldName.length; i++) {
                System.out.println(fieldName[i]);
            }

            List<Map<String, String>> getRowList = DbfInsertSample.readDbf("b.dbf", "GBK");
            for (Map<String, String> entity : getRowList) {
                System.out.println(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读dbf记录
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Map<String, String>> readDbf(String path, String charsetName) throws IOException {
        List<Map<String, String>> rowList = new ArrayList<>();
//		InputStream fis = new FileInputStream(path);
        DBFReader dbfReader = new DBFReader(new FileInputStream(path), Charset.forName(charsetName));
        Object[] rowValues;
        while ((rowValues = dbfReader.nextRecord()) != null) {
            Map<String, String> rowMap = new HashMap<String, String>();
            for (int i = 0; i < rowValues.length; i++) {
                rowMap.put(dbfReader.getField(i).getName(), String.valueOf(rowValues[i]).trim());
            }
//			System.out.println(rowMap);
            rowList.add(rowMap);
        }
        dbfReader.close();
//		fis.close();
        return rowList;
    }

    public static void createDbf(String path, List<Map<String, String>> fieldList, String charsetName)
            throws IOException {
        DBFField[] fields = new DBFField[fieldList.size()];
        int index = 0;
        for (Map<String, String> fieldMap : fieldList) {
            DBFField field = new DBFField();
            field.setName(fieldMap.get("name"));//字段名称
            field.setType(DBFDataType.CHARACTER);//指定字段类型为字符串
            field.setLength(Integer.valueOf(fieldMap.get("length")));//指定长度
            fields[index] = field;
            index++;
        }
        //定义DBFWriter实例用来写DBF文件
        DBFWriter dbfWriter = new DBFWriter(new FileOutputStream(path), Charset.forName(charsetName));
        //设置字段
        dbfWriter.setFields(fields);
        //写入dbf文件并关闭
        dbfWriter.close();
    }

    /**
     * 写dbf文件
     *
     * @param path:dbf文件路径
     * @param rowList:要写入的记录行
     * @param charsetName：字符集
     * @throws IOException
     */
    public static void writeDbf(String path, List<Map<String, String>> rowList, String charsetName)
            throws IOException {
        DBFWriter dbfWriter = new DBFWriter(new File(path));
        //获取字段
        String[] fieldName = getFieldName(path, "GBK");
        for (Map<String, String> rowMap : rowList) {
            Object[] rowData = new Object[fieldName.length];
            for (int i = 0; i < rowData.length; i++) {
                //根据字段来排列指，不然可能出现错位情况
                rowData[i] = rowMap.get(fieldName[i]);
            }
//			rowMap.values().toArray(rowData);
            //添加记录（此时并没有写入文件）
            dbfWriter.addRecord(rowData);
        }
        //写入dbf文件并保存关闭
        dbfWriter.close();
    }

    /**
     * 获取字段名
     *
     * @param path
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String[] getFieldName(String path, String charsetName) throws IOException {
//		InputStream fis = new FileInputStream(path);
        DBFReader dbfReader = new DBFReader(new FileInputStream(path), Charset.forName(charsetName));
        int fieldCount = dbfReader.getFieldCount();//获取字段数量
        String[] fieldName = new String[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fieldName[i] = dbfReader.getField(i).getName();
        }
        dbfReader.close();
//		fis.close();
        return fieldName;
    }
}
