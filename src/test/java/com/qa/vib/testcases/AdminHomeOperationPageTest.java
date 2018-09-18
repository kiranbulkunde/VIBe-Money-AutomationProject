package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeOperationPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeOperationPageTest extends TestBase{

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeOperationPage operationPage;
	TestUtil testUtil;


	public AdminHomeOperationPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		operationPage = new AdminHomeOperationPage();
		operationPage = aHomePage.clickonMasterOperation();
	}

	@Test(priority = 1)
	public void verifyOprationPageTitleTest() {
		boolean title = operationPage.validateOperationTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getOperationTestData() {
		Object data[][] = TestUtil.getTestData("OperationData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getOperationTestData")
	public void verifyAddNewOperationTest(String servicesName, String operationName, String shortCode)  {
		operationPage.addNewOperation(servicesName, operationName, shortCode);
		String operationSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+operationName+"')]")).getText();
		Assert.assertEquals(operationSearch, operationName);
	}

	@Test(priority = 3, dataProvider = "getOperationTestData")
	public void verifySearchResult(String servicesName, String operationName, String shortCode) {
		operationPage.validateOperationNameBySearch(operationName);
		String operationSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+operationName+"')]")).getText();
		Assert.assertEquals(operationSearch, operationName, '"'+operationName+"'" +"Operation Name not Available in Search Result");
	}

	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}

	public void shutDown(){
		driver.quit();
	}	


}
