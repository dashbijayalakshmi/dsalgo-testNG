package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.DriverFactory;

public class landingpageobjects {
private By h1tag_launchpage=By.cssSelector("h1");
private By ptag_launchpage=By.cssSelector("p");
private By getStarted=By.linkText("Get Started");
//private By getStarted=By.xpath("//a/button[@class='btn']");

/*WebDriver driver;
public landingpageobjects(WebDriver driver) {
	this.driver=driver;
}*/
public DriverFactory driverfactory;

WebDriver driver;
public landingpageobjects(WebDriver driver) {
	//this.driver=driver;
	driverfactory=new DriverFactory();
	this.driver=driverfactory.getdriver();	
}
public String get_Title() {
	return driver.getTitle();
}
public boolean h1_ptag_getstarted() {
	WebElement h1=driver.findElement(h1tag_launchpage);
	System.out.println(h1.getText());
	WebElement ptag=driver.findElement(ptag_launchpage);
	WebElement getstarted_btn=driver.findElement(getStarted);
	return h1.isDisplayed() && ptag.isDisplayed() && getstarted_btn.isDisplayed();
}
public String h1_display() {
	String h1tag=driver.findElement(h1tag_launchpage).getText();
	return h1tag;
}public String p_diaplay() {
	String ptag=driver.findElement(ptag_launchpage).getText();
	return ptag;
}public String getstarteddp() {
	String getstarted_link=driver.findElement(getStarted).getText();
	return getstarted_link;
}public void click_getstartbtn() {
	driver.findElement(getStarted).click();
}

}
