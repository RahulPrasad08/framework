package com.dd.testcases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

//import java.util.logging.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeClass;
import com.dd.utilities.WebDriverUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.dd.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	
	protected WebDriverWait wait;
	public static WebDriver driver;
	//public static Logger logger;
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	static ExtentTest test;
	public WebDriverUtilities utils;
	
	
	@BeforeClass
	public void setup() {
		
		//report = new ExtentReports(System.getProperty("user.dir")+"/ ExtentReportResults.html");
		//test = report.startTest("ExtentDemo");
		
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			driver = null;
			logger.error("Invalid browser name specified in config.properties.");
			break;
	}
	
	if (driver != null) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		
		// The key fix: initialize the utility class instance *after* the driver
		utils = new WebDriverUtilities(driver);
		logger.info("WebDriverUtilities instance initialized successfully.");
	}
		logger = LogManager.getLogger("My Shine");
		
		
		
		// The key fix: initialize the utility class instance
				
			//	logger.info("WebDriverUtilities instance initialized successfully.");
		
	}

	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

	/*--------------Generic Method-------------------------*/
	
	
	
	  public void click(WebElement element) { 
		  //wait.until(ExpectedConditions.elementToBeClickable(element));
	  element.click();
	  }
	 
	 public void type(WebElement element, String text) { // Instance method
	       // wait.until(ExpectedConditions.visibilityOf(element));
	        element.clear();
	        element.sendKeys(text);
	    }
	 public void mouseHoverAndClick(WebElement hoverLocator, WebElement clickLocator) {
	        try {
	            // 1. Wait for the element to hover over to be visible
	            WebElement hoverElement = hoverLocator;
	            System.out.println("Hover element visible: " + hoverLocator.toString());

	            // 2. Perform the hover action
	            Actions actions = new Actions(driver);
	            actions.moveToElement(hoverElement).perform();
	            System.out.println("Performed mouse hover over element: " + hoverLocator.toString());

	            // 3. After hover, wait for the clickable element (sub-menu item) to appear/be clickable
	            WebElement clickableElement = clickLocator;
	            System.out.println("Clickable element appeared: " + clickLocator.toString());

	            // 4. Click the sub-menu item
	            clickableElement.click();
	            System.out.println("Clicked on element: " + clickLocator.toString() + " after hover.");

	        } catch (NoSuchElementException e) {
	            System.err.println("Element not found during hover-and-click. Check locators for: " + hoverLocator.toString() + " or " + clickLocator.toString());
	            throw new RuntimeException("Element not found during hover-and-click: " + e.getMessage(), e);
	        } catch (WebDriverException e) {
	            System.err.println("A WebDriver error occurred during hover-and-click on " + hoverLocator.toString() + " then " + clickLocator.toString() + ". Error: " + e.getMessage());
	            throw new RuntimeException("WebDriver error during hover-and-click: " + e.getMessage(), e);
	        }
	 }
	 public void scrollIntoView(WebElement element) {
	        
         WebElement scrollDown = element;
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", scrollDown);
         System.out.println("Scrolled element into view: " + element.toString());
     }
	 
	 public static void selectOptionFromDropdown(WebElement element, String type, String value) {
	        Select select= new Select(element);
			
	            switch (type) {
	                case "visibletext":
	                    select.selectByVisibleText(value);
	                   
	                    break;
	                case "value":
	                    select.selectByValue(value);
	                    break;
	                case "index":
	                    select.selectByIndex(Integer.parseInt(value));
	                    break;
	               
	                
	                default:
	                	System.out.println("Please pass the correct selection code");
	                	break;
	        }
	    }

	//private static WebElement getElement(WebElement element) {
		// TODO Auto-generated method stub
		//return null;
	//}
	 
	 public void doubleClick(WebDriver driver, WebElement element) {
	        try {
	            Actions actions = new Actions(driver);
	            actions.doubleClick(element).perform();
	            logger.info("Successfully performed double-click on the element.");
	        } catch (Exception e) {
	            logger.error("Failed to perform double-click on the element.", e);
	            throw e;
	        }
	    }
}


	 
	
