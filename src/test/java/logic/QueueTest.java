package logic;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.CommonDataProvider;
import pageObjects.QueuePageObjects;
import pageObjects.Signinpageobjects;
import utils.ExcelReader;

public class QueueTest extends TestBase {
	Signinpageobjects signinpage;
	QueuePageObjects queuepage;
	ExcelReader excelreader;


	//@Test(dataProvider = "data-provider-valid-username-password", dataProviderClass = CommonDataProvider.class)
	@BeforeMethod
	public void login() {

		test = extent.createTest("Test cases from the Queue module");
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();
		signinpage.enter_username("ninjatesterss");
		signinpage.enter_password("ninja@123");
		signinpage.click_login_btn();
		queuepage = new QueuePageObjects(driver);
		queuepage.btnGetStartQueue();
	}

	// @BeforeMethod(dataProvider = "Logindataprovider" ,
	// dataProviderClass=TestBase.class)

//	public void tc01_loginusingdataprovider(String username, String password) 
//	{
//		signinpage = new Signinpageobjects(driver);
//		signinpage.click_signin_link();
//		driver.findElement(By.cssSelector("#id_username")).sendKeys(username);
//		driver.findElement(By.id("id_password")).sendKeys(password);
//		signinpage.click_login_btn();	
//	}
 @Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc01_queueTopics() {
		QueuePageObjects queuepage = new QueuePageObjects(driver);
	 queuepage.queueTopicsCovered();
		List<String> Expected_list = Arrays.asList("Implementation of Queue in Python","Implementation using collections.deque","Implementation using array","Queue Operations");
		List<String> Actual_list = queuepage.queue_topicscovered_list();
		System.out.println("Expected List is:" + Expected_list);
		System.out.println("Actual List is:" + Actual_list);
	}

	@Test
	public void tc02_ImplementationOfQueue() {
		queuepage.linkImplementationOfQueueInPython();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation of Queue in Python";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc03_TryHereImplementationOfQueue() {
		queuepage.linkImplementationOfQueueInPython();
		queuepage.tryhere();
		String actualt_title = queuepage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	public void tc04_ValidCode(String code) {
		System.out.println(code);
		queuepage.linkImplementationOfQueueInPython();
		queuepage.tryhere();
		queuepage.actionCode(code);
	}

	@Test(dataProvider = "data-provider-invalid-code", dataProviderClass = CommonDataProvider.class)
	
	public void tc05_InvalidCode(String code) {
		queuepage.linkImplementationOfQueueInPython();
		queuepage.tryhere();
		queuepage.actionCode(code);
	}

	@Test
	public void tc06_gobackfromoot() {
		queuepage.linkImplementationOfQueueInPython();
		queuepage.tryhere();
		queuepage.goBackFromTryeditor();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation of Queue in Python";
		assertEquals(expectedtitle, actualtitle);
		queuepage.contents();

	}

	@Test
	public void tc07_ImplementationUsingCollections() {
		queuepage.linkImplementationUsingCollections();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation using collections.deque";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc08_TryHereImplementationUsingCollections() {
		queuepage.linkImplementationUsingCollections();
		queuepage.tryhere();
		String actualt_title = queuepage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	
	public void tc09_ValidCode(String code) {
		queuepage.linkImplementationUsingCollections();
		queuepage.tryhere();
		queuepage.actionCode(code);

	}

	@Test(dataProvider = "data-provider-invalid-code", dataProviderClass = CommonDataProvider.class)
	public void tc10_InvalidCode(String code) {
		queuepage.linkImplementationUsingCollections();
		queuepage.tryhere();
		queuepage.actionCode(code);
	}

	@Test
	public void tc11_gobackImplementationUsingCollections() {
		queuepage.linkImplementationUsingCollections();
		queuepage.tryhere();
		queuepage.goBackFromTryeditor();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation using collections.deque";
		assertEquals(expectedtitle, actualtitle);
		queuepage.contents();

	}

	@Test
	public void tc12_ImplementationUsingArray() {
		queuepage.linkImplementationUsingArray();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation using array";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc13_TryHereImplementationUsingArray() {
		queuepage.linkImplementationUsingArray();
		queuepage.tryhere();
		String actualt_title = queuepage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	public void tc14_ValidCode(String code) {
		queuepage.linkImplementationUsingArray();
		queuepage.tryhere();

		
		queuepage.actionCode(code);

	}

	@Test(dataProvider = "data-provider-invalid-code", dataProviderClass = CommonDataProvider.class)
	public void tc15_InvalidCode(String code) {
		queuepage.linkImplementationUsingArray();
		queuepage.tryhere();
		queuepage.actionCode(code);
	}

	@Test
	public void tc16_gobackImplementationUsingArray() {
		queuepage.linkImplementationUsingArray();
		queuepage.tryhere();
		queuepage.goBackFromTryeditor();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Implementation using array";
		assertEquals(expectedtitle, actualtitle);
		queuepage.contents();

	}

	@Test
	public void tc17_QueueOperations() {
		queuepage.linkQueueOperations();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Queue Operations";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc18_TryHereQueueOperations() {
		queuepage.linkQueueOperations();
		queuepage.tryhere();
		String actualt_title = queuepage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	public void tc19_ValidCode(String code) {
		queuepage.linkQueueOperations();
		queuepage.tryhere();
		queuepage.actionCode(code);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	public void tc120_InvalidCode(String code) {
		queuepage.linkQueueOperations();
		queuepage.tryhere();
		queuepage.actionCode(code);
	}

	@Test
	public void tc21_gobackQueueOperations() {
		queuepage.linkQueueOperations();
		queuepage.tryhere();
		queuepage.goBackFromTryeditor();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Queue Operations";
		assertEquals(expectedtitle, actualtitle);
		queuepage.contents();

	}

	@Test
	public void tc22_QueuePractice() {
		queuepage.linkQueueOperations();
		queuepage.PracticeQuestion();
		String actualtitle = queuepage.get_Title();
		String expectedtitle = "Practice Questions";
		assertEquals(expectedtitle, actualtitle);

	}

	@Test(retryAnalyzer = logic.RetryAnalyzer.class)
	public void tc23_QueuePractice() {
		queuepage.linkQueueOperations();
		queuepage.PracticeQuestion();
		queuepage.practiceQuestionDisplayed();

	}

}
