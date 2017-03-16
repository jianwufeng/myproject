package com.crm.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.crm.exception.ValidationException;

public class ExcelUtils {

    public static final String NULL_STR = "NULL";
    public static final String BLANK_STR = "";

    public static void main(String[] args) {

    }

    public static <T> void transferToArrAndSetValue(HSSFWorkbook hssf, List<T> list, Class<T> clzz) throws IllegalArgumentException, IllegalAccessException {
        if (list == null || list.size() == 0) {
            return;
        }

        HSSFSheet sheet = hssf.getSheetAt(0);
        Field[] fields = clzz.getDeclaredFields();

        for (Field field : fields) {
            if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                // 判断是否 不需要导出
                ExportExcelPar notpar = field.getAnnotation(ExportExcelPar.class);
                if (notpar == null || (notpar != null && notpar.ifExport())) {
                    // 导出
                    field.setAccessible(true);
                }
            }

        }

        for (int i = 0; i < list.size(); i++) {
            List<String> strings = new ArrayList<String>();
            for (Field field : fields) {
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    // 判断是否 不需要导出
                    ExportExcelPar notpar = field.getAnnotation(ExportExcelPar.class);
                    if (notpar == null || (notpar != null && notpar.ifExport())) {
                        // 导出
                        String str = "";
                        Object o = field.get(list.get(i));
                        if (notpar == null) {
                            str = (o == null ? BLANK_STR : o.toString());
                        } else {
                            if (o != null) {
                                // 前缀/ 后缀
                                if (!BLANK_STR.equals(notpar.prefix())) {
                                    str = notpar.prefix();
                                }
                                str += o.toString();
                                if (!BLANK_STR.equals(notpar.postfix())) {
                                    str = str + notpar.postfix();
                                }
                            } else {
                                str += (notpar.ifShowNull() ? NULL_STR : BLANK_STR);
                            }
                        }
                        strings.add(str);
                    }
                }
            }
            for (int j = 0; j < strings.size(); j++) {
                setValue(sheet, i, j, strings);
            }
        }

    }

    private static void setValue(HSSFSheet sheet, int i, int j, List<String> strings) {
        HSSFCell cellTemp = null;
        if (j == 0) {
            cellTemp = sheet.createRow(i + 1).createCell(j);
            cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTemp.setCellValue(strings.get(j));
        } else {
            cellTemp = sheet.getRow(i + 1).createCell(j);
            cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTemp.setCellValue(strings.get(j));
        }
    }

    /**
     * 导出excel
     * 
     * @author howard
     * @param response
     * @param arr 表头列表
     * @param list 数据数组
     * @param clzz 数据对象类型
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> void export(HttpServletResponse response, String[] arr, List<T> list, Class<T> clzz) throws IllegalArgumentException,
            IllegalAccessException {
        // String arr[] = {"日期","1套","2-10套","11-50套","51-100套","101套"};
        HSSFWorkbook hssf = writeExcelFirst(arr, true);
        transferToArrAndSetValue(hssf, list, clzz);
        responseXLS("" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), response, hssf);
    }

    /**
     * 导出excel
     * 
     * @author howard
     * @param response
     * @param xlsName xcel名字前缀
     * @param arr 表头列表
     * @param list 数据数组
     * @param clzz 数据对象类型
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static <T> void export(HttpServletResponse response, String xlsName, String[] arr, List<T> list, Class<T> clzz) throws IllegalArgumentException,
            IllegalAccessException {
        // String arr[] = {"日期","1套","2-10套","11-50套","51-100套","101套"};
        HSSFWorkbook hssf = writeExcelFirst(arr, true);
        transferToArrAndSetValue(hssf, list, clzz);
        if (StringUtils.isBlank(xlsName)) {
            xlsName = "";
        }
        responseXLS(xlsName + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), response, hssf);
    }

    /**
     * true为写一行标题 false为写一列标题
     * 
     * @param arr
     * @param ifRow
     * @return
     */
    private static HSSFWorkbook writeExcelFirst(String[] arr, boolean ifRow) {
        HSSFWorkbook workbook = new HSSFWorkbook(); // 产生工作簿对象
        HSSFSheet sheet = workbook.createSheet(); // 产生工作表对象
        workbook.setSheetName(0, "default");
        sheet.setColumnWidth(0, 20 * 256);
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (ifRow) {
                HSSFCell cellTemp = null;
                if (i == 0) {
                    cellTemp = sheet.createRow(0).createCell(i);
                } else {
                    cellTemp = sheet.getRow(0).createCell(i);
                }
                cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTemp.setCellValue(arr[i]);
            } else {
                HSSFCell cellTemp = sheet.createRow(i).createCell(0);
                cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTemp.setCellValue(arr[i]);
            }

        }
        return workbook;
    }

    public static void responseXLS(String xlsName, HttpServletResponse response, HSSFWorkbook workbook) {
        OutputStream os = null;
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("content-disposition", "attachment;filename=" + xlsName + ".xls");
            // 写入到 客户端response
            os = response.getOutputStream();
            workbook.write(os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String changeCellToString(Cell cell) {
        String returnValue = "";

        if (null != cell) {

            switch (cell.getCellType()) {

                case HSSFCell.CELL_TYPE_NUMERIC: // 数字

                    Double doubleValue = cell.getNumericCellValue();
                    String str = doubleValue.toString();
                    BigDecimal bg = new BigDecimal(str);
                    str = bg.toPlainString();
                    if (str.endsWith(".0")) {
                        str = str.replace(".0", "");
                    }

                    returnValue = str;

                    break;

                case HSSFCell.CELL_TYPE_STRING: // 字符串

                    returnValue = cell.getStringCellValue();
                    break;

                case HSSFCell.CELL_TYPE_BOOLEAN: // 布尔

                    Boolean booleanValue = cell.getBooleanCellValue();

                    returnValue = booleanValue.toString();

                    break;

                case HSSFCell.CELL_TYPE_BLANK: // 空值

                    returnValue = "";

                    break;

                case HSSFCell.CELL_TYPE_FORMULA: // 公式

                    try {
                        returnValue = cell.getStringCellValue();
                    } catch (Exception e) {
                        returnValue = cell.getNumericCellValue() + "";
                    }

                    str = returnValue.toString();
                    try {
                        bg = new BigDecimal(str);
                        str = bg.toPlainString();
                        if (str.endsWith(".0")) {
                            str = str.replace(".0", "");
                        }
                    } catch (Exception e) {
                    }

                    returnValue = str;
                    break;

                case HSSFCell.CELL_TYPE_ERROR: // 故障

                    returnValue = "";

                    break;

                default:

                    System.out.println("未知类型");

                    break;

            }

        }

        return returnValue.trim();

    }

    /**
     * 读取excel内容
     *
     * @param excel
     * @param clzz 指定转换类
     * @param limitRow 读取限制行数大小
     * @param limitMsg 提示内容
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
    private static final String NO_EXCEL_ANNOTATIONS = "导入excel指定的实体类，没有扫描到ExcelAnnotations映射字段";

    @SuppressWarnings("unchecked")
    public static <T extends Object> List<T> readExcelContent(MultipartFile excel, Class<T> clzz, Integer limitRow, String limitMsg)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (excel == null || excel.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Assert.isTrue(excel.getSize() <= (1024 * 1024 * 3), "excel文件大小超过3M，请减少数据量分批上传！");

        Workbook readWorkBook = null;
        InputStream inputStream = null;
        String originalFilename = "";
        try {
            inputStream = excel.getInputStream();
            originalFilename = excel.getOriginalFilename();
            logger.info("读取====={}=====开始=====", originalFilename);
            readWorkBook = originalFilename.toLowerCase().endsWith(".xls") ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return readData(clzz, limitRow, limitMsg, readWorkBook, originalFilename);
    }

    /**
     *
     * @param declaredField
     * @param cell
     * @return
     */
    private static Object transformData(Field declaredField, Cell cell) {
        if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
            return null;
        }
        // 字段类型
        final String fieldType = declaredField.getGenericType().toString();
        Object data = null;
        String cellValue = changeCellToString(cell);
        if (StringUtils.isNotBlank(cellValue)) {
            if (fieldType.equals(Date.class.toString())) {
                return cell.getDateCellValue();
            } else if (fieldType.equals("int") || fieldType.equals(Integer.class.toString())) {
                data = Double.valueOf(cellValue.replaceAll("[\\u00A0]", "")).intValue();
            } else if (fieldType.equals(String.class.toString())) {
                data = String.valueOf(cellValue);
            } else if (fieldType.equals(Double.class.toString())) {
                data = Double.valueOf(cellValue);
            } else if (fieldType.equals(Long.class.toString())) {
                data = Long.valueOf(cellValue);
            } else if (fieldType.equals(BigDecimal.class.toString())) {
                data = BigDecimal.valueOf(Double.valueOf(cellValue));
            }
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> List<T> readExcelContent(File file, Class<T> clzz, Integer limitRow, String limitMsg) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        if (file == null) {
            return Collections.EMPTY_LIST;
        }
        Assert.isTrue(file.length() <= (1024 * 1024 * 3), "excel文件大小超过3M，请减少数据量分批上传！");

        Workbook readWorkBook = null;
        InputStream inputStream = null;
        String originalFilename = "";
        try {
            inputStream = new FileInputStream(file);
            originalFilename = file.getName();
            logger.info("读取====={}=====开始=====", originalFilename);
            readWorkBook = originalFilename.toLowerCase().endsWith(".xls") ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return readData(clzz, limitRow, limitMsg, readWorkBook, originalFilename);

    }

    @SuppressWarnings("unchecked")
    private static <T extends Object> List<T> readData(Class<T> clzz, Integer limitRow, String limitMsg, Workbook readWorkBook, String originalFilename)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 获取第一个工作表
        final Sheet sheetAt = readWorkBook.getSheetAt(0);
        // 得到总行数
        final int rowNum = sheetAt.getLastRowNum();
        if (limitRow != null) {
            Assert.isTrue(!(limitRow < rowNum), limitMsg + limitRow + "行");
        }
        // 返回结果
        List<T> result = new ArrayList<T>(rowNum - 1);
        final Field[] declaredFields = clzz.getDeclaredFields();
        List<Field> fields = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            // 扫描获得ExcelAnnotations所有字段名称
            if (declaredField.isAnnotationPresent(ExcelAnnotations.class)) {
                fields.add(declaredField);
            }
        }
        Assert.isTrue(!fields.isEmpty(), NO_EXCEL_ANNOTATIONS);
        // 声明转换的实体
        T entity = null;
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            final Row row = sheetAt.getRow(i);
            // 实例化实体
            entity = (T) Class.forName(clzz.getName()).newInstance();
            int j = 0;
            while (j < fields.size()) {
                Object data = null;
                final ExcelAnnotations declaredAnnotation = fields.get(j).getAnnotation(ExcelAnnotations.class);
                final String message = String.format(declaredAnnotation.msg(), i + 1, (j + 1));
                try {
                    data = transformData(fields.get(j), row.getCell(j));
                } catch (Exception e) {
                    throw new ValidationException(String.format("%s，或数据类型错误", message));
                }
                if (!declaredAnnotation.isAllowNull()) {
                    Assert.checkNotNull(data, message);
                }
                // 给实体字段赋值
                BeanUtils.setProperty(entity, fields.get(j).getName(), data);
                j++;
            }
            result.add(entity);
        }
        logger.info("读取====={}=====结束=====", originalFilename);
        return result;
    }

    public static List<Integer> readExcelContentSingleOneLine(MultipartFile excel, Integer limitRow, String limitMsg) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        if (excel == null) {
            return null;
        }
        Assert.isTrue(excel.getSize() <= (1024 * 1024 * 3), "excel文件大小超过3M，请减少数据量分批上传！");

        Workbook readWorkBook = null;
        InputStream inputStream = null;
        String originalFilename = "";
        try {
            inputStream = excel.getInputStream();
            originalFilename = excel.getOriginalFilename();
            logger.info("读取====={}=====开始=====", originalFilename);
            readWorkBook = originalFilename.toLowerCase().endsWith(".xls") ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return read2NumberData(limitRow, limitMsg, readWorkBook, originalFilename);

    }

    private static List<Integer> read2NumberData(Integer limitRow, String limitMsg, Workbook readWorkBook, String originalFilename)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 获取第一个工作表
        final Sheet sheetAt = readWorkBook.getSheetAt(0);
        // 得到总行数
        final int rowNum = sheetAt.getLastRowNum();
        if (limitRow != null) {
            Assert.isTrue(!(limitRow < rowNum), limitMsg + limitRow + "行");
        }
        // 返回结果
        List<Integer> result = new ArrayList<Integer>(rowNum - 1);

        // 正文内容应该从第二行开始,第一行为表头的标题
        Row row = null;
        for (int i = 1; i <= rowNum; i++) {
            row = sheetAt.getRow(i);
            try {
                Integer data = Integer.parseInt(changeCellToString(row.getCell(0)));
                result.add(data);
            } catch (Exception e) {
                throw new ValidationException(String.format("%s 行，或数据类型错误", i));
            }

        }
        logger.info("读取====={}=====结束=====", originalFilename);
        return result;
    }

    public static <T> File createExcel(String xlsName, List<T> list, Class<T> clzz) throws IllegalArgumentException, IllegalAccessException, Exception {
        HSSFWorkbook hssf = transferToArrAndSetValue(list, clzz);
        if (StringUtils.isBlank(xlsName)) {
            xlsName = "";
        }
        File file = new File(xlsName);
        FileOutputStream fos = new FileOutputStream(file);
        hssf.write(fos);
        return file;
    }

    public static <T> HSSFWorkbook transferToArrAndSetValue(List<T> list, Class<T> clzz) throws IllegalArgumentException, IllegalAccessException {
        if (list == null || list.size() == 0) {
            return null;
        }

        Field[] fields = clzz.getDeclaredFields();
        List<String> titles = new ArrayList<>();
        for (Field field : fields) {
            if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                // 判断是否 不需要导出
                ExportExcelPar notpar = field.getAnnotation(ExportExcelPar.class);
                if (notpar == null || (notpar != null && notpar.ifExport())) {
                    // 导出
                    field.setAccessible(true);
                    if (notpar == null)
                        titles.add(field.getName());
                    else
                        titles.add(notpar.title());
                }

            }

        }
        String[] titileTmp = new String[titles.size()];
        HSSFWorkbook hssf = writeExcelFirst(titles.toArray(titileTmp), true);
        HSSFSheet sheet = hssf.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            List<String> strings = new ArrayList<String>();
            for (Field field : fields) {
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    // 判断是否 不需要导出
                    ExportExcelPar notpar = field.getAnnotation(ExportExcelPar.class);
                    if (notpar == null || (notpar != null && notpar.ifExport())) {
                        // 导出
                        String str = "";
                        Object o = field.get(list.get(i));
                        if (notpar == null) {
                            str = (o == null ? BLANK_STR : o.toString());
                        } else {
                            if (o != null) {
                                // 前缀/ 后缀
                                if (!"".equals(notpar.prefix())) {
                                    str = notpar.prefix();
                                }
                                str += o.toString();
                                if (!"".equals(notpar.postfix())) {
                                    str = str + notpar.postfix();
                                }
                            } else {
                                str += (notpar.ifShowNull() ? NULL_STR : BLANK_STR);
                            }
                        }
                        strings.add(str);
                    }
                }
            }
            for (int j = 0; j < strings.size(); j++) {
                setValue(sheet, i, j, strings);
            }
        }
        return hssf;
    }

}
