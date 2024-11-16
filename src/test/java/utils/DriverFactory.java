package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import lombok.Synchronized;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// public static WebDriver driver;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DriverFactory.class);

	public WebDriver initializeDrivers(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			logger.info("Testing on chrome");
			// driver = new ChromeDriver();
			driver.set(new ChromeDriver());
			

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			logger.info("Testing on firefox");
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}

		else if (browser.equalsIgnoreCase("safari")) {

			logger.info("Testing on safari");
			// driver = new SafariDriver();
			driver.set(new SafariDriver());

		} else if (browser.equalsIgnoreCase("edge")) {

			logger.info("Testing on edge");
			// driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		// Set Page load timeout

		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get().manage().window().maximize();

		return driver.get();

	}

	public static synchronized WebDriver getdriver() {

		return driver.get();
	}

}
