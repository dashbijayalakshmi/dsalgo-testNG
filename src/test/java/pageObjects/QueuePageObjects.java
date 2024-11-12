package pageObjects;

import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.DriverFactory;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.interactions.Actions;

public class QueuePageObjects {
	/*public WebDriver driver;

	public QueuePageObjects(WebDriver driver) {
		this.driver=driver;*/
		/*actions = new Actions(driver);
	    Actions actions;*/
		private By btnGetStartQueue=By.xpath("/html/body/div[3]/div[5]/div/div/a");
		private By text=By.xpath("/html/body/div[2]/h4");
		private By queueTopic=By.xpath("/html/body/div[2]/p[3]");
		private By linkImplementationOfQueueInPython=By.xpath("/html/body/div[2]/ul[1]/a");		
		private By tryHere=By.xpath("/html/body/div[2]/div/div[2]/a");
		private By tops=By.id("content");
		private By TryHere_OverviewofTrees=By.xpath("//div/a[@href='/tryEditor' and text()='Try here>>>']");
		private By Queuelistoftopics = By.cssSelector("a.list-group-item");
		private By txtCode=By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
		private By btnrun=By.xpath("//*[@id=\"answer_form\"]/button");
		private By output=By.xpath("//*[@id=\"output\"]");
		private By linkImplementationUsingCollections=By.xpath("/html/body/div[2]/ul[2]/a");
		private By linkImplementationUsingArray=By.xpath("/html/body/div[2]/ul[3]/a");
		private By linkQueueOperations=By.xpath("/html/body/div[2]/ul[4]/a");
		private By output_panel = By.id("output");
		private By PracticeQuestion = By.linkText("Practice Questions");
		
		public DriverFactory driverfactory;
		
		WebDriver driver;
		public QueuePageObjects(WebDriver driver)
		{
			//this.driver=driver;
			driverfactory=new DriverFactory();
			this.driver=driverfactory.getdriver();
			//actions = new Actions(driver);
		    //Actions actions;
			
		}
		public void btnGetStartQueue() {
			driver.findElement(btnGetStartQueue).click();
		}
		public void text(String expectedText) {
			String actualText = driver.findElement(text).getText();
			Assert.assertEquals(expectedText, actualText);
			
		}
		public void tryhere() {
			driver.findElement(tryHere).click();
			
		}
		public void queueTopicsCovered()
		{
			WebElement topics=driver.findElement(queueTopic);
			new Actions(driver).scrollToElement(topics).perform();
			System.out.println("Scrolled down to Topics Covered under the Queue Section");
		}

		public void txtEnterCode(String print) {
			driver.findElement(txtCode).clear();
			driver.findElement(txtCode).sendKeys();
		}
		public void actionCode(String text) {
			new Actions(driver).sendKeys(driver.findElement(txtCode),text).perform();
		}
		public void run() {
			driver.findElement(btnrun).click();
		}
		public void output(String expectedText ) {
			String actualText = driver.findElement(output).getText();
			Assert.assertEquals(expectedText, actualText);
		}
		public void linkImplementationOfQueueInPython() {
			driver.findElement(linkImplementationOfQueueInPython).click();
		}
		public void linkImplementationUsingCollections() {
			driver.findElement(linkImplementationUsingCollections).click();
		}
		public void linkImplementationUsingArray() {
			driver.findElement(linkImplementationUsingArray).click();
		}
		public void linkQueueOperations() {
			driver.findElement(linkQueueOperations).click();
		}
		public List<String> queue_topicscovered_list() {
			List<String> queueTopics = new ArrayList<>();
			List<WebElement> topics_queue = driver.findElements(Queuelistoftopics);
			for (WebElement queue_topics : topics_queue) {
				String queuetopics = queue_topics.getText();
				queueTopics.add(queuetopics);
			}
			return queueTopics;

		}
		public void popUp() {
			Alert alert_popup = driver.switchTo().alert();
			String alert_message = alert_popup.getText();
			System.out.println("Error occured is: " + alert_message);
			alert_popup.accept();
		}
		public void goBackFromTryeditor()
		{
			driver.navigate().back();
		}
		public void contents()
		{
			boolean content=driver.findElement(tops).isDisplayed();
			if (content)
				{
				System.out.println("Topics Covered under graph sections are present on left side of the screen");
				}
				
		}
		public void show_output() {
			WebElement output = driver.findElement(output_panel);
			output.getText();
			boolean output_isDisplayed = output.isDisplayed();
			Assert.assertTrue(output_isDisplayed, "Output is not displayed");
			System.out.println("Output is " + output);

		}
		public void PracticeQuestion() {
			driver.findElement(PracticeQuestion).click();
		}
		public void practiceQuestionDisplayed() {
			boolean content = driver.getPageSource().contains("Practice Questions.....");
			Assert.assertTrue(content, "No Practice Questions Available");
		}
		
		
		
			

}
