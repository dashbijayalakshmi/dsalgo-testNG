package logic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.Signinpageobjects;
import pageObjects.landingpageobjects;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentReport;

public class TestBase 
{
	
	landingpageobjects landingpage;
	Signinpageobjects signinpage;



    DriverFactory driverfactorypage;

	ConfigReader configreaderfile;	
    protected WebDriver driver;
	private By getStarted = By.linkText("Get Started");
	ExtentSparkReporter htmlReporter;
	static ExtentReports extent;
	public ExtentTest test;
	

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DriverFactory.class);

  
	
	public TestBase() {
		// Set up a simple configuration that logs on the console.
	    BasicConfigurator.configure();
	}
	
	//To generate Extent Report
	@BeforeSuite
	public void extentreportsetup()
	{
		extent = new ExtentReports();
		extent.attachReporter(new ExtentSparkReporter("extententReport.html"));
		
	}

	 
	@BeforeMethod
	@Parameters("browser")
	public void bbefore(String browser) throws Throwable
	{	
		driverfactorypage = new DriverFactory();
		driver = driverfactorypage.initializeDrivers(browser);
		System.out.println(driver);

		
		String path = System.getProperty("user.dir") + "/src/test/resources/global.properties";
        FileInputStream fis = new FileInputStream(path);
       Properties prop = new Properties();
       prop.load(fis);
       String url = prop.getProperty("URL");
		driver.get(url);
	System.out.println("Opening the url from properties file");
		driver.findElement(getStarted).click();		
	}
	

	
	public static WebDriver getdriver()
	{
		return DriverFactory.getdriver();
		
	}
	
	@DataProvider (name="Logindataprovider")
	public Object [][] dataprovider_method()
	{
		return new Object[][] {{"ninjatesterss" , "ninja@123"}};
	}
	//Close the browser and set extent report status
	@AfterMethod(alwaysRun = true)
	public void after(ITestResult result) throws Exception
	{
		System.out.println("Closing the browser");
		driver.quit();	
		
		if (result.getStatus() == ITestResult.FAILURE) {
	        test.log(Status.FAIL,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test case FAILED due to below issues:",
	                        ExtentColor.RED));
	        test.fail(result.getThrowable());
	        String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
	        //test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/ScreenShot","failed test case");
	        
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        test.log(
	                Status.PASS,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test Case PASSED", ExtentColor.GREEN));
	    } else {
	        test.log(
	                Status.SKIP,
	                MarkupHelper.createLabel(result.getName()
	                        + " Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
		//extent.flush();
	}
	
	@AfterSuite
	public void flushExtent()
	{
		extent.flush();
	}
	
	
	

	
	
}
