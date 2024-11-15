package logic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DataStructPage;
import pageObjects.Run_PythonCodes;
import pageObjects.Signinpageobjects;
import pageObjects.TreePageObjects;

public class DataStructureTest extends TestBase 
{
	
		Signinpageobjects signinpage;
		DataStructPage datastructpageobj;
		Run_PythonCodes runpythoncode;
		
		@BeforeMethod()
		public void login()
		{
			test = extent.createTest("Test cases from the Data Structure module");
			signinpage = new Signinpageobjects(driver);
			signinpage.click_signin_link();
			signinpage.enter_username("ninjatesterss");
			signinpage.enter_password("ninja@123");
			signinpage.click_login_btn();
			datastructpageobj = new DataStructPage(driver);
			datastructpageobj.click_datastructures_getstarted();
		}


//@Test(dataProvider = "Logindataprovider" , dataProviderClass=TestBase.class)
//public void tc01_loginusingdataprovider(String username, String password) 
//{
//	driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
//	driver.findElement(By.id("id_password")).sendKeys(password);
//	signinpage.click_login_btn();	
//}


		@Test(retryAnalyzer=logic.RetryAnalyzer.class)
		
		public void tc01_reqDataStructtopics() throws InterruptedException
		{
			datastructpageobj.datastructures_topics_covered_section();
		}

		@Test
		
		public void tc02_oot_page() 
		{
			datastructpageobj.click_timecomplexity();
			String actualtitle = landingpage.get_Title();
			String expectedtitle = "Time Complexcity";
			assertEquals(expectedtitle, actualtitle);
			System.out.println("User is on the" + expectedtitle + "page");
		}
		@Test
		public void tc03_tryhere_oot() 
		{
			datastructpageobj.click_timecomplexity();
			datastructpageobj.click_TryHere_from_TimeComplexity();
			String actualt_title = landingpage.get_Title();
			String expected_title = "Assessment";
			assertEquals(expected_title, actualt_title);
			System.out.println("User is on the Try Editor Page");		
		}
		@Test
		public void tc04_validPyhtoncode_oot()
		{
			datastructpageobj.click_Time_complexity();
			datastructpageobj.click_TryHere_from_TimeComplexity();
			//runpythoncode = new Run_PythonCodes();
			Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
			runpythoncode.validcode_editor();
			runpythoncode.run_button();
			runpythoncode.Ouptput_ValidCode();
		}
		@Test
		public void tc05_invalid_code_oot()
		{
			datastructpageobj.click_Time_complexity();
			datastructpageobj.click_TryHere_from_TimeComplexity();
			Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
			//runpythoncode = new Run_PythonCodes();
			runpythoncode.invalidcode_editor();
			runpythoncode.run_button();
			runpythoncode.error_alert();
		}
		@Test
		public void tc06_gobackfromoot()
		{
			datastructpageobj.click_Time_complexity();
			datastructpageobj.click_TryHere_from_TimeComplexity();
			datastructpageobj.goback_frmTryeditor();
			String actualtitle = datastructpageobj.get_Title();
			String expectedtitle = "Time Complexcity";
			assertEquals(expectedtitle, actualtitle);
			System.out.println("User is on the" + expectedtitle + "page");
			datastructpageobj.contents_outpage();

}
		

}

		