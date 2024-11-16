package logic;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.RegistrationPageObj;
import pageObjects.landingpageobjects;
import utils.ExcelReader;

public class RegistrationTest extends TestBase
{
	RegistrationPageObj regpageobj;
	landingpageobjects landingpageobj;
	ExcelReader ExcelReader;
	@BeforeMethod()
	public void login()
	{
		test = extent.createTest("Test cases from the Tree module");
		regpageobj = new RegistrationPageObj(driver);
		landingpageobj = new landingpageobjects(driver);
		ExcelReader = new ExcelReader();
		regpageobj.click_register_link();
		String exp_tit="Registration";
	    String actual_tit=landingpageobj.get_Title();
	    assertEquals(exp_tit,actual_tit);
	    System.out.println("User is on the "+actual_tit+" Page");		
	}
	
	
	@Test
	public void tc01_usernamefield()
	{
		String expected_username_field="Username:";
	    String actual_username_field=regpageobj.username_availability();
	    boolean result=(expected_username_field.equals(actual_username_field));
	    Assert.assertTrue(result, "FAILED expected field "+expected_username_field+" is not present");
	    System.out.println("PASSED expected field "+expected_username_field+" is present ");
	}
	
	@Test
	public void tc02_passwordfield()
	{
		String actual_Password_field=regpageobj.password_availibility(); 
	      String expected_password_field="Password:";
	      boolean result1=(expected_password_field.equals(actual_Password_field));
	      Assert.assertTrue(result1, "FAILED expected field "+expected_password_field+" is not present");
	      System.out.println("PASSED expected field "+expected_password_field+" is present "); 
	}
	
	@Test
	public void tc03_confirmpasswordfield()
	{
	  String actual_confirm_Password_field=regpageobj.confirm_passwd_availibilty(); 
      String expected_confirm_password_field="Password confirmation:";
      boolean result2=(expected_confirm_password_field.equals(actual_confirm_Password_field));
      Assert.assertTrue(result2, "FAILED expected field "+expected_confirm_password_field+" is not present");
      System.out.println("PASSED expected field "+expected_confirm_password_field+" is present ");   
	}
	
	
	
	
	
	
	
	
	
	
	
}
