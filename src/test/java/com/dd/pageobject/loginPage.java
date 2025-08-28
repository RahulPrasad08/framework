package com.dd.pageobject;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.dd.testcases.BaseClass;

public class loginPage extends BaseClass {
	// Create object of WebDriver
	WebDriver ldriver;

	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Identify Webelements
	WebElement LogIn1;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement LogIn;
	
	
	//button[text()='Login']
	@FindBy(xpath = "//input[@id='id_email_login']")
	WebElement EnterEmail;
	
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement EneterPswd;
	
	@FindBy(xpath = "(//button[text()='Login'])[3]")
	WebElement ClickLogin;
	
	@FindBy(xpath = "//button[text()='Allow']")
	WebElement allow;
	
	@FindBy(xpath = "//span[@class='spanName']")
	WebElement profileHover;
	
	@FindBy(xpath = "//a[text()='My profile']")
	WebElement profileClick;
	
	//mouseHoverAndClick
	
	
	
	/*
	 * public void userLogin(String email,String pswd) { click1(LogIn);
	 * EnterEmail.sendKeys(email); EneterPswd.sendKeys(pswd); click1(ClickLogin); }
	 */
	
	
	// Identify Action
	public void clickonLogin() {
		click(LogIn);
		type(EnterEmail, "*********@gmail.com");
		type(EneterPswd, "*********");
		click(ClickLogin);
		//click2(ClickLogin);
		///close_browser
	}
	public void clockonAllow() {
		allow.click();
	}
	public void enterEmail(String email) {
		EnterEmail.sendKeys(email);
	}
	public void enterPassword(String pswd) {
		EneterPswd.sendKeys(pswd);
	}
	public void loginClick() {
		ClickLogin.click();
	}
	//public void clickOnElement(String text) {
	  //  Log.click();
	//}
	 public void enterText(WebElement element){
	        element.sendKeys();
	    }
	 public void close_browser(WebDriver driver){
			driver.close();
		}
	// public void PrifileHoverandClick() {
		// mouseHoverAndClick(profileHover, profileClick);
	
		/*
		 * public void sendKeysonWebElement(WebElement element,String text) {
		 * Log.click(); Log.clear(); Log.sendKeys(text); }
		 */
	 
	 //public void explicitWait
}
