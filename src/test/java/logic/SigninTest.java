package logic;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.Signinpageobjects;


public class SigninTest extends TestBase
{
	Signinpageobjects signinpage;
	
	@BeforeMethod
	public void click_loginlink() throws InterruptedException
	{
		test= extent.createTest("Test cases from the login module");
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();			
	}
	
	@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
	public void tc01_loginusingdataprovider(String username, String password) 
	{
		driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
		driver.findElement(By.id("id_password")).sendKeys(password);
		signinpage.click_login_btn();
		if(driver.getTitle().equals("NumpyNinja"))
		{
			test.pass("User has loggedin successfully");
		}
		else
		{
			test.fail("User cpouldn't login");
		}
		
	}
	
	@Test
	public void tc01_validuserpass() 
	{	
		Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.enter_username("npatni");
	}
//	
//	@Test
//	public void tc02_validuserpass() throws InterruptedException
//	{
//		//Signinpageobjects signinpage = new Signinpageobjects(driver);
//		signinpage.enter_username("npatni1");
//		Thread.sleep(5000);
//	}

}
