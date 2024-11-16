package logic;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.CommonDataProvider;
import pageObjects.GraphPageObjects;
import pageObjects.QueuePageObjects;
import pageObjects.Signinpageobjects;
import utils.ExcelReader;

public class GraphTest extends TestBase {
	Signinpageobjects signinpage;
	ExcelReader excelreader;
	GraphPageObjects graphpage;

	@BeforeMethod()
	public void login() {

		test = extent.createTest("Test cases from the Queue module");
		signinpage = new Signinpageobjects(driver);
		signinpage.click_signin_link();
		signinpage.enter_username("ninjatesterss");
		signinpage.enter_password("ninja@123");
		signinpage.click_login_btn();
		graphpage = new GraphPageObjects(driver);
		graphpage.btnGetStartGraph();
	}

	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc01_graphTopics() {
		GraphPageObjects graphpage = new GraphPageObjects(driver);
		graphpage.graphTopicsCovered();
		List<String> Expected_list = Arrays.asList("Graph", "Graph Representations");
		List<String> Actual_list = graphpage.graph_topicscovered_list();
		System.out.println("Expected List is:" + Expected_list);
		System.out.println("Actual List is:" + Actual_list);
	}

	@Test
	public void tc02_Graph() {
		graphpage.graph();
		String actualtitle = graphpage.get_Title();
		String expectedtitle = "Graph";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc03_TryHereGraph() {
		graphpage.graph();
		graphpage.click_TryHere();
		String actualt_title = graphpage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	public void tc04_ValidCode(String code) {
		// login(username, password);
		graphpage.graph();
		graphpage.click_TryHere();
//			String validCode = ExcelReader.getExcelValue(sheetName, rowIndex, columnIndex);
		graphpage.txtEnterCode(code);

	}

	@Test(dataProvider = "data-provider-invalid-code", dataProviderClass = CommonDataProvider.class)
	
	public void tc05_InvalidCode(String code) {
		graphpage.graph();
		graphpage.click_TryHere();
		
		graphpage.txtEnterCode(code);
	}

	@Test
	public void tc06_gobackfromoot() {
		graphpage.graph();
		graphpage.click_TryHere();
		graphpage.goBackFromTryeditor();
		String actualtitle = graphpage.get_Title();
		String expectedtitle = "Graph";
		assertEquals(expectedtitle, actualtitle);
		graphpage.contents();

	}

	@Test
	public void tc07_GraphRepresentation() {
		graphpage.graphRepresentation();
		String actualtitle = graphpage.get_Title();
		String expectedtitle = "Graph Representation";
		assertEquals(expectedtitle, actualtitle);
		// System.out.println("User is on the" + expectedtitle + "page");
	}

	@Test
	public void tc08_TryHereGraphRepresentation() {
		graphpage.graphRepresentation();
		graphpage.click_TryHere();
		String actualt_title = graphpage.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);

	}

	@Test(dataProvider = "data-provider-valid-code", dataProviderClass = CommonDataProvider.class)
	
	public void tc09_ValidCode(String code) {
		graphpage.graphRepresentation();
		graphpage.click_TryHere();
		graphpage.txtEnterCode(code);

	}

	@Test(dataProvider = "data-provider-invalid-code", dataProviderClass = CommonDataProvider.class)
	
	public void tc10_InvalidCode(String code) {
		graphpage.graphRepresentation();
		graphpage.click_TryHere();
		graphpage.txtEnterCode(code);
	}

	@Test
	public void tc11_gobackgraphRepresentation() {
		graphpage.graphRepresentation();
		graphpage.click_TryHere();
		graphpage.goBackFromTryeditor();
		String actualtitle = graphpage.get_Title();
		String expectedtitle = "Graph Representation";
		assertEquals(expectedtitle, actualtitle);
		graphpage.contents();

	}

}
