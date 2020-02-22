package com.testcases;

import org.testng.annotations.Test;

import com.util.ExcelUtility;

public class TestExcel {
	ExcelUtility reader = new ExcelUtility("./src/main/java/com/testdata/NewiQaptureData.xlsx");
	
	@Test
	public void readExcelData() {
		for (int i = 2; i <= 5; i++) {
			String c0 = reader.getCellData("captureDD", 0, i);
			String c1 = reader.getCellData("captureDD", 1, i);
			String c2 = reader.getCellData("captureDD", 2, i);
			String c3 = reader.getCellData("captureDD", 3, i);
			String c4 = reader.getCellData("captureDD", 4, i);
			String c5 = reader.getCellData("captureDD", 5, i);
			System.out.println(c0+"   "+c1+"   "+c2+"   "+c3+"   "+c4+"   "+c5);
		}
	}
	
	
}
