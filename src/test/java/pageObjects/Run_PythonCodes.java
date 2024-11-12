package pageObjects;



import java.sql.DriverAction;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;


public class Run_PythonCodes {
	
	
	
	private By Editor_input_box=By.xpath("//div[@class='input']");
	private By run_button=By.xpath("//form/button[text()='Run']");
	private By output_panel=By.id("output");
	private By Editor_input_box_OverviewofTrees=By.xpath("//div[@class='input']");
    private By Editor_input_box_introduction=By.xpath("//*[@id=\"answer_form\"]/div/div/div[6]");
	public WebDriver driver;
	public Run_PythonCodes (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void validcode_editor()
	{
		WebElement validcode=driver.findElement(Editor_input_box);
		new Actions(driver).sendKeys(validcode,"print('Hello it is a Valid Python Code')").perform();
		 
	}
	
	public void run_button()
	{
		driver.findElement(run_button).click();
	}
	
	public void Ouptput_ValidCode()
	{
		WebElement output=driver.findElement(output_panel);
		String result = output.getText();
		System.out.println("The output of valid Python code is:" +result);
		
	}
	

	public void invalidcode_editor()
	{
		WebElement invalidcode=driver.findElement(Editor_input_box_OverviewofTrees);
		new Actions(driver).sendKeys(invalidcode,"p('Invalid Code')").perform();
	}
	

	public void error_alert()
	{
		Alert alert = driver.switchTo().alert();
		String alert_message=alert.getText();
		System.out.println("Error occured is: " +alert_message);
        alert.accept();
	}
}
