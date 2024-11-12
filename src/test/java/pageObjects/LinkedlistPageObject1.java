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

public class LinkedlistPageObject1 {

	private By Linkedlist_Get_Started = By.xpath("//div/a[@href='linked-list' and text()='Get Started']");
	private By linkedlist_topics_cvrd=By.xpath("//div/p[@class='bg-secondary text-white']");
	private By linkedlist_listoftopics=By.cssSelector("a.list-group-item");
	private By Introduction= By.linkText("Introduction");
	private By TryHere_Introduction=By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");
	private By Editor_input_box_introduction= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");//By.xpath("//div/form[@id='answer_form']");
			
	private By run_introduction= By.xpath("//*[@id=\"answer_form\"]/button");//By.xpath("//form/button[text()='Run']");
    private By output_introduction= By.id("output");
    private By content_out=By.id("content");
    private By creating_linkedlist=By.linkText("Creating Linked LIst");
    private By TryHereBtn_CreatingLinkedlist = By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");
    private By types_of_linkedlist = By.linkText("Types of Linked List");
	private By output_panel = By.id("output");
	private By TryHereBtn_TypesofLinkedlist = By.xpath("//div/a[@href='/tryEditor' and text()='Try here>>>']");
	private By ImplementLinkedlistinPython = By.linkText("Implement Linked List in Python");
	private By Traversal = By.linkText("Traversal");
	private By Insertion = By.linkText("Insertion");
	private By Deletion = By.linkText("Deletion");
	private By PracticeQuestions = By.linkText("Practice Questions");

	/*public WebDriver driver;

	public LinkedlistPageObject1(WebDriver driver) 
	{
		this.driver = driver;
	}
*/
public DriverFactory driverfactory;
	
	WebDriver driver;
	public LinkedlistPageObject1(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}
	public void click_linkedlist_getstarted()
	{
		driver.findElement(Linkedlist_Get_Started).click();
	}
	public void Linkedlist_topics_covered_section()
	{
		WebElement topics = driver.findElement(linkedlist_topics_cvrd);
		new Actions(driver).scrollToElement(topics).perform();
		System.out.println("Scrolled down to Topics Covered under the Linkedlist Section");
	}

	public List<String> Linkedlist_topicscovered_list()
	{
		List<String> LinkedlistTopics = new ArrayList<>();
		List<WebElement> topics_Linkedlist = driver.findElements(linkedlist_listoftopics);
		for (WebElement linkedlist_topics : topics_Linkedlist)
		{
			String linkedlisttopics = linkedlist_topics.getText();
			LinkedlistTopics.add(linkedlisttopics);
			
		}
		return LinkedlistTopics;
	}
	
	public void click_introduction_of_Linkedlist()
	{
		driver.findElement(Introduction).click();
	}

	public void click_TryHere_from_IntroductionofLinkedlist()
	{
		driver.findElement(TryHere_Introduction).click();
	}
	
   public void validcode_editor_out()
	{
		WebElement validcode_out = driver.findElement(Editor_input_box_introduction);
		new Actions(driver).sendKeys(validcode_out,"print('Hello it is a Valid Python Code')").perform();
		 
	}

   public void run_IntroductionofLinkedlist()
	{
		driver.findElement(run_introduction).click();
	}
	
   public void Ouptput_IntroductionLinkedlist()
	{
		WebElement output=driver.findElement(output_introduction);
		String result = output.getText();
		System.out.println("The output of valid Python code is:" +result);
		
	}
   public void invalid_editor_out()
	{
		WebElement invalidcode_out = driver.findElement(Editor_input_box_introduction);
		new Actions(driver).sendKeys(invalidcode_out,"p('Invalid Code')").perform();
	}
   public void error_alert_out()
	{
		Alert alert = driver.switchTo().alert();
		String alert_message=alert.getText();
		System.out.println("Error occured is: " +alert_message);
       alert.accept();
	}
	
	public void goback_frmTryeditor() {
		driver.navigate().back();
	}
	public void contents_on_outpage()
	{
		boolean content=driver.findElement(content_out).isDisplayed();
		if (content)
			{
			System.out.println("Topics Covered under Linkedlist sections are present on left side of the screen");
			}
			
	}
	
	public void click_CreatingLinkedlist() {
		driver.findElement(creating_linkedlist).click();
	}

    public void click_tryHere_on_CreatingLinkedlist() {
		driver.findElement(TryHereBtn_CreatingLinkedlist).click();
	}

   public void click_editorbox() {
		driver.findElement(Editor_input_box_introduction).click();
	}

	public void getPythonCode_from_excel(String string) {
		WebElement invalidcode = driver.findElement(Editor_input_box_introduction);
		new Actions(driver).sendKeys(invalidcode, string).perform();
    }

    public void click_TypesofLinkedlist() {
		driver.findElement(types_of_linkedlist).click();
	}
   public void click_tryhere() {
		driver.findElement(TryHereBtn_TypesofLinkedlist).click();
	}
    public void show_output() 
    {
		WebElement output = driver.findElement(output_panel);
		output.getText();
		boolean output_isDisplayed = output.isDisplayed();
		Assert.assertTrue(output_isDisplayed, "Output is not displayed");
		System.out.println("Output is " + output);
    }
     public void invalidcode_error() 
     {
		Alert alert_popup = driver.switchTo().alert();
		String alert_message = alert_popup.getText();
		System.out.println("Error occured is: " + alert_message);
		alert_popup.accept();
		}

     public void click_ImplementLinkedlistinPython()
     {
    	 driver.findElement(ImplementLinkedlistinPython).click();
     }
	public void click_Traversal() {
		driver.findElement(Traversal).click();
	}

	public void click_Insertion() {
		driver.findElement(Insertion).click();
	}

	public void click_Deletion() {
		driver.findElement(Deletion).click();
	}

	public void click_PracticeQuestion() {
		driver.findElement(PracticeQuestions).click();
	}

	public void is_practiceQuestion_Displayed() {
		boolean content = driver.getPageSource().contains("Practice Questions.....");
		Assert.assertTrue(content, "No Practice Questions Available");
	}

	//public void clicktryhereImplement() {
		
		
	//}

	//public void click_TryHeretypesoflinkedlist() {
		// TODO Auto-generated method stub
		
	//}

	//public void click_TryHeretypesoflinkedlist() {
		// TODO Auto-generated method stub
		
	//}
}


