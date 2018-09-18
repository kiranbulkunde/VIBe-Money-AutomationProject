package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminHomePassPolicyPage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomePassPolicyPageTest extends TestBase{

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomePassPolicyPage passPolicyPage;
	TestUtil testUtil;


	public AdminHomePassPolicyPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		passPolicyPage = new AdminHomePassPolicyPage();
		passPolicyPage = aHomePage.clickonConfigPassPolicy();
	}

	@Test(priority = 1)
	public void verifyPassPolicyPageTitleTest() {
		boolean title = passPolicyPage.validatePasswordPolicyTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getPassPolicyTestData() {
		Object data[][] = TestUtil.getTestData("PasswordPolicyData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getPassPolicyTestData")
	public void verifyAddPassPolicyTest(String passPolicyName, String policyDetails, String notificationPriority, String date)  {
		passPolicyPage.addPasswordPolicy(passPolicyName, policyDetails, notificationPriority, date);

		String policyNameSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+passPolicyName+"')]")).getText();
		Assert.assertEquals(policyNameSearch, passPolicyName);
	}

	@Test(priority = 3, dataProvider = "getPassPolicyTestData")
	public void verifyPassPolicyNameSearchResult(String passPolicyName, String policyDetails, String notificationPriority, String date) {
		passPolicyPage.validatePassworPolicyByNameInSearch(passPolicyName, policyDetails, notificationPriority, date);
		String policyNameSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+passPolicyName+"')]")).getText();
		Assert.assertEquals(policyNameSearch, passPolicyName, '"'+passPolicyName+"'" +"Policy Name not Available in Search Result");
	}

	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/

	public void shutDown(){
		driver.quit();
	}	

}
