package logic;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.Signinpageobjects;
import pageObjects.landingpageobjects;
import utils.ExcelDataProvider;


public class SigninTest extends TestBase
{
	Signinpageobjects signinpage;
	landingpageobjects landingpage;
	
	@BeforeMethod
	public void click_loginlink() throws InterruptedException
	{
		test= extent.createTest("Test cases from the login module");
		signinpage = new Signinpageobjects(driver);
		landingpage = new landingpageobjects(driver);
		signinpage.click_signin_link();			
	}
	
	
	@Test(dataProvider="login" ,dataProviderClass=ExcelDataProvider.class)
	public void getlogindatafromExcel(String username, String password) 
	{
		driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
		driver.findElement(By.id("id_password")).sendKeys(password);
		signinpage.click_login_btn();
		String expectedLandingPage = "NumpyNinja";
		String actualLandingPage=landingpage.get_Title();
		Assert.assertEquals(expectedLandingPage, actualLandingPage, "Please enter valid Username & Password to login");
	}
	
}