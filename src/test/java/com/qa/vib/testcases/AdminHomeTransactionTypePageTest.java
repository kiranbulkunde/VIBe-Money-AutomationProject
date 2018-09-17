package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminHomeTransactionTypePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeTransactionTypePageTest extends TestBase {
	
	
	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeTransactionTypePage transTypePage;
	TestUtil testUtil;
	
	
	public AdminHomeTransactionTypePageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		transTypePage = new AdminHomeTransactionTypePage();
		transTypePage = aHomePage.clickonTransactionType();
	}
	
	@Test(priority = 1)
	public void verifyTransactionTypePageTitleTest() {
		boolean title = transTypePage.validateTransTypeTitle();
		Assert.assertTrue(title);
	}
	
	@DataProvider
	public Object[][] getTransTypeTestData() {
		Object data[][] = TestUtil.getTestData("TransactionTypeData");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getTransTypeTestData")
	public void verifyAddNewTransactionTypeTest(String transTypeName) throws InterruptedException  {
		Thread.sleep(3000);
		transTypePage.addNewTransType(transTypeName);
		String transTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+transTypeName+"')]")).getText();
		Assert.assertEquals(transTypeSearch, transTypeName);
	}
	
	@Test(priority = 3, dataProvider = "getTransTypeTestData")
	public void verifySearchResult(String transTypeName) {
		transTypePage.validateTransTypeNameBySearch(transTypeName);
		String transTypeSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+transTypeName+"')]")).getText();
		Assert.assertEquals(transTypeSearch, transTypeName, '"'+transTypeName+"'" +"Transaction Type in Search Result not Available");
	}
	
	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}

	public void shutDown(){
		driver.quit();
	}
	

}
