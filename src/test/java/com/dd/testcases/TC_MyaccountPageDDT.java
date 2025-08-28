package com.dd.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dd.pageobject.loginPage;
import com.dd.utilities.ReadExcelFile;

public class TC_MyaccountPageDDT extends BaseClass{
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail,String userPwd) {
		//open url
		driver.get(url);
		logger.info("url open");
		driver.manage().window().maximize();
		
		loginPage lp = new loginPage(driver);
		lp.clickonLogin();
		lp.enterEmail(userEmail);
		lp.enterPassword(userPwd);
		lp.loginClick();
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}