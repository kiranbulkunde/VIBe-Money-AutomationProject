package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeAMLDetailsPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeAMLDetailsPageTest extends TestBase {
	
	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeAMLDetailsPage amlDetailsPage;
	TestUtil testUtil;
	
	public AdminHomeAMLDetailsPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		amlDetailsPage = new AdminHomeAMLDetailsPage();
		amlDetailsPage = aHomePage.clickonMasterALMDetails();
	}
	
	@Test(priority = 1)
	public void verifyApprovalLevelTitleTest() {
		boolean title = amlDetailsPage.validateAMLDetailsTitle();
		Assert.assertTrue(title);
	}
	
	@DataProvider
	public Object[][] getALMTestData() {
		Object data[][] = TestUtil.getTestData("AMLDetailsData");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getALMTestData")
	public void verifyAddNewALMDetailsTest(String tranPerDay, String tranPerWeek,String tranPerMonth,
										   String tranPerYear,String minLimitTran,String dailyLimitTran,
										   String weeklyLimitTran,String monthlyLimitTran,String yerlyLimitTran,String amlType)  {
		amlDetailsPage.addNewAMLDetails(tranPerDay, tranPerWeek, tranPerMonth, tranPerYear, minLimitTran, dailyLimitTran, weeklyLimitTran, monthlyLimitTran, yerlyLimitTran, amlType);
		//String amlTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+amlType+"')]")).getText();
	//	Assert.assertEquals(amlTypeSearch, amlType);
	}
	
	@Test(priority = 3, dataProvider = "getALMTestData")
	public void verifyALMDetailsSearchResult(String transPDay,String transPWeek, String transPMonth,String transPYear,
											 String minLimitTrans,String dailyLTrans,String weeklyLTrans,String monthlyLTrans,
											 String yearlyLTrans,String amlType) {
		amlDetailsPage.validateAMLDetailsBySearch(amlType);
		String amlTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+amlType+"')]")).getText();
		Assert.assertEquals(amlTypeSearch, amlType, '"'+amlType+"'" +"AML Type in Search Result not Available");
	}
	
	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}
	
	public void shutDown(){
		driver.quit();
	}	
	
		
}
