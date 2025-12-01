package com.dd.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.pageobject.loginPage;
import com.dd.utilities.WebDriverUtilities;
import com.dd.pageobject.myProfile;

import org.testng.annotations.Test;

public class TC_MyProfile extends BaseClass {

	@Test
	public void verifyLogin() throws InterruptedException {

		loginPage lp = new loginPage(driver);

		lp.clickonLogin();
		//lp.doubleClick(driver, null);
		myProfile mp = new myProfile(driver);
		mp.editWorkSummary();
		
       
	}

}
