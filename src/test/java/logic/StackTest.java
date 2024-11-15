package logic;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Run_PythonCodes;
import pageObjects.Signinpageobjects;
import pageObjects.StackPageObject;


public class StackTest extends TestBase {
	Signinpageobjects signinpage;
	StackPageObject stackpageobj;
	Run_PythonCodes runpythoncode;
	//WebDriver driver=getdriver();
	@BeforeMethod()
	public void login()
	{
		test = extent.createTest("Test cases from the Stack module");
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();
		signinpage.enter_username("ninjatesterss");
		signinpage.enter_password("ninja@123");
		signinpage.click_login_btn();
		stackpageobj = new StackPageObject(driver);
		stackpageobj.click_stack_getstarted();
	}
//	@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
//	public void tc01_loginusingdataprovider(String username, String password) 
//	{
//		driver.get().findElement(By.cssSelector("#id_username")).sendKeys(username);
//		driver.get().findElement(By.id("id_password")).sendKeys(password);
//		signinpage.get().click_login_btn();	
//	}
	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc01_reqtreeltopics() throws InterruptedException
	{
		StackPageObject stackpageobj = new StackPageObject(driver);
		stackpageobj.stack_topics_covered_section();
		List<String> Expected_list = Arrays.asList("Overview of Trees","Terminologies","Types of Trees","Tree Traversals","Traversals-Illustration","Binary Trees","Types of Binary Trees","Implementation in Python","Binary Tree Traversals","Implementation of Binary Trees","Applications of Binary trees","Binary Search Trees","Implementation Of BST");
		List<String> Actual_list = stackpageobj.stack_topicscovered_list();
		System.out.println("Expected List is:" + Expected_list);
		System.out.println("Actual List is:" + Actual_list);
		Assert.assertEquals(Expected_list, Actual_list, "List is not present");
	}
	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc02_oot_page() 
	{
		stackpageobj.click_operations_in_Stack();
		String actualtitle = stackpageobj.get_Title();
		String expectedtitle = "Operations in Stack";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
	}
	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc03_tryhere_oot() 
	{
		stackpageobj.click_operations_in_Stack();
		stackpageobj.click_TryHere_from_Operationsinstack();
		String actualt_title = stackpageobj.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);
		System.out.println("User is on the Try Editor Page");		
	}
	

	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
public void tc04_validPyhtoncode_oot()
{
	stackpageobj.click_operations_in_Stack();
	stackpageobj.click_TryHere_from_Operationsinstack();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	//runpythoncode = new Run_PythonCodes();
	runpythoncode.validcode_editor();
	runpythoncode.run_button();
	runpythoncode.Ouptput_ValidCode();
}

@Test
public void tc05_invalid_code_oot()
{
	stackpageobj.click_operations_in_Stack();
	stackpageobj.click_TryHere_from_Operationsinstack();
	//runpythoncode = new Run_PythonCodes();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	runpythoncode.invalidcode_editor();
	runpythoncode.run_button();
	runpythoncode.error_alert();
}

@Test
public void tc06_gobackfromoot()
{
	stackpageobj.click_Implementation();
	stackpageobj.click_tryHere_on_Implementation();
	stackpageobj.goback_frmTryeditor();
	String actualtitle = stackpageobj.get_Title();
	String expectedtitle = "Implementation";
	assertEquals(expectedtitle, actualtitle);
	System.out.println("User is on the" + expectedtitle + "page");
	stackpageobj.contents_on_outpage();

}
@Test
public void tc07_Implementation()
{
	stackpageobj.click_Implementation();
	String actual_title = stackpageobj.get_Title();
	String expected_title = "Implementation";
	assertEquals(expected_title, actual_title);
	System.out.println("User is on the " + actual_title + " Page");
}

@Test
public void tc08_editorpage_ter()
{
	stackpageobj.click_Implementation();
	stackpageobj.click_tryHere_on_Implementation();
	String actual_tit = stackpageobj.get_Title();
	String Expected_tit = "Assessment";
	assertEquals(Expected_tit, actual_tit);
	System.out.println("User is on the " + actual_tit + " Page of Implementation section");
}

@Test
public void tc09_validcode_ter()
{
	stackpageobj.click_Implementation();
	stackpageobj.click_tryHere_on_Implementation();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	//runpythoncode = new Run_PythonCodes();
	runpythoncode.validcode_editor();
	runpythoncode.run_button();
	runpythoncode.Ouptput_ValidCode();	
}

@Test
public void tc10_invalidcode_ter()
{
	stackpageobj.click_Implementation();
	stackpageobj.click_tryHere_on_Implementation();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	//runpythoncode = new Run_PythonCodes();
	runpythoncode.invalidcode_editor();
	runpythoncode.run_button();
	runpythoncode.error_alert();	
}

@Test
public void tc11_goback_ter()
{
	
	stackpageobj.click_Implementation();
	stackpageobj.click_tryHere_on_Implementation();
	stackpageobj.goback_frmTryeditor();
	String actualtitle = stackpageobj.get_Title();
	String expectedtitle = "Implementation";
	assertEquals(expectedtitle, actualtitle);
	System.out.println("User is on the" + expectedtitle + "page");
	stackpageobj.contents_on_outpage();
}
}