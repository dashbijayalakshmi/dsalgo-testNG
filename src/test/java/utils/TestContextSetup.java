package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManger;

public class TestContextSetup {
public WebDriver driver;
public PageObjectManger pageobjectmanager;
public ConfigReader configreader;
public DriverFactory driverfactory;

public TestContextSetup() throws Throwable {
	//pageobjectmanager=new PageObjectManger(testbase.WebDriverManager());
	driverfactory=new DriverFactory();
	String browser = ConfigReader.getBrowserType();
	//configreader.getBrowserType();
	//pageobjectmanager=new PageObjectManger(driverfactory.initializeDrivers(browser));
}
}
