package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeMoneyTypePage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeMoneyTypePageTest extends TestBase{

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeMoneyTypePage moneyTypePage;
	TestUtil testUtil;

	public AdminHomeMoneyTypePageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		moneyTypePage = new AdminHomeMoneyTypePage();
		moneyTypePage = aHomePage.clickonMoneyType();
	}

	@Test(priority = 1)
	public void verifyMoneyTypePageTitleTest() {
		boolean title = moneyTypePage.validateMoneyTypeTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getMoneyTypeTestData() {
		Object data[][] = TestUtil.getTestData("MoneyTypeData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getMoneyTypeTestData")
	public void verifyAddNewMoneyTypeTest(String moneyTypeName) throws InterruptedException {
		Thread.sleep(3000);
		moneyTypePage.addNewMoneyType(moneyTypeName);
		String moneyTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+moneyTypeName+"')]")).getText();
		Assert.assertEquals(moneyTypeSearch, moneyTypeName);
	}

	@Test(priority = 3, dataProvider = "getMoneyTypeTestData")
	public void verifySearchResult(String moneyTypeName) {
		moneyTypePage.validateMoneyTypeNameBySearch(moneyTypeName);
		String moneyTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+moneyTypeName+"')]")).getText();
		Assert.assertEquals(moneyTypeSearch, moneyTypeName, '"'+moneyTypeName+"'" +"Money Type in Search Result not Available");
	}

	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}

	public void shutDown(){
		driver.quit();
	}


}
