package org.ballad.javacommon.utils.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 基于iText5版本的AcroFields实现对表格型表单的有序读取
 */
public class PdfAcroFieldParser {

    public static void main(String[] args) {
        PdfReader reader;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        int pageSize = 2;
        try {
            reader = new PdfReader("AcroFiledSample.pdf");
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            List<String[]> pages = getSortedFields(form, pageSize);
            for (String[] page : pages) {
                for (String field : page) {
                    System.out.println(field);
                }
            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑
            stamper.close();

            FileOutputStream out = new FileOutputStream("AcroFiledSampleExport.pdf");
            Document doc = new Document(PageSize.A4);
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            for (int i = 1; i <= pageSize; i++) {
                PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
                copy.addPage(importPage);
            }
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取排序后的字段
     *
     * @param form
     * @param pageSize
     * @return
     */
    public static List<String[]> getSortedFields(AcroFields form, int pageSize) {
        List<List<String>> formPageFieldNameList = new ArrayList<List<String>>();
        for (int i = 0; i <= pageSize; i++) {
            List<String> list = new ArrayList<String>();
            formPageFieldNameList.add(list);
        }
        Iterator<String> it = form.getFields().keySet().iterator();
        while (it.hasNext()) {
            String name = it.next();
            for (AcroFields.FieldPosition pos : form.getFieldPositions(name)) {
                int page = pos.page;
                formPageFieldNameList.get(page - 1).add(name);
            }
        }
        List<String[]> result = new ArrayList<String[]>();
        for (List<String> list : formPageFieldNameList) {
            String[] array = list.toArray(new String[list.size()]);
            Arrays.sort(array, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    float aTop = form.getFieldPositions(a).get(0).position.getTop();
                    float bTop = form.getFieldPositions(b).get(0).position.getTop();

                    if (Math.abs(aTop - bTop) <= ARCO_FIELD_ROW_ALLOWABLE_ERROR) {
                        float aLeft = form.getFieldPositions(a).get(0).position.getLeft();
                        float bLeft = form.getFieldPositions(b).get(0).position.getLeft();
                        return (int) (aLeft - bLeft);
                    } else {
                        return (int) (bTop - aTop);
                    }
                }
            });
            result.add(array);
        }
        return result;
    }

    /**
     * 基于PDF的单元格，即使为同一行，其top坐标也可能略有不同，此常量用于兼容其误差范围，依据实际PDF情况进行调整
     * <br/>
     * 单位为：点
     */
    public static final int ARCO_FIELD_ROW_ALLOWABLE_ERROR = 3;
}
