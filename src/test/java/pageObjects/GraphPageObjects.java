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




public class GraphPageObjects {
	/*public WebDriver driver;
	Actions actions;
	public GraphPageObjects(WebDriver driver) {
		this.driver=driver;
		actions = new Actions(driver);*/
		public DriverFactory driverfactory;
		
		
		
	
	private By btnGetStartgraph=By.xpath("/html/body/div[3]/div[7]/div/div/a");
	private By lineGraph=By.xpath("/html/body/div[2]/ul[2]/a");
	private By lineGraphRepresentations=By.xpath("/html/body/div[2]/ul[3]/a");
	private By txtCode=By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	private By tryHere=By.xpath("/html/body/div[2]/div/div[2]/a");
	private By output=By.xpath("//*[@id=\"output\"]");
	//**//
	private By PracticeQuestion = By.linkText("Practice Questions");
	private By graphTopic=By.xpath("/html/body/div[2]/p[3]");
	private By graphlistoftopics=By.cssSelector("a.list-group-item");
	//private By Graph=By.linkText("Graph");
	private By tops=By.id("content");
	private By output_panel = By.id("output");
	
	//*******//
	WebDriver driver;
	public GraphPageObjects(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}
	public void btnGetStartGraph() {
		driver.findElement(btnGetStartgraph).click();
	}
	public void graph() {
		driver.findElement(lineGraph).click();
	}
	public void graphRepresentation() {
		driver.findElement(lineGraphRepresentations).click();
	}
	//***/
	
	public void graphTopicsCovered()
	{
		WebElement topics=driver.findElement(graphTopic);
		new Actions(driver).scrollToElement(topics).perform();
		System.out.println("Scrolled down to Topics Covered under the Graph Section");
	}
	public List<String> graph_topicscovered_list() {
		List<String> GraphTopics = new ArrayList<>();
		List<WebElement> topics_graph = driver.findElements(graphlistoftopics);
		for (WebElement graph_topics : topics_graph) {
			String graphtopics = graph_topics.getText();
			GraphTopics.add(graphtopics);
		}
		return GraphTopics;

	}
	
	public void click_editorbox() {
		driver.findElement(txtCode).click();
	}

	public void txtEnterCode(String string) {
		WebElement code = driver.findElement(txtCode);
		new Actions(driver).sendKeys(code, string).perform();

	}
	/*public void click_Graph() {
	
		driver.findElement(Graph).click();
	}*/
	public void click_TryHere() {
	
		driver.findElement(tryHere).click();
	}
	public void output(String expectedText ) {
		String actualText = driver.findElement(output).getText();
		Assert.assertEquals(expectedText, actualText);
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
	public void popUp() {
		Alert alert_popup = driver.switchTo().alert();
		String alert_message = alert_popup.getText();
		System.out.println("Error occured is: " + alert_message);
		alert_popup.accept();
	}
	public void PracticeQuestion() {
		driver.findElement(PracticeQuestion).click();
	}
	public void practiceQuestionDisplayed() {
		boolean content = driver.getPageSource().contains("Practice Questions.....");
		Assert.assertTrue(content, "No Practice Questions Available");
	}
	
	

}
