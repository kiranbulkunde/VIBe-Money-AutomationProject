package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;

import com.qa.vib.pages.AdminHomeCountryPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeCountryPageTest extends TestBase{
	
	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeCountryPage countryPage;
	TestUtil testUtil;
	
	public AdminHomeCountryPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		countryPage = new AdminHomeCountryPage();
		countryPage = aHomePage.clickonMasterCountry();
	}
	
	@Test(priority = 1)
	public void verifyCountryPageTitleTest() {
		boolean title = countryPage.validateCountryTitle();
		Assert.assertTrue(title);
	}
	
	@DataProvider
	public Object[][] getCountryTestData() {
		Object data[][] = TestUtil.getTestData("CountryData");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getCountryTestData")
	public void verifyAddNewCountryTest(String countryName) throws InterruptedException  {
		Thread.sleep(3000);
		countryPage.addNewCountry(countryName);
		String countrySearch =  driver.findElement(By.xpath("//td[contains(text(),'"+countryName+"')]")).getText();
		Assert.assertEquals(countrySearch, countryName);
	}
	
	@Test(priority = 3, dataProvider = "getCountryTestData")
	public void verifySearchResult(String countryName) {
		countryPage.validateCountryNameBySearch(countryName);
		String countrySearch =  driver.findElement(By.xpath("//td[contains(text(),'"+countryName+"')]")).getText();
		Assert.assertEquals(countrySearch, countryName, '"'+countryName+"'" +"Country not Available in Search Result");
	}
	
	/*@Test(priority = 4, dataProvider = "getCountryTestData")
	public void verifyDeleteCountryTest(String countryName) throws Throwable {
		countryPage.deleteCountry(countryName);	
		//String countrySearch =  driver.findElement(By.xpath("//td[contains(text(),'"+countryName+"')]")).getText();
		//Assert.assertFalse(false, countrySearch);
	}*/
	
	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/
	
	public void shutDown(){
		driver.quit();
	}
	
}
