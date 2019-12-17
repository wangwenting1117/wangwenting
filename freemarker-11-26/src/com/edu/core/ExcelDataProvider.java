package com.edu.core;


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
import org.testng.annotations.Test;
/*
 * Excel数据驱动类
 */

public class ExcelDataProvider {



	public Object[][] getTestDataByExcel(String fileName, String sheetName)
			throws IOException {
		File file = new File(fileName);//文件路径和文件名
		FileInputStream inputstream = new FileInputStream(file);//创建fileinputstream对象用于读取Excel文件
		Workbook wbook = null;//声明workbook对象
		String fileExtensionName = fileName.substring(fileName.indexOf("."));//获取文件扩展名 判断是.xlsx文件还是.xls文件
		System.out.println(fileExtensionName);
		if (fileExtensionName.equals(".xlsx")) {
			wbook = new XSSFWorkbook(inputstream);
		
		} else if (fileExtensionName.equals(".xls")) {
			wbook = new HSSFWorkbook(inputstream);
		}//实例化 不同对象用不同的方法实例化
		Sheet sheet = wbook.getSheet(sheetName);
		// 通过sheetName生成Sheet对象
		
		//获取Excel数据文件sheet1中数据的行数，getLastRowNum方法获取数据的最后一行行号
		//getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
		//Excel行和列都是从0开始
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// 获取当前sheet行数，行号和列号都是从０开始
		List<Object[]> records = new ArrayList<Object[]>();
		//创建名为records的list对象来存储从Excel数据文件读取的数据
		// 使用双循环获取excel文件的所有数据（第一行除外）
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			//以下
			//声明一个数组，用来存储Excel数据文件每行中的数据
			//数组的大小用getLastCellNum办法来进行动态声明，实现测试数据个数和数组大小相一致
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// 调用getCell和getStringCellValue方法获取文件中的单元格数据
				fields[j] = row.getCell(j).getStringCellValue();
			}
			records.add(fields);//将fields中的数据兑现存储到records的list中
		}
		
		//以下
		//定义函数返回值，即Object的二维数组
		//将存储测试数据的list转换为一个Object的二维数组
		Object[][] results = new Object[records.size()][];
		//设置二维数组每行的值 每行是一个Object对象
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}
	

}
