package org.qait.coach.Actions.coach2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	WebDriver driver = null;
	String browser;
	ConfigPropertyReader configObj;
	String exePath;

	public WebDriver LaunchApplication() {
	
		configObj = new ConfigPropertyReader();
		browser = (String) configObj.getOptionValue("browser");
		System.out.println(browser);
		if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}

		
		else if (browser.equalsIgnoreCase("chrome")) {
			
			exePath = "C:" + File.separator + "Users" + File.separator + "somilbansal" + File.separator + "Desktop"
					+ File.separator + "Driver" + File.separator + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("InternetExplorer")) {
		
			exePath = "C:" + File.separator + "Users" + File.separator + "somilbansal" + File.separator + "Desktop"
					+ File.separator + "Driver" + File.separator + "IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", exePath);
		
			driver = new InternetExplorerDriver();
		}

		
		else if (browser.equalsIgnoreCase("Edge")) {
	
			exePath = "C:" + File.separator + "Program Files (x86)" + File.separator + "Microsoft Web Driver" +  File.separator + "MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", exePath);
			
			driver = new EdgeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://storefront:coach123@dwstaging2.coach.com/");
		return driver;
	}
}
