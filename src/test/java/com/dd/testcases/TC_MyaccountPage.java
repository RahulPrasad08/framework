package com.dd.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.pageobject.loginPage;
import com.dd.utilities.WebDriverUtilities;

import org.testng.annotations.Test;

public class TC_MyaccountPage extends BaseClass {

	@Test
	public void verifyLogin() throws InterruptedException {

		loginPage lp = new loginPage(driver);
		lp.clickonLogin();
		lp.verifyPageTitle();
		
		//lp.PrifileHoverandClick();
       
	}
}
