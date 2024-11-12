package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.DriverFactory;

public class PageObjectManger 
{

public WebDriver driver;
public landingpageobjects landingpage;
public Signinpageobjects signinpage;
public DataStructPage datastructpage;

public QueuePageObjects queuepage;
public homepage_pageobject homepage;
public DriverFactory driverfactory;
public ConfigReader configreader;

public GraphPageObjects graphpage;

public RegistrationPageObj registrationpage; 

public ArraysDocPageObjects arraysdocpage;
public TreePageObjects treepageobj;
public Run_PythonCodes runpythoncode;
public LinkedlistPageObject1 linkedlistpageobj;
public StackPageObject stackpageobj;



public PageObjectManger(WebDriver driver) {
	driverfactory=new DriverFactory();
	this.driver=driverfactory.getdriver();	
	
}
public landingpageobjects getLandingpageobjects() {
	landingpage=new landingpageobjects(driver);
	return landingpage;
}
public Signinpageobjects getSigninpageobjects() {
	signinpage=new Signinpageobjects(driver);
	return signinpage;
}
public DataStructPage getdatastructPage() {
	datastructpage=new DataStructPage(driver);
	return datastructpage;
}public ArraysDocPageObjects getArrayDocPage() {
	arraysdocpage=new ArraysDocPageObjects(driver);
	return arraysdocpage;
}
public QueuePageObjects getQueuePage() {
	queuepage=new QueuePageObjects(driver);
	return queuepage;
}	

public TreePageObjects gettreepageobj() {
	treepageobj=new TreePageObjects(driver);
	return treepageobj;
}

public StackPageObject getstackpageobj() {
	stackpageobj=new StackPageObject(driver);
	return stackpageobj;
}
public Run_PythonCodes getruncodeobj()
{
	 runpythoncode=new Run_PythonCodes(driver);
	 return runpythoncode;

}
public RegistrationPageObj getregpageobj()
	{
		registrationpage=new RegistrationPageObj(driver);
		return registrationpage;
	}
public homepage_pageobject gethomepageobj()
{
	homepage=new homepage_pageobject(driver);
	return homepage;
	

}
public GraphPageObjects getGraphPage() {
	graphpage=new GraphPageObjects(driver);
	return graphpage;
}
public LinkedlistPageObject1 getlinkedlistpageobj() 
{
	linkedlistpageobj = new LinkedlistPageObject1(driver);
	return linkedlistpageobj;
}
public DriverFactory getdriverfactory()
{
	driverfactory=new DriverFactory();
	
	return driverfactory;
}
public ConfigReader getconfigreaderfile()
{
	configreader=new ConfigReader();
	return configreader;
			
}

}

