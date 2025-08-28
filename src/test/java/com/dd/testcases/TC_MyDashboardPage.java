package com.dd.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.dd.pageobject.loginPage;
import com.dd.pageobject.myDashboard;

public class TC_MyDashboardPage extends BaseClass{
	@Test
	public void verifyDashboard()  {
		
		
		//open url
		driver.get(url);
		logger.info("url open");
		driver.manage().window().maximize();
		
		loginPage lp = new loginPage(driver);
		lp.clickonLogin();
		lp.enterEmail("sons.rahul@gmail.com");
		lp.enterPassword("Shine@123");
		lp.loginClick();
		
		myDashboard myd = new myDashboard(driver);
		myd.getTitle();
		myd.verifyProfile();
		myd.mouseHover();
		//myd
		
		//myd.close_browser(driver);
		/*
		 * String actualTitle = driver.getTitle(); String expectedTitle =
		 * "Jobs - Job Search 2025 - Latest Job Vacancies - Recruitment - Shine.com";
		 * System.out.println("Capture Title : " + actualTitle);
		 * assertEquals(actualTitle, expectedTitle);
		 */
		//String expectedTitle = ""
		
	}

}
