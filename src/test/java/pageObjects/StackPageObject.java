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

public class StackPageObject {
	private By Stack_Started=By.xpath("//div/a[@href='stack' and text()='Get Started']");

	private By Stack_topics_cvrd=By.xpath("//div/p[@class='bg-secondary text-white']");
	
	private By Stack_list_of_topics=By.cssSelector("a.list-group-item");

	private By Operations_in_stack= By.linkText("Operations in Stack");
	private By TryHere_Operations_in_Stack=By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");

	private By Editor_input_box_operations_in_stack=By.xpath("//div/form[@id='answer_form']");
	private By run_stack=By.xpath("//form/button[text()='Run']");
	private By btnrun=By.xpath("//*[@id=\"answer_form\"]/button");
	private By output_stack= By.id("output");
	private By content_operationsinStack=By.id("content");
	private By implementation= By.linkText("Implementation");
	private By TryHere_implementation=By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");

	private By Editor_input_box_implementation=By.xpath("//div/form[@id='answer_form']");
	private By run_implementation=By.xpath("//form/button[text()='Run']");
	private By output_implementation=By.id("output");
	private By content_outimplementation=By.id("content");
	private By applications= By.linkText("Applications");
	private By TryHere_in_applications=By.xpath("//a[@href='/tryEditor' and text()='Try here>>>']");

	private By Editor_input_box_applications=By.xpath("//div/form[@id='answer_form']");
	private By run_applications=By.xpath("//form/button[text()='Run']");
	private By output_applications=By.id("//form[@id='answer_form']//button[text()='Run']");
	private By content_outapplications=By.id("content");
	private By PracticeQuestion= By.linkText("Practice Questions");
	
	/*public WebDriver driver;
	public 	StackPageObject(WebDriver driver) {
		this.driver=driver;
	}*/
public DriverFactory driverfactory;
	
	WebDriver driver;
	public StackPageObject(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();	
	}
	
	public void click_stack_getstarted()
	{
		driver.findElement(Stack_Started).click();
	}
	

	public void stack_topics_covered_section()
	{
		WebElement topics=driver.findElement(Stack_topics_cvrd);
		new Actions(driver).scrollToElement(topics).perform();
		System.out.println("Scrolled down to Topics Covered under the : Section");
	
	}
	public List<String> stack_topicscovered_list()
	{
		List<String>stacklistTopics=new ArrayList<>();
		List<WebElement> topics_Stack=driver.findElements(Stack_list_of_topics);
		for (WebElement stack_topics:topics_Stack)
		{
			String stacklist=stack_topics.getText();
			stacklistTopics.add(stacklist);
		}
		return stacklistTopics;
	}
	public void click_operations_in_Stack()
	{
		driver.findElement(Operations_in_stack).click();
	}
	
	public void click_TryHere_from_Operationsinstack()
	{
		driver.findElement(TryHere_Operations_in_Stack).click();
	}
	
	
	public void run_OperationsinStack()
	{
		driver.findElement(run_stack).click();
	}
	
	public void Ouptput_OperationsinStack()
	{
		WebElement output=driver.findElement(output_stack);
		String result = output.getText();
		System.out.println("The output of valid Python code is:" +result);
		
	}
	
	/*public void invalid_editor_out()
	{
		WebElement invalidcode_out=driver.findElement(Editor_input_box_operations_in_stack);
		new Actions(driver).sendKeys(invalidcode_out,"p('Invalid Code')").perform();
	}*/
	
	public void error_alert_out()
	{
		Alert alert = driver.switchTo().alert();
		String alert_message=alert.getText();
		System.out.println("Error occured is: " +alert_message);
        alert.accept();
	}
	
	public void goback_frmTryeditor()
	{
		driver.navigate().back();
	}
	public void contents_Operations_in_Stack()
	{
		boolean content=driver.findElement(content_operationsinStack).isDisplayed();
		if (content)
			{
			System.out.println("Topics Covered under Stack sections are present on left side of the screen");
			}
			
}
	public void click_Implementation() {
		driver.findElement(implementation).click();
		
	}
	  
   public void click_tryHere_on_Implementation()
   { 
	driver.findElement(TryHere_implementation).click();
    }
   public void validcode_editor_out_implementation()
   {
	 WebElement validcode_out=driver.findElement(Editor_input_box_implementation);
   }
   public void getPythonCode_from_excel(String string) {
		WebElement invalidcode = driver.findElement(Editor_input_box_operations_in_stack);
		new Actions(driver).sendKeys(invalidcode, string).perform();
   }
   public void run_implementation()
   {
	 driver.findElement(run_implementation).click();
   }
   public void Ouptput_implementation()
   {
	 WebElement output=driver.findElement(output_implementation);
	 String result = output.getText();
	 System.out.println("The output of valid Python code is:" +result);
	}

   public void invalid_editor_out_Implementation()
  {
	WebElement invalidcode_out=driver.findElement(Editor_input_box_implementation);
	
  }

  public void error_alert_out_Implementation()
  {
	 Alert alert = driver.switchTo().alert();
	 String alert_message=alert.getText();
	 System.out.println("Error occured is: " +alert_message);
     alert.accept();
   }

  public void goback_frmTryeditor_of_Implemenetation()
  { 
	driver.navigate().back();
  }
  public void contents_on_outpage_Implementation()
  {
	boolean content=driver.findElement(content_outimplementation).isDisplayed();
	if (content)
		{
		System.out.println("Topics Covered under stack sections are present on left side of the screen");
		}
		
  }
  public void click_applications()
 {
	driver.findElement(applications).click();
 }

  public void click_TryHere_from_applications()
  {
	driver.findElement(TryHere_in_applications).click();
  }

public void validcode_editor_out()
{
	WebElement validcode_out=driver.findElement(Editor_input_box_applications);
	new Actions(driver).sendKeys(validcode_out,"print('Hello it is a Valid Python Code')").perform();
	 
}

public void run_Applications()
{
	driver.findElement(run_applications).click();
}

public void Ouptput_Applications()
{
	WebElement output=driver.findElement(output_applications);
	String result = output.getText();
	System.out.println("The output of valid Python code is:" +result);
	
}

public void invalid_editor_out()
{
	WebElement invalidcode_out=driver.findElement(Editor_input_box_applications);
	new Actions(driver).sendKeys(invalidcode_out,"p('Invalid Code')").perform();
}



public void contents_on_outpage()
{
	boolean content=driver.findElement(content_outapplications).isDisplayed();
	if (content)
		{
		System.out.println("Topics Covered under Stack sections are present on left side of the screen");
		}
		
}
public void click_Practice_Questions() {
driver.findElement(PracticeQuestion).click();

}
	

public void show_output() {
	WebElement output = driver.findElement(output_stack);
	output.getText();
	boolean output_isDisplayed = output.isDisplayed();
	Assert.assertTrue(output_isDisplayed, "Output is not displayed");
	System.out.println("Output is " + output);
	
}
  public void click_PracticeQuestion() {
	driver.findElement(PracticeQuestion).click();
}
public void is_practiceQuestion_Displayed() {
boolean content = driver.getPageSource().contains("Practice Questions.....");
Assert.assertTrue(content, "No Practice Questions Available");


	
}

	


public void invalidcode_error() {
	// TODO Auto-generated method stub
	
}

public void click_tryhereapplication() {
	driver.findElement(TryHere_in_applications).click();
}


public void click_tryHereApplication() {
	driver.findElement(TryHere_in_applications).click();
	}

public void run_button() {
	
		driver.findElement(btnrun).click();
	}
	
}




	



