package com.crm.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crm.service.IUserService;
import com.crm.util.excel.ExcelUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring.xml" })
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void getUserName() {
        System.out.println(userService.getUserName(115));
    }

    @Test
    public void test2() throws Exception {

        InputStream instream = new FileInputStream("C:/Users/aoc/Desktop/客户.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(instream);

        EntepriseName entepriseName = null;

        List<EntepriseName> list = new ArrayList<EntepriseName>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    entepriseName = new EntepriseName();
                    HSSFCell id = hssfRow.getCell(0);
                    HSSFCell name = hssfRow.getCell(1);
                    HSSFCell displayName = hssfRow.getCell(2);
                    entepriseName.setId(String.valueOf(id.getNumericCellValue()));
                    entepriseName.setName(String.valueOf(name.getStringCellValue()));
                    entepriseName.setDisplayName(String.valueOf(displayName.getStringCellValue()));
                    list.add(entepriseName);
                }
            }
        }

        List<EnterpriseCompetitive> exportList = new ArrayList<EnterpriseCompetitive>();
        for (EntepriseName enterprise : list) {
            EnterpriseCompetitive view = new EnterpriseCompetitive();
            view.setEnterpriseId(enterprise.getId());
            view.setName(enterprise.getName());
            view.setDisplayName(enterprise.getDisplayName());
            view.setCompositeIndex(5.0F);
            view.setCountPosition(100);
            exportList.add(view);
            System.out.println(exportList.size());
        }
        ExcelUtils.createExcel("测试.xls", exportList, EnterpriseCompetitive.class);

        // 导出为.csv
        // List<String> fileContent = new ArrayList<String>();
        //
        // StringBuilder build = new StringBuilder();
        // build.append("id").append(",").append("name").append(",").append("displayName").append(",").append("综合指数").append(",").append("职位数");
        // fileContent.add(build.toString());
        //
        // for (EnterpriseCompetitive enterpriseCompetitive : exportList) {
        //
        // build = new StringBuilder();
        // build.append(enterpriseCompetitive.getEnterpriseId()).append(",").append(enterpriseCompetitive.getName()).append(",")
        // .append(enterpriseCompetitive.getDisplayName()).append(",").append(enterpriseCompetitive.getCompositeIndex()).append(",")
        // .append(enterpriseCompetitive.getCountPosition());
        // fileContent.add(build.toString());
        // }
        //
        // BulidFile.buildFile(fileContent, "E:/enterprise.csv");

        // String[] arr = { "id", "name", "displayName", "综合指数", "职位数" };
        // try {
        // ExcelUtils.export(response, arr, exportList, EnterpriseCompetitive.class);
        // } catch (IllegalArgumentException | IllegalAccessException e) {
        // e.printStackTrace();
        // }
    }
}
