package com.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public String readExcel(String sheet, int rownum, int cellnum) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String excelData = wb.getSheet(sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		return excelData;
	}
	
	public void writeExcel(String sheetName, int rownum, int cellnum, String userResult) throws IOException {
		FileInputStream fis=new FileInputStream(InstancePath.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		 
		Sheet sheet = wb.getSheet(sheetName);
		Row rowNum=sheet.getRow(rownum);
		Cell cellNum=rowNum.getCell(cellnum);
		cellNum.setCellValue(userResult);
		FileOutputStream fos=new FileOutputStream(InstancePath.excelPath);
		wb.write(fos);
		wb.close();
	}

}
