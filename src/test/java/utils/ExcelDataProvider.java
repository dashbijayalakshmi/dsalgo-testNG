package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider 
{
	@DataProvider(name="login")
	public static Object[][] getLoginData() throws IOException
	{
		//Create object and pass sheet name
		Object[][] data = ExcelDataProvider.readDataFromExcel("LoginData");
		return data;
	}
	
	@DataProvider(name="Code")
	public static Object[][] getPythonCode() throws IOException
	{
		//Create object and pass sheet name
		Object[][] data = ExcelDataProvider.readDataFromExcel("Code");
		return data;
	}
	
	public static Object[][] readDataFromExcel(String sheetName) throws IOException
	{
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testData/dsalgo.xlsx");
	
		//create obj of XSSFworkbook 
		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		//no of rows and clols
		int rows = sheet.getLastRowNum(); //1
		int cols = sheet.getRow(0).getLastCellNum();//1
		
		Object[][]data = new Object[rows][cols];
		
		//for rows
		for (int i=0; i<rows; i++)
		{
			XSSFRow row = sheet.getRow(i+1);
		
			//for columns
			for (int j=0; j<cols; j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				//Check type of the values available in cells 
				switch (cellType)
				{
					case STRING:
						data[i][j]= cell.getStringCellValue();
						break;
					
					case NUMERIC:
						data[i][j]=	Integer.toString((int)cell.getErrorCellValue());
						break;
						
					case BOOLEAN:
						data[i][j]= cell.getBooleanCellValue();
				
				
				}
			}
		}
	return data;
	}
}
