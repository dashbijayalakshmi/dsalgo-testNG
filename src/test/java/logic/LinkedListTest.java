package logic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LinkedlistPageObject1;
import pageObjects.Run_PythonCodes;
import pageObjects.Signinpageobjects;



public class LinkedListTest extends TestBase
{
	Signinpageobjects signinpage;
	LinkedlistPageObject1 linkedlistpageobj;
	Run_PythonCodes runpythoncode;
	@BeforeMethod()
	public void login()
	{
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();
		signinpage.enter_username("ninjatesterss");
		signinpage.enter_password("ninja@123");
		signinpage.click_login_btn();
		linkedlistpageobj = new LinkedlistPageObject1(driver);
		linkedlistpageobj.click_linkedlist_getstarted();
	}
//	@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
//	public void tc01_loginusingdataprovider(String username, String password) 
//	{
//		driver.get().findElement(By.cssSelector("#id_username")).sendKeys(username);
//		driver.get().findElement(By.id("id_password")).sendKeys(password);
//		signinpage.get().click_login_btn();	
//	}
//	
	@Test
	public void tc02_oot_page() 
	{
		linkedlistpageobj.click_introduction_of_Linkedlist();
		String actualtitle = linkedlistpageobj.get_Title();
		String expectedtitle = "Introduction of Linkedlist";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
	}
	@Test
	public void tc03_tryhere_oot() 
	{
		
		linkedlistpageobj.click_introduction_of_Linkedlist();;
		linkedlistpageobj.click_TryHere_from_IntroductionofLinkedlist(); 
		String actualt_title = linkedlistpageobj.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);
		System.out.println("User is on the Try Editor Page");	
}
	@Test
	public void tc04_validPyhtoncode_oot()
	{
		linkedlistpageobj.click_introduction_of_Linkedlist();;
		linkedlistpageobj.click_TryHere_from_IntroductionofLinkedlist(); 
		//runpythoncode = new Run_PythonCodes();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();
	}
	@Test
	public void tc05_invalid_code_oot()
	{
		linkedlistpageobj.click_introduction_of_Linkedlist();;
		linkedlistpageobj.click_TryHere_from_IntroductionofLinkedlist(); 
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		//runpythoncode = new Run_PythonCodes();
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();
	}

	@Test
	public void tc06_gobackfromoot()
	{
		linkedlistpageobj.click_introduction_of_Linkedlist();;
		linkedlistpageobj.click_TryHere_from_IntroductionofLinkedlist(); 
		linkedlistpageobj.goback_frmTryeditor();
		  
		String actualtitle = linkedlistpageobj.get_Title();
		String expectedtitle = "Introduction of Linkedlist";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
		linkedlistpageobj.contents_on_outpage();
}
	@Test
	public void tc07_CreatingLinkedlist()
	{
		linkedlistpageobj.click_CreatingLinkedlist();
		String actual_title = linkedlistpageobj.get_Title();
		String expected_title = "Creating Linked LIst";
		assertEquals(expected_title, actual_title);
		System.out.println("User is on the " + actual_title + " Page");
	}
	

@Test
public void tc08_editorpage_ter()
{
	linkedlistpageobj.click_CreatingLinkedlist();
	linkedlistpageobj.click_tryHere_on_CreatingLinkedlist();
    String actual_tit = linkedlistpageobj.get_Title();
	String Expected_tit = "Assessment";
	assertEquals(Expected_tit, actual_tit);
	System.out.println("User is on the " + actual_tit + " Page of Creating Linked list section");
}

@Test
public void tc09_validcode_ter()
{
	linkedlistpageobj.click_CreatingLinkedlist();
	linkedlistpageobj.click_tryHere_on_CreatingLinkedlist();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	//runpythoncode = new Run_PythonCodes();
	runpythoncode.validcode_editor();
	runpythoncode.run_button();
	runpythoncode.Ouptput_ValidCode();	
}

@Test
public void tc10_invalidcode_ter()
{
	
	linkedlistpageobj.click_CreatingLinkedlist();
	linkedlistpageobj.click_tryHere_on_CreatingLinkedlist();
	Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
	//runpythoncode = new Run_PythonCodes();
	runpythoncode.invalidcode_editor();
	runpythoncode.run_button();
	runpythoncode.error_alert();	
}

@Test
public void tc11_goback_ter()
{
	
	linkedlistpageobj.click_CreatingLinkedlist();
	linkedlistpageobj.click_tryHere_on_CreatingLinkedlist();
	linkedlistpageobj.goback_frmTryeditor();
	String actualtitle = linkedlistpageobj.get_Title();
	String expectedtitle = "Creating Linked LIst";
	assertEquals(expectedtitle, actualtitle);
	System.out.println("User is on the" + expectedtitle + "page");
	linkedlistpageobj.contents_on_outpage();
}

}
