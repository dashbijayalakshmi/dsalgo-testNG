package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.DriverFactory;

public class homepage_pageobject 
{
	/*WebDriver driver;
	public homepage_pageobject(WebDriver driver) {
		this.driver=driver;*/
	
	
	
	private By dropdown_arrow=By.xpath("//div/a[@class='nav-link dropdown-toggle']");
	private By dropdownlist=By.cssSelector("div.dropdown-menu");
	private By datastructure=By.linkText("Data Structures");
	private By elements=By.cssSelector("a");
public DriverFactory driverfactory;
	
	WebDriver driver;
	public homepage_pageobject(WebDriver driver) {
		//this.driver=driver;
		driverfactory=new DriverFactory();
		this.driver=driverfactory.getdriver();
	}
	public void is_dropdownlist_present()
	{
		//driver.findElement(dropdown_arrow).click();
		boolean dropdown=driver.findElement(dropdown_arrow).isDisplayed();
		Assert.assertTrue(dropdown, "Dropdown list is not present");
		System.out.println("Dropdown field is present");
	}
	
	
	public List<String> datastructure() {
		driver.findElement(datastructure).click();
		List<String>ListData=new ArrayList<>();
		WebElement ddlist=driver.findElement(dropdownlist);
		List<WebElement>listitems=ddlist.findElements(elements);
		for(WebElement datastructure:listitems) {
			String text=datastructure.getText();
			ListData.add(text);
		}
		return ListData;
		
	}
	
}
