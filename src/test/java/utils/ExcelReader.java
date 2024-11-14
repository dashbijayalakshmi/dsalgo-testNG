package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	


	
		private static String excelFilePath = "testData/dsalgo.xlsx";

		public static String getCellValue(XSSFCell cell) {
			switch (cell.getCellType()) {
			case STRING:
			return cell.getStringCellValue();
			default:
				return cell.getStringCellValue();

				
			}
		}

		public static String getExcelValue(String sheetName,int rowNumber, int columNumber) {
			String value = "";
			try {
				InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream(excelFilePath);
				XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);
				XSSFSheet excelSheet = excelWorkbook.getSheet(sheetName);
				XSSFRow row = excelSheet.getRow(rowNumber);
				XSSFCell cell = row.getCell(columNumber);
				value = getCellValue(cell);
				excelWorkbook.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return value;
		}
		


	}





