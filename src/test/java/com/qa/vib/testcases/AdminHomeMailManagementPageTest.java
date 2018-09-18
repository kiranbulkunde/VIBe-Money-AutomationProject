package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeMailManagementPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeMailManagementPageTest extends TestBase{

	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeMailManagementPage mailMgtPage;
	TestUtil testUtil;


	public AdminHomeMailManagementPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		mailMgtPage = new AdminHomeMailManagementPage();
		mailMgtPage = aHomePage.clickonConfigMailManagement();
	}

	@Test(priority = 1)
	public void verifyMailManagementtPageTitleTest() {
		boolean title = mailMgtPage.validateMailManagementTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getMailManagementTestData() {
		Object data[][] = TestUtil.getTestData("MailManagementData");
		return data;
	}

	@Test(priority = 2, dataProvider = "getMailManagementTestData")
	public void verifyAddMailManagementTest(String serviceType, String mobNum, String freqField, String urlPath)  {
		mailMgtPage.addNewMailManagement(serviceType, mobNum, freqField, urlPath);
		String searchByMobNum =  driver.findElement(By.xpath("//td[contains(text(),'"+mobNum+"')]")).getText();
		Assert.assertEquals(searchByMobNum, mobNum);
	}

	@Test(priority = 3, dataProvider = "getMailManagementTestData")
	public void verifyMailManagementSearchResult(String serviceType, String mobNum, String freqField, String urlPath) {
		mailMgtPage.validateNewMailManagementByMobNumBySearch(serviceType, mobNum, freqField, urlPath);
		String searchByMobNum =  driver.findElement(By.xpath("//td[contains(text(),'"+mobNum+"')]")).getText();
		Assert.assertEquals(searchByMobNum, mobNum, '"'+mobNum+"'" +"Mobile Number not Available in Search Result");
	}

	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/

	public void shutDown(){
		driver.quit();
	}	

}
