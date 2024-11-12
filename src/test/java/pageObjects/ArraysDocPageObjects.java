package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.DriverFactory;

public class ArraysDocPageObjects {

	private By Array_getstart = By.xpath("//a[@href='array' and text()='Get Started']");
	private By array_list = By.cssSelector("ul a.list-group-item");
	private By topics_cov = By.xpath("//p[text()='Topics Covered']");
	private By Arrays_in_python = By.linkText("Arrays in Python");
	private By TryHere_Arraysinpython = By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");

	private By Editor_input_box_Arraysusinglist = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	private By content_out = By.id("content");

	private By Arrays_Use_List = By.linkText("Arrays Using List");
	private By BasicOperations_Lists = By.linkText("Basic Operations in Lists");
	private By ApplicationsOfArray = By.linkText("Applications of Array");
	private By tryhere = By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");

	private By PracticeQuestions = By.linkText("Practice Questions");
	private By practiceQuestion1 = By.xpath("/html/body/div[2]/a");
	private By output_panel = By.xpath("//*[@id=\"output\"]");
	private By practiceQuestion2 = By.xpath("/html/body/div[3]/a");
	private By practiceQuestion3 = By.xpath("/html/body/div[4]/a");
	private By practiceQuestion4 = By.xpath("/html/body/div[5]/a");

	public DriverFactory driverfactory;
	WebDriver driver;

	public ArraysDocPageObjects(WebDriver driver) {
		driverfactory = new DriverFactory();
		this.driver = driverfactory.getdriver();

	}

	public void click_getstarted() {
		driver.findElement(Array_getstart).click();
	}

	public boolean topic_display() {
		WebElement topic_covered = driver.findElement(topics_cov);
		return topic_covered.isDisplayed();
	}

	public List<String> List_arraysTopics() {
		List<String> ArrayNames = new ArrayList<>();
		List<WebElement> topics_arrays = driver.findElements(array_list);
		for (WebElement Array_name : topics_arrays) {
			String arrayName = Array_name.getText();
			ArrayNames.add(arrayName);
		}
		return ArrayNames;
	}

	
	public List<String> arrays_topicscovered_list() {
		List<String> ArraysTopics = new ArrayList<>();
		List<WebElement> topics_Array = driver.findElements(array_list);
		for (WebElement array_topics : topics_Array) {
			String arraystopics = array_topics.getText();
			ArraysTopics.add(arraystopics);

		}
		return ArraysTopics;
	}

	public void click_ArraysinPython() {
		driver.findElement(Arrays_in_python).click();

	}

	public void click_TryHere() {
		driver.findElement(tryhere).click();

	}

	public void click_TryHere_ArraysinPython() {
		driver.findElement(TryHere_Arraysinpython).click();

	}

	public void goback_frmTryeditor() {
		driver.navigate().back();

	}

	public void contents_on_outpage() {
		boolean content = driver.findElement(content_out).isDisplayed();
		if (content) {
			System.out.println("Topics Covered under Arrays sections are present on left side of the screen");
		}

	}

	public void click_Arraysusinglist() {
		driver.findElement(Arrays_Use_List).click();

	}

	public void getPythonCode_from_excel(String string) {
		WebElement invalidcode = driver.findElement(Editor_input_box_Arraysusinglist);
		new Actions(driver).sendKeys(invalidcode, string).perform();
	}

	public void click_BasicOpertaionList() {
		driver.findElement(BasicOperations_Lists).click();

	}

	public void clickApplicationofArray() {
		driver.findElement(ApplicationsOfArray).click();

	}

	public void click_TryHereApplicationsofArray() {

	}

	public void click_PracticeQuestion() {
		driver.findElement(PracticeQuestions).click();

	}

	public void is_practiceQuestion_Displayed() {
		boolean content = driver.getPageSource().contains("Practice Questions.....");
		Assert.assertTrue(content, "Practice Questions Available");

	}

	public void showoutput() {
		WebElement output = driver.findElement(output_panel);
		output.getText();
		boolean output_isDisplayed = output.isDisplayed();
		Assert.assertTrue(output_isDisplayed, "Output is not displayed");
		System.out.println("Output is " + output);

	}

	public void click_SearchTheArray() {
		driver.findElement(practiceQuestion1).click();

	}

	public void click_MaxConsecutiveOnes() {
		driver.findElement(practiceQuestion2).click();

	}

	public void click_FindNumberswithEvenNumberOfDigits() {
		driver.findElement(practiceQuestion3).click();

	}

	public void click_SquaresOfASortedArray() {
		driver.findElement(practiceQuestion4).click();

	}

	public void popUp() {
		Alert alert_popup = driver.switchTo().alert();
		String alert_message = alert_popup.getText();
		System.out.println("Error occured is: " + alert_message);
		alert_popup.accept();
	}

}
