package logic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObjects.Signinpageobjects;
import pageObjects.landingpageobjects;
import utils.TestContextSetup;


public class SigninTest extends TestBase
{
	Signinpageobjects signinpage;
	
	@BeforeMethod
	public void click_loginlink() throws InterruptedException
	{
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();			
	}
	
	@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
	public void tc01_loginusingdataprovider(String username, String password) 
	{
		driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
		driver.findElement(By.id("id_password")).sendKeys(password);
		signinpage.click_login_btn();	
	}
	
	@Test
	public void tc01_validuserpass() throws InterruptedException
	{
		//Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.enter_username("npatni");
		Thread.sleep(5000);
	}
	
	@Test
	public void tc02_validuserpass() throws InterruptedException
	{
		//Signinpageobjects signinpage = new Signinpageobjects(driver);
		signinpage.enter_username("npatni1");
		Thread.sleep(5000);
	}

}
