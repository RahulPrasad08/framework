package com.dd.pageobject;

import java.lang.classfile.instruction.DiscontinuedInstruction.JsrInstruction;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.dd.testcases.BaseClass;

public class myProfile extends BaseClass {
	// Create object of WebDriver
	WebDriver ldriver;

	public myProfile(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Identify Webelements

	@FindBy(xpath = "//span[@class='spanName']")
	WebElement profileHover;
	
	@FindBy(xpath = "//a[text()='My profile']")
	WebElement profileClick;
	
	@FindBy(xpath = "//div[text()='Work Summary']")
	WebElement workSummary;
	
	@FindBy(xpath = "(//span[@class='links'])[1]")
	WebElement clickWorkSummaryEdit;
	
	@FindBy(xpath = "//input[@id='id_resume_title']")
	WebElement projectTitle;
	
	@FindBy(xpath = "//input[@id='id_summary']")
	WebElement projectSummary;
	
	@FindBy(xpath = "//select[@id='id_experience_in_years']")
	WebElement totalExperience;
	
	@FindBy(xpath = "//select[@id='id_teamSize']")
	WebElement teamSize;
	
	@FindBy(xpath = "//select[@id='id_minsalLakh']")
	WebElement currentSalary;
	
	@FindBy(xpath = "//select[@id='id_noticePeriod']")
	WebElement noticePeriod;
	
	
	
	
	 public void PrifileHoverandClick() {
		 mouseHoverAndClick(profileHover, profileClick);
	 }
	 public void scrollWorkSummary(WebElement element) {
		 scrollIntoView(workSummary); 
	 }
	 public void clickWorkSummary() {
		 click(clickWorkSummaryEdit); 
	 }
	 public void typeProjectTitle() {
		 click(clickWorkSummaryEdit); 
	 }
	
	// public void typeProjectTitle(String title) {
		// projectTitle.sendKeys(title);
		//}
	// public void typeProjectSummary(String summary) {
		// projectTitle.sendKeys(summary);
		//}
    
	 
	 
	public void editWorkSummary() {
		PrifileHoverandClick();
		scrollWorkSummary(workSummary);
		clickWorkSummary();
		type(projectTitle, "QA Automation Specialist");
		type(projectSummary, "Senior QA Automation");
		selectOptionFromDropdown( totalExperience, "index", "10");
		selectOptionFromDropdown( currentSalary, "value", "200000");
		selectOptionFromDropdown( noticePeriod, "visibletext", "Immediate Joiner");
	
	}
}