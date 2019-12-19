package com.edu.test.wzhangxiao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataProvider {
	public static Object[][] getTestDataByExcel(String fileName, String sheetName,int col) throws IOException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = null;
		int rowCount;
		String[][] arr_testdata=null;
		wb=new XSSFWorkbook(fis);
		Sheet sheet=wb.getSheet(sheetName);
		//计算Excel中有多少行数据
		rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
//		System.out.println(rowCount);
		//通过行数来初始化二维数组
		arr_testdata=new String[rowCount][col];
		//通过for循环从文件中把数据一行一行读到arr_testdata[][]中
		for(int i=1;i<=rowCount;i++){
			Row row=sheet.getRow(i);
			for(int j=0;j<col;j++){
				arr_testdata[i-1][j]=row.getCell(j).getStringCellValue();
			}
		}
		wb.close();
		fis.close();
		return arr_testdata;
	}
//	public static void main(String[] args) throws Exception {
//		Object[][] data = ExcelDataProvider.getTestDataByExcel("E:/zhangxiao/TestData/UrlData.xlsx", "sheet1",1);
//		System.out.println(data.length);
//		for(int i=0;i<data.length;i++){
//			for(int j=0;j<1;j++){
//				System.out.println(data[i][j]);
//			}
//		}
//	}
}
