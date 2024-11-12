package logic;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import pageObjects.Run_PythonCodes;
import pageObjects.Signinpageobjects;
import pageObjects.TreePageObjects;

public class TreeTest extends TestBase
{
	Signinpageobjects signinpage;
	TreePageObjects treepageobj;
	
	@BeforeMethod()
	public void login()
	{
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();
		signinpage.enter_username("ninjatesterss");
		signinpage.enter_password("ninja@123");
		signinpage.click_login_btn();
		treepageobj = new TreePageObjects(driver);
		treepageobj.click_tree_getstarted();
	}
	
//	@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
//	public void tc01_loginusingdataprovider(String username, String password) 
//	{
//		signinpage = new Signinpageobjects(driver);
//		signinpage.click_signin_link();
//		driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
//		driver.findElement(By.id("id_password")).sendKeys(password);
//		signinpage.click_login_btn();	
//	}
	
//	@Test
//	public void tc01_reqtreeltopics() throws InterruptedException
//	{
//		TreePageObjects treepageobj = new TreePageObjects(driver);
//		treepageobj.tree_topics_covered_section();
//		List<String> Expected_list = TreeTopics.asList();
//		List<String> Actual_list = treepageobj.tree_topicscovered_list();
//		System.out.println("Expected List is:" + Expected_list);
//		System.out.println("Actual List is:" + Actual_list);
//		Assert.assertEquals(Expected_list, Actual_list, "List is not present");
//	}
	
	@Test
	public void tc02_oot_page() 
	{
		treepageobj.click_overview_of_tree();
		String actualtitle = treepageobj.get_Title();
		String expectedtitle = "Overview of Trees";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
	}
	
	@Test
	public void tc03_tryhere_oot() 
	{
		treepageobj.click_overview_of_tree();
		treepageobj.click_TryHere_from_OverviewOfTrees();
		String actualt_title = treepageobj.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);
		System.out.println("User is on the Try Editor Page");		
	}
	
	@Test
	public void tc04_validPyhtoncode_oot()
	{
		treepageobj.click_overview_of_tree();
		treepageobj.click_TryHere_from_OverviewOfTrees();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();
	}
	
	@Test
	public void tc05_invalid_code_oot()
	{
		treepageobj.click_overview_of_tree();
		treepageobj.click_TryHere_from_OverviewOfTrees();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();
	}

	@Test
	public void tc06_gobackfromoot()
	{
		treepageobj.click_overview_of_tree();
		treepageobj.click_TryHere_from_OverviewOfTrees();
		treepageobj.goback_frmTryeditor();
		String actualtitle = treepageobj.get_Title();
		String expectedtitle = "Overview of Trees";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
		treepageobj.contents_on_ootpage();

	}
	
	@Test
	public void tc07_terminologies()
	{
		treepageobj.click_terminologies();
		String actual_title = treepageobj.get_Title();
		String expected_title = "Terminologies";
		assertEquals(expected_title, actual_title);
		System.out.println("User is on the " + actual_title + " Page");
	}
	
	
	@Test
	public void tc08_editorpage_ter()
	{
		treepageobj.click_terminologies();
		treepageobj.click_tryHere_on_Terminologies();
		String actual_tit = treepageobj.get_Title();
		String Expected_tit = "Assessment";
		assertEquals(Expected_tit, actual_tit);
		System.out.println("User is on the " + actual_tit + " Page of Terminologies section");
	}
	
	@Test
	public void tc09_validcode_ter()
	{
		treepageobj.click_terminologies();
		treepageobj.click_tryHere_on_Terminologies();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc10_invalidcode_ter()
	{
		treepageobj.click_terminologies();
		treepageobj.click_tryHere_on_Terminologies();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc11_goback_ter()
	{
		treepageobj.click_terminologies();
		treepageobj.click_tryHere_on_Terminologies();
		treepageobj.goback_frmTryeditor();
		String actualtitle = treepageobj.get_Title();
		String expectedtitle = "Terminologies";
		assertEquals(expectedtitle, actualtitle);
		System.out.println("User is on the" + expectedtitle + "page");
		treepageobj.contents_on_ootpage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
