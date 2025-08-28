package com.dd.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.dd.testcases.BaseClass;

public class genericFunction extends BaseClass{
	
	
	WebDriver ldriver;

	
	  public genericFunction(WebDriver rdriver) { 
		  ldriver = rdriver;
	  PageFactory.initElements(rdriver, this);
	  
	  }
	 
	
    
	
	 public void close_browser(WebDriver ldriver){
			ldriver.close();
		}
	 
	 public void click2(WebElement element) {
	       // wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    }

	 public void sendKeysonWebElement(WebElement element,String text) {
		 element.click();
		 element.clear();
		 element.sendKeys(text);
	 }
}
