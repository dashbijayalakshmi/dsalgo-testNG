package data;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utils.ExcelReader;

public class CommonDataProvider {
	@DataProvider(name = "data-provider-by-method-name")
	public Object[][] dataProviderByMethodName(Method m) {
		switch (m.getName()) {
		case "tc04_ValidCode":
			return new Object[][] { { "Code", 1, 1 } };
		case "tc05_InvalidCode":
			return new Object[][] { { "Code", 2, 1 } };
		}
		return null;
	}

	@DataProvider(name = "data-provider-valid-code")
	public Object[][] dataProviderValidCode() {
		int testCaseColumn = 0;
		int codeColmn = 1;
		String testCaseName = "ValidPythonCode";
		int testCaseRowNum = ExcelReader.getExcelRowNumberByValue("Code", testCaseName, testCaseColumn);
		String code = ExcelReader.getExcelValue("Code", testCaseRowNum, codeColmn);
		return new Object[][] { { code } };
	}

	@DataProvider(name = "data-provider-invalid-code")
	public Object[][] dataProviderInvalidCode() {
		int testCaseColumn = 0;
		int codeColmn = 1;
		String testCaseName = "InvalidPythonCode";
		int testCaseRowNum = ExcelReader.getExcelRowNumberByValue("Code", testCaseName, testCaseColumn);
		String code = ExcelReader.getExcelValue("Code", testCaseRowNum, codeColmn);
		return new Object[][] { { code } };
		
	}

	@DataProvider(name = "data-provider-valid-username-password")
	public Object[][] dataProvidervalidUsernamePassword() {
		int testCaseColumn = 0;
		int usernameColmn = 1;
		int passwordColmn = 2;
		String testCaseName = "ValidUsernamePassword";
		int testCaseRowNum = ExcelReader.getExcelRowNumberByValue("Code", testCaseName, testCaseColumn);
		String username = ExcelReader.getExcelValue("Code", testCaseRowNum, usernameColmn);
		String password = ExcelReader.getExcelValue("Code", testCaseRowNum, passwordColmn);
		
		
		return new Object[][] { { username, password  } };
		
	}

}
