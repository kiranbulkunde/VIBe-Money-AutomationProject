package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeApprovalLevelPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeApprovalLevelPageTest extends TestBase {

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeApprovalLevelPage approvalLevelPage;
	TestUtil testUtil;

	public AdminHomeApprovalLevelPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable 
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		approvalLevelPage = new AdminHomeApprovalLevelPage();
		approvalLevelPage = aHomePage.clickonMasterApprovalLevel();
	}

	@Test(priority = 1)
	public void verifyApprovalLevelTitleTest() {
		boolean title = approvalLevelPage.validateApprovalLevelTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getApprovalLevelTestData() {
		Object data[][] = TestUtil.getTestData("ApprovalLevelData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getApprovalLevelTestData")
	public void verifyAddNewApprovalLevelTest(String approvalName)  {
		approvalLevelPage.addNewApprovalLevel(approvalName);
		String approvalNameSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+approvalName+"')]")).getText();
		Assert.assertEquals(approvalNameSearch, approvalName);
	}

	@Test(priority = 3, dataProvider = "getApprovalLevelTestData")
	public void verifyApprovalLevelSearchResult(String approvalName) {
		approvalLevelPage.validateApprovalLevelBySearch(approvalName);
		String approvalNameSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+approvalName+"')]")).getText();
		Assert.assertEquals(approvalNameSearch, approvalName, '"'+approvalName+"'" +"Approval Level in Search Result not Available");
	}

	@AfterMethod
	public void adminLogout() {
		aHomePage.clickonLogOut();
	}

	public void shutDown(){
		driver.quit();
	}	


}
