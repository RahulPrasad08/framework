package com.dd.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myDashboard  {

	// Create object of WebDriver
	WebDriver ldriver;

	public myDashboard(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	// Identify Webelements
		@FindBy(xpath = "//li[@class='dropdown posRel infomenu carrerInfo lgout']/*[1]")
		WebElement profile;
		
		@FindBy(xpath = "(//a[contains(text(),'Profile ')])[1]")
		WebElement profile1;
		
		
		


public String getTitle() {
	String actualTitle = ldriver.getTitle();
	System.out.println("Print Actual Title :" + actualTitle);
	String expectedTitle ="Jobs - Job Search 2025 - Latest Job Vacancies - Recruitment - Shine.com";
	assertEquals(actualTitle, expectedTitle);
	return actualTitle;
	
}
public String verifyProfile() {
	
	String myProfile = profile.getText();
	System.out.print(myProfile);
	String expectedProfile = "Hi, Rahul";
	assertEquals(myProfile, expectedProfile);
	return profile.getText();
}

public void mouseHover()  {
	WebElement mainMenu = ldriver.findElement(By.xpath("(//a[contains(text(),'Profile ')])[1]"));

	//Instantiating Actions class
	Actions actions = new Actions(ldriver);

	//Hovering on main menu
	actions.moveToElement(mainMenu);

	//Thread.sleep(5000);
	// Locating the element from Sub Menu
	WebElement subMenu = ldriver.findElement(By.xpath("//*[@id=\"ReactContainer\"]/div[1]/header/nav/div/div/ul[1]/li[5]/ul/li[2]/ul/li[1]/a"));

	//To mouseover on sub menu
	actions.moveToElement(subMenu);

	//build()- used to compile all the actions into a single step 
	actions.click().build().perform();
	
	System.out.print("Test Case Passed");
}

//public void close_browser(WebDriver driver){
	//driver.close();
//}

//public void click_element(WebDriver driver){
//	driver
}


//}