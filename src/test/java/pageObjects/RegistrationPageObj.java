package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.TestContextSetup;

public class RegistrationPageObj {
	
	private By register_link=By.xpath("//ul/a[@href='/register']");
	private By username_availibility=By.xpath("//div/form/label[@for='id_username']");
	private By password_availibility=By.xpath("//div/form/label[@for='id_password1']");
	private By confirm_passwd_availibilty=By.xpath("//div/form/label[@for='id_password2']");
	private By username=By.id("id_username");
	private By password=By.id("id_password1");
	private By confirm_password=By.id("id_password2");
	private By register_button=By.xpath("//input[@value=\"Register\"]");
	private By error_invalid_input=By.xpath("//div[@class='alert alert-primary']");
	private By newuser_success_msg=By.xpath("//div[@class='alert alert-primary' and contains(text(),\"New Account Created\")]");
	
public DriverFactory driverfactory;
	
	WebDriver driver;
	public RegistrationPageObj(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}
	
	
	public void click_register_link()
	{
		driver.findElement(register_link).click();
	}
	public void enter_username_regpage(String string)
	{
		driver.findElement(username).sendKeys(string);
	}
	public void enter_password_regpage(String string1)
	{
		driver.findElement(password).sendKeys(string1);
	}
	public void enter_confirmpassword_regpage(String string2)
	{
		driver.findElement(confirm_password).sendKeys(string2);
	}
	public String username_availability()
	{
		 return driver.findElement(username_availibility).getText();
	}
	public String password_availibility()
	{
		return driver.findElement(password_availibility).getText();
	}
	public String confirm_passwd_availibilty()
	{
		return driver.findElement(confirm_passwd_availibilty).getText();
	}
	
	public void enter_password_confirmation(String string)
	{
		driver.findElement(confirm_password).sendKeys(string);
	}
	public void press_tab_username()
	{
		driver.findElement(username).sendKeys(Keys.TAB);
	}
	public void press_tab_password()
	{
		driver.findElement(password).sendKeys(Keys.TAB);
	}
	public void press_tab_confirmpassword()
	{
		driver.findElement(confirm_password).sendKeys(Keys.TAB);
	}
	public void click_register_button()
	{
		driver.findElement(register_button).click();
	}
	public void error_username_req()
	{
		String message=driver.findElement(username).getAttribute("validationMessage");
		boolean username_error_dispalyed=message.matches("Please fill out this field.");
		Assert.assertTrue(username_error_dispalyed, "FAILED Error doesn't exist");
		System.out.println("PASSED Error - "+message+ " displayed when username is blank");
		
	}
	public void error_pass_req()
	{
		String message1=driver.findElement(password).getAttribute("validationMessage");
		boolean password_error_displayed=message1.matches("Please fill out this field.");
		Assert.assertTrue(password_error_displayed, "FAILED Error doesn't exist");
		System.out.println("PASSED Error - "+message1+ " displayed when password is blank");
	}
	public void error_confirm_pass_req()
	{
		String message2=driver.findElement(confirm_password).getAttribute("validationMessage");
		boolean confirmpswd_error_displayed=message2.matches("Please fill out this field.");
		Assert.assertTrue(confirmpswd_error_displayed, "FAILED Error doesn't exist");
		System.out.println("PASSED Error - "+message2+ " displayed when password is blank");
	}
	public void error_invalid_username_spacebar()
	{
		String actual_error_message=driver.findElement(error_invalid_input).getText();
		String expected_error_message="Username can not have space";
		boolean result=(expected_error_message.equals(actual_error_message));
		Assert.assertTrue(result, "FAILED - Incorrect error message displayed. Expected message is: "+expected_error_message);
		System.out.println("PASSED - New user wasn't created and error message "+expected_error_message+ " displayed");
	}
	public void error_invalid_password_lessthan8char()
	{
		String actual_error_message=driver.findElement(error_invalid_input).getText();
		String expected_error_message="Password can not be less than eight characters";
		boolean result=(expected_error_message.equals(actual_error_message));
		Assert.assertTrue(result, "FAILED - Incorrect error message displayed. Expected message is: "+expected_error_message);
		System.out.println("PASSED - New user wasn't created and error message "+expected_error_message+ " displayed");
	}
	public void error_invalid_password_numeric()
	{
		String actual_error_message=driver.findElement(error_invalid_input).getText();
		String expected_error_message="Password can not be only numeric";
		boolean result=(expected_error_message.equals(actual_error_message));
		Assert.assertTrue(result, "FAILED - Incorrect error message displayed. Expected message is: "+expected_error_message);
		System.out.println("PASSED - New user wasn't created and error message "+expected_error_message+ " displayed");
	}
	public void error_invalid_passwordandConfirmpassword()
	{
		String actual_error_message=driver.findElement(error_invalid_input).getText();
		String expected_error_message="password_mismatch:The two password fields didn’t match.";
		boolean result=(expected_error_message.equals(actual_error_message));
		Assert.assertTrue(result, "FAILED - Incorrect error message displayed. Expected message is: "+expected_error_message);
		System.out.println("PASSED - New user wasn't created and error message "+expected_error_message+ " displayed");
	}
	public void error_existing_username()
	{
		String actual_error_message=driver.findElement(error_invalid_input).getText();
		String expected_error_message="User already exists";
		boolean result=(expected_error_message.equals(actual_error_message));
		Assert.assertTrue(result, "FAILED - Incorrect error message displayed. Expected message is: "+expected_error_message);
		System.out.println("PASSED - New user wasn't created and error message "+expected_error_message+ " displayed");
	}
	public void newuser_susscess_message()
	{
		boolean message=driver.findElement(newuser_success_msg).isDisplayed();
		//String expected_message="New Account Created. You are logged in as ";
		Assert.assertTrue(message, "FAILED New User wasn't created");
		System.out.println("Test Case PASSED " +message);
	}
}
