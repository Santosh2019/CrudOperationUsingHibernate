package com.scp.CrudOperationUsingHibernate;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;  
import org.testng.annotations.Test;

import com.scp.TestLogic.TestLogic;

import junit.framework.Assert;

public class DataProvider1 {
	
	@Test(dataProvider="getDataDemo")	
	public void authanticate(String UserName, String Password, String result) {
		
	//	System.out.println("inside method **********");
		boolean b1=false;
		if(result.equalsIgnoreCase("true")) {
			b1=true;
			
		}
		System.out.println(/*"id "+employeeId+ "name "+employeeName+ "eslt ="+*/TestLogic.login(UserName,Password));
			Assert.assertEquals(b1, TestLogic.login(UserName,Password));
		
	}

	@DataProvider(name="getDataDemo")

	public static Object[][] readTestData() {

		Object[][] testData = new Object[8][3];

		int rowCount = 0;
		int cellCount = 0;
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook("E:\\testdata.xlsx");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			Iterator<Row> row = sheet.iterator();
			boolean flag = true;
			while (row.hasNext()) {
				Row singleRow = row.next();
				if (flag) {
					flag = false;
					continue;
				}

				System.out.println("\n");
				Iterator<Cell> cells = singleRow.iterator();
				while (cells.hasNext()) {
					Cell singleCell = cells.next();
					if (singleCell.getCellType() == 0) {
						// System.out.println((int)singleCell.getNumericCellValue()+"|");
					} else if (singleCell.getCellType() == 1) {

						String cellValue = singleCell.getStringCellValue().equals("NA") ? null: singleCell.getStringCellValue();

						testData[rowCount][cellCount] = cellValue;
						cellCount++;
						System.out.print(cellValue + " | ");
					} else {
						// System.out.println("Invalid cell tpe:"+singleCell.getCellType());
					}
				}
				rowCount++;
				cellCount = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("hello :"+testData[0][0].toString());

		System.out.println("hello 2:"+testData[0][1].toString());

		System.out.println(testData[0][2].toString());
		return testData;

	}

	
}
	
/*	
	@DataProvider(name="getdata")
	public Object[][] getData1() {
		
		Object object[][]=new Object[4][3];
		object[0][0]=12;
		object[0][1]="Swapnil";
		object[0][2]="true";
		
		
		object[1][0]=13;
		object[1][1]="Sachin";
		object[1][2]="true";
	
		object[2][0]=13;
		object[2][1]="Sachin";
		object[2][2]="true";
		
		object[3][0]=14;
		object[3][1]="Ninad";
		object[3][2]="true";
		
		
		return object;
	}
}*/
