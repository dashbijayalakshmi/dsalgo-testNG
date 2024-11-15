package logic;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

import pageObjects.RegistrationPageObj;
import pageObjects.Signinpageobjects;
import pageObjects.TreePageObjects;
import pageObjects.landingpageobjects;

public class RegistrationTest extends TestBase
{
	RegistrationPageObj regpageobj;
	landingpageobjects landingpageobj;
	
	@BeforeMethod()
	public void login()
	{
		test = extent.createTest("Test cases from the Tree module");
		regpageobj.click_register_link();
		String exp_tit="Registration";
	    String actual_tit=landingpageobj.get_Title();
	    assertEquals(exp_tit,actual_tit);
	    System.out.println("User is on the "+actual_tit+" Page");		
	}
	
	
	
	
	

}
