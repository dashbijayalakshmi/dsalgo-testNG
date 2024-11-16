package logic;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

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
		test = extent.createTest("Test cases from the Tree module");
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
	
	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
	public void tc01_reqtreeltopics() throws InterruptedException
	{
		TreePageObjects treepageobj = new TreePageObjects(driver);
		treepageobj.tree_topics_covered_section();
		List<String> Expected_list = Arrays.asList("Overview of Trees","Terminologies","Types of Trees","Tree Traversals","Traversals-Illustration","Binary Trees","Types of Binary Trees","Implementation in Python","Binary Tree Traversals","Implementation of Binary Trees","Applications of Binary trees","Binary Search Trees","Implementation Of BST");
		List<String> Actual_list = treepageobj.tree_topicscovered_list();
		System.out.println("Expected List is:" + Expected_list);
		System.out.println("Actual List is:" + Actual_list);
		Assert.assertEquals(Expected_list, Actual_list, "List is not present");
	}
	
	@Test(retryAnalyzer=logic.RetryAnalyzer.class)
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
	
	@Test
	public void tc12_typesofTrees()
	{
		treepageobj.click_TypesofTreeslink();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Types of Trees";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated");	
	}
	
	
	@Test
	public void tc13_typesofTreestryhere()
	{
		treepageobj.click_TypesofTreeslink();
		treepageobj.click_TryHere_from_OverviewOfTrees();
		String actualt_title = treepageobj.get_Title();
		String expected_title = "Assessment";
		assertEquals(expected_title, actualt_title);
		System.out.println("User is on the Try Editor Page");
	}
	
	@Test
	public void tc14_validcode_typeoftrees()
	{
		treepageobj.click_TypesofTreeslink();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc15_invalidcode_typeoftrees1()
	{
		treepageobj.click_TypesofTreeslink();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc16_goback_typeoftrees()
	{
		treepageobj.click_TypesofTreeslink();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Types of Trees";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc17_TreeTraversals()
	{
		treepageobj.click_TreeTraversals();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Tree Traversals";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	
	@Test
	public void tc18_TreeTraversalstryhere()
	{
		treepageobj.click_TreeTraversals();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc19_validcode_treetraversal()
	{
		treepageobj.click_TreeTraversals();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc20_invalidcode_treetraversal()
	{
		treepageobj.click_TreeTraversals();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc21_goback_treeTraversals()
	{
		treepageobj.click_TreeTraversals();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Tree Traversals";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc22_TraIllu()
	{
		treepageobj.click_Traversals_illustration();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Traversals-Illustration";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc23_TraIllutryhere()
	{
		treepageobj.click_Traversals_illustration();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc24_validcode_TraIllu()
	{
		treepageobj.click_Traversals_illustration();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc25_invalidcode_TraIllu()
	{
		treepageobj.click_Traversals_illustration();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc26_goback_traIllu()
	{
		treepageobj.click_Traversals_illustration();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Traversals-Illustration";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc27_binarytree()
	{
		treepageobj.click_BinaryTree();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc28_binarytreetryhere()
	{
		treepageobj.click_BinaryTree();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc29_validcode_binarytree()
	{
		treepageobj.click_BinaryTree();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc30_invalidcode_TraIllu()
	{
		treepageobj.click_BinaryTree();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc31_goback_binarytree()
	{
		treepageobj.click_BinaryTree();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc32_impinPython()
	{
		treepageobj.click_impinPython();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation in Python";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc33_impinPythontryhere()
	{
		treepageobj.click_impinPython();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc34_validcode_impinPython()
	{
		treepageobj.click_impinPython();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc35_invalidcode_impinPython()
	{
		treepageobj.click_impinPython();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc36_goback_impinPyhton()
	{
		treepageobj.click_impinPython();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation in Python";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc37_btt()
	{
		treepageobj.click_binarytreetrav();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Tree Traversals";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc38_btttryhere()
	{
		treepageobj.click_binarytreetrav();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc39_validcode_btt()
	{
		treepageobj.click_binarytreetrav();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc40_invalidcode_btt()
	{
		treepageobj.click_binarytreetrav();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc41_goback_btt()
	{
		treepageobj.click_binarytreetrav();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Tree Traversals";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc42_implOfbtt()
	{
		treepageobj.click_ImpofBinaryTrees();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation of Binary Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc43_implOfbtttryhere()
	{
		treepageobj.click_ImpofBinaryTrees();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc44_validcode_impOfbtt()
	{
		treepageobj.click_ImpofBinaryTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc45_invalidcode_impOfbtt()
	{
		treepageobj.click_ImpofBinaryTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc46_goback_implOfbtt()
	{
		treepageobj.click_ImpofBinaryTrees();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation of Binary Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test
	public void tc47_appOfbtt()
	{
		treepageobj.click_appofBinaryTrees();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Applications of Binary trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc48_appOfbtttryhere()
	{
		treepageobj.click_appofBinaryTrees();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc49_validcode_appOfbtt()
	{
		treepageobj.click_appofBinaryTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc50_invalidcode_appOfbtt()
	{
		treepageobj.click_appofBinaryTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc51_goback_appOfbtt()
	{
		treepageobj.click_appofBinaryTrees();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Applications of Binary trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	@Test
	public void tc52_bst()
	{
		treepageobj.click_BinarySearchTrees();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Search Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc53_bsttryhere()
	{
		treepageobj.click_BinarySearchTrees();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc54_validcode_bst()
	{
		treepageobj.click_BinarySearchTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc55_invalidcode_bst()
	{
		treepageobj.click_BinarySearchTrees();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc56_goback_bst()
	{
		treepageobj.click_BinarySearchTrees();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Binary Search Trees";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	@Test
	public void tc57_implbst()
	{
		treepageobj.click_impofBST();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation Of BST";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
	}
	
	
	@Test
	public void tc58_impbsttryhere()
	{
		treepageobj.click_impofBST();
		treepageobj.click_tryhere();
		String actual_tit = treepageobj.get_Title();
		String exp_tit = "Assessment";
		Assert.assertEquals(exp_tit, actual_tit, "User wasn't naviagated to expected page");
	}
	
	@Test
	public void tc59_validcode_impbst()
	{
		treepageobj.click_impofBST();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.validcode_editor();
		runpythoncode.run_button();
		runpythoncode.Ouptput_ValidCode();	
	}
	
	@Test
	public void tc60_invalidcode_impbst()
	{
		treepageobj.click_impofBST();
		treepageobj.click_tryhere();
		Run_PythonCodes runpythoncode = new Run_PythonCodes(driver);
		runpythoncode.invalidcode_editor();
		runpythoncode.run_button();
		runpythoncode.error_alert();	
	}
	
	@Test
	public void tc61_goback_impbst()
	{
		treepageobj.click_impofBST();
		treepageobj.click_tryhere();
		treepageobj.goback_frmTryeditor();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Implementation Of BST";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		treepageobj.contents_on_ootpage();
	}
	
	@Test 
	public void tc62_practiceQuesTree()
	{
		treepageobj.click_impofBST();
		treepageobj.click_PracticeQuestion();
		String actual_tit1 = treepageobj.get_Title();
		String exp_tit1 = "Practice Questions";
		Assert.assertEquals(exp_tit1, actual_tit1, "User wasn't naviagated to expected page");
		System.out.println("User navigated to " + actual_tit1);
		treepageobj.is_practiceQuestion_Displayed();
	}
	
}
