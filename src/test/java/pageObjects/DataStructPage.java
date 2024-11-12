package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.DriverFactory;

public class DataStructPage {
	private By Datastruct_Get_Started = By
			.xpath("//div/a[@href='data-structures-introduction' and text()='Get Started']");

	private By datastruct_topics_covered = By.xpath("//div/p[@class='bg-secondary text-white']");
	private By datastruct_listoftopics = By.cssSelector("a.list-group-item");
	private By timecomplexity = By.linkText("Time Complexity");
	private By TryHere_Timecomplexity = By.xpath("//div/a[@href='/tryEditor' and text()='Try here>>>']");
	private By content_out = By.id("content");
	private By timecomplexcity = By.linkText("Time Complexity");
	private By PracticeQuestions = By.linkText("Practice Questions");
    public DriverFactory driverfactory;

	WebDriver driver;

	public DataStructPage(WebDriver driver) {
		driverfactory = new DriverFactory();
		this.driver = driverfactory.getdriver();
	}

	public void click_datastructures_getstarted() {
		driver.findElement(Datastruct_Get_Started).click();
	}

	public void datastructures_topics_covered_section() {
		WebElement topics = driver.findElement(datastruct_topics_covered);
		new Actions(driver).scrollToElement(topics).perform();
		System.out.println("Scrolled down to Topics Covered under the Data Structure Section");

	}

	public List<String> datastuct_topicscovered_list() {
		List<String> DatastructTopic = new ArrayList<>();
		List<WebElement> topics_datastruct = driver.findElements(datastruct_listoftopics);
		for (WebElement datastruct_topics : topics_datastruct) {
			String datastructtopics = datastruct_topics.getText();
			DatastructTopic.add(datastructtopics);

		}
		return DatastructTopic;

	}

	public void click_timecomplexity() {
		driver.findElement(timecomplexity).click();
	}

	public void click_Time_complexity() {
		driver.findElement(timecomplexity).click();
	}

	public void click_TryHere_from_TimeComplexity() {
		driver.findElement(TryHere_Timecomplexity).click();

	}

	public void goback_frmTryeditor() {

		driver.navigate().back();
	}

	public void contents_outpage() {
		boolean content = driver.findElement(content_out).isDisplayed();
		if (content) {
			System.out.println("Topics Covered under Data Structure sections are present on left side of the screen");
		}
	}

	public void click_PracticeQuestions() {
		driver.findElement(PracticeQuestions).click();
	}

	public void is_practiceQuestion_Displayed() {

		boolean content = driver.getPageSource().contains("Practice Questions.....");
		Assert.assertTrue(content, "No Practice Questions Available");

	}

}
