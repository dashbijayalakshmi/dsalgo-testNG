package pageObjects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverFactory;

public class TreePageObjects {
	private By Tree_Get_Started = By.xpath("//div/a[@href='tree' and text()='Get Started']");
	private By tree_topics_cvrd = By.xpath("//div/p[@class='bg-secondary text-white']");
	private By tree_listoftopics = By.cssSelector("a.list-group-item");
	private By overview_of_trees = By.linkText("Overview of Trees");
	private By TryHere_OverviewofTrees = By.xpath("//div/a[@href='/tryEditor' and text()='Try here>>>']");
	// private By
	// Editor_input_box_OverviewofTrees=By.xpath("//div[@class='input']");
	private By Editor_input_box_OverviewofTrees = By.xpath("//div/form[@id='answer_form']");
	private By run_OverviewofTrees = By.xpath("//form/button[text()='Run']");
	private By output_verviewofTrees = By.id("output");
	private By content_oot = By.id("content");
	private By terminologies = By.linkText("Terminologies");
	private By TryHereBtn_Terminologies = By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");
	private By type_of_tree = By.linkText("Types of Trees");
	private By output_panel = By.id("output");
	private By TryHereBtn = By.xpath("//div/a[@href='/tryEditor' and text()='Try here>>>']");
	private By TreeTraversals = By.linkText("Tree Traversals");
	private By Traversals_illustration = By.linkText("Traversals-Illustration");
	private By Binary_trees = By.linkText("Binary Trees");
	private By TypesofBinaryTrees = By.linkText("Types of Binary Trees");
	private By impinPython = By.linkText("Implementation in Python");
	private By binarytreetrav = By.linkText("Binary Tree Traversals");
	private By ImpofBinaryTrees = By.linkText("Implementation of Binary Trees");
	private By appofBinaryTrees = By.linkText("Applications of Binary trees");
	private By BinarySearchTrees = By.linkText("Binary Search Trees");
	private By impofBST = By.linkText("Implementation Of BST");
	private By PracticeQuestion = By.linkText("Practice Questions");

	public DriverFactory driverfactory;
	
	WebDriver driver;
	public TreePageObjects(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}

	public String get_Title() {
		return driver.getTitle();
	}
	
	public void click_tree_getstarted() {
		driver.findElement(Tree_Get_Started).click();
	}

	public void tree_topics_covered_section() {
		WebElement topics = driver.findElement(tree_topics_cvrd);
		new Actions(driver).scrollToElement(topics).perform();
		System.out.println("Scrolled down to Topics Covered under the Tree Section");
	}

	public List<String> tree_topicscovered_list() {
		List<String> TreeTopics = new ArrayList<>();
		List<WebElement> topics_tree = driver.findElements(tree_listoftopics);
		for (WebElement tree_topics : topics_tree) {
			String treetopics = tree_topics.getText();
			TreeTopics.add(treetopics);
		}
		return TreeTopics;

	}

	public void click_overview_of_tree() {
		driver.findElement(overview_of_trees).click();
	}

	public void click_TryHere_from_OverviewOfTrees() {
		driver.findElement(TryHere_OverviewofTrees).click();
	}

	public void validcode_editor_oot() {
		WebElement validcode_oot = driver.findElement(Editor_input_box_OverviewofTrees);
		new Actions(driver).sendKeys(validcode_oot, "print('Hello it is a Valid Python Code')").perform();

	}

	public void run_OverviewOfTree() {
		driver.findElement(run_OverviewofTrees).click();
	}

	public void Ouptput_OverviewOfTree() {
		WebElement output = driver.findElement(output_verviewofTrees);
		String result = output.getText();
		System.out.println("The output of valid Python code is:" + result);

	}

	public void invalid_editor_oot() {
		WebElement invalidcode_oot = driver.findElement(Editor_input_box_OverviewofTrees);
		new Actions(driver).sendKeys(invalidcode_oot, "p('Invalid Code')").perform();
	}

	public void error_alert_oot() {
		Alert alert = driver.switchTo().alert();
		String alert_message = alert.getText();
		System.out.println("Error occured is: " + alert_message);
		alert.accept();
	}

	public void goback_frmTryeditor() {
		driver.navigate().back();
	}

	public void contents_on_ootpage() {
		boolean content = driver.findElement(content_oot).isDisplayed();
		if (content) {
			System.out.println("Topics Covered under Tree sections are present on left side of the screen");
		}

	}

	public void click_terminologies() {
		driver.findElement(terminologies).click();

	}

	public void click_tryHere_on_Terminologies() {
		driver.findElement(TryHereBtn_Terminologies).click();
	}

	public void click_editorbox() {
		driver.findElement(Editor_input_box_OverviewofTrees).click();
	}

	public void getPythonCode_from_excel(String string) {
		WebElement invalidcode = driver.findElement(Editor_input_box_OverviewofTrees);
		new Actions(driver).sendKeys(invalidcode, string).perform();

	}

	public void click_TypesofTreeslink() {
		driver.findElement(type_of_tree).click();
	}

	public void click_tryhere() {
		driver.findElement(TryHereBtn).click();
	}

	public void show_output() {
		WebElement output = driver.findElement(output_panel);
		output.getText();
		boolean output_isDisplayed = output.isDisplayed();
		Assert.assertTrue(output_isDisplayed, "Output is not displayed");
		System.out.println("Output is " + output);

	}

	public void invalidcode_error() {
		Alert alert_popup = driver.switchTo().alert();
		String alert_message = alert_popup.getText();
		System.out.println("Error occured is: " + alert_message);
		alert_popup.accept();
	}

	public void click_TreeTraversals() {
		driver.findElement(TreeTraversals).click();
	}

	public void click_Traversals_illustration() {
		driver.findElement(Traversals_illustration).click();
	}

	public void click_BinaryTree() {
		driver.findElement(Binary_trees).click();
	}

	public void click_TypesofBinaryTrees() {
		driver.findElement(TypesofBinaryTrees).click();
	}

	public void click_impinPython() {
		driver.findElement(impinPython).click();
	}

	public void click_ImpofBinaryTrees() {
		driver.findElement(ImpofBinaryTrees).click();
	}

	public void click_binarytreetrav() {
		driver.findElement(binarytreetrav).click();
	}

	public void click_appofBinaryTrees() {
		driver.findElement(appofBinaryTrees).click();
	}

	public void click_BinarySearchTrees() {
		driver.findElement(BinarySearchTrees).click();
	}

	public void click_impofBST() {
		driver.findElement(impofBST).click();
	}

	public void click_PracticeQuestion() {
		driver.findElement(PracticeQuestion).click();
	}

	public void is_practiceQuestion_Displayed() {
		boolean content = driver.getPageSource().contains("Practice Questions.....");
		Assert.assertTrue(content, "No Practice Questions Available");
	}
}
