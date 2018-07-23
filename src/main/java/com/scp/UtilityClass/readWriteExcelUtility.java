package com.scp.UtilityClass;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readWriteExcelUtility {

	public static void main(String[] args) {

		readTestData();

	}

	@SuppressWarnings("resource")
	
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
		System.out.println("Helllllllo"+testData[0][0].toString());

		System.out.println("Helllllllo"+testData[0][1].toString());

		System.out.println("Helllllllo"+testData[0][2].toString());
		return testData;

	}
}
