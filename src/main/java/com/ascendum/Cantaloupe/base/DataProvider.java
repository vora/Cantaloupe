package com.ascendum.Cantaloupe.base;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataProvider extends TestBase {

    int sheetNo;

    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(sheetNo);
    XSSFRow row = sheet.getRow(sheetNo);
    XSSFCell cell;
    DataFormatter formateData = new DataFormatter();
    int noOfRows = sheet.getPhysicalNumberOfRows();
    int noOfColumns = row.getLastCellNum();

    public DataProvider() throws IOException {
    }

    @org.testng.annotations.DataProvider(name = "CantaloupeTestData")
    public Object[][] testData() throws Exception {

        Object[][] data = new Object[noOfRows - 1][noOfColumns];
        for (int row = 0; row < noOfRows - 1; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                if (formateData.formatCellValue(sheet.getRow(row + 1).getCell(column)) != null) {
                    data[row][column] = formateData.formatCellValue(sheet.getRow(row + 1).getCell(column));
                }
            }
        }
        fis.close();
        return data;
    }

    public boolean createOutputExcel(String nmls, String name) throws IOException {
        boolean booVal = false;
        File outfile = new File(System.getProperty("user.dir") + properties.getProperty("outputFile") + nmls + "_" + name + ".xlsx");
        if (outfile.exists()) {
            booVal = true;
        } else {
            XSSFWorkbook wb = new XSSFWorkbook(System.getProperty("user.dir") + properties.getProperty("template"));
            for (int i = 0; i <= wb.getNumberOfSheets(); i++) {
            }
            FileOutputStream out = new FileOutputStream(outfile);
            wb.write(out);
            out.close();
        }
        return booVal;
    }

    public int getRowIndex(String value, XSSFSheet sheet) {
        int rowIndex = 0;
        try {
            int noOfRows = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < noOfRows; i++) {

                if (formateData.formatCellValue(sheet.getRow(i).getCell(0)) != null) {
                    String cellValue = formateData.formatCellValue(sheet.getRow(i).getCell(0));
                    if (cellValue.trim().equalsIgnoreCase(value.trim())) {
                        row = sheet.getRow(i);
                        rowIndex = row.getRowNum();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            log.info(e);
        }
        return rowIndex;
    }

    public int getColumnIndex(String value) {
        int columnIndex = 0;
        for (int i = 0; i < noOfColumns; i++) {

            if (formateData.formatCellValue(sheet.getRow(0).getCell(i)) != null) {
                String cellValue = formateData.formatCellValue(sheet.getRow(0).getCell(i));
                if (cellValue.trim().equalsIgnoreCase(value)) {
                    columnIndex = sheet.getRow(0).getCell(i).getColumnIndex();
                    break;
                }
            }
        }
        return columnIndex;
    }
}
