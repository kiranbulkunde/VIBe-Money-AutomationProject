package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminHomeServicesPage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeServicesPageTest extends TestBase {
	
	
	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeServicesPage servicesPage;
	TestUtil testUtil;
	
	
	public AdminHomeServicesPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		servicesPage = new AdminHomeServicesPage();
		servicesPage = aHomePage.clickonMasterServices();
	}
	
	@Test(priority = 1)
	public void verifyServicesPageTitleTest() {
		boolean title = servicesPage.validateServicesTitle();
		Assert.assertTrue(title);
	}
	
	@DataProvider
	public Object[][] getServicesTestData() {
		Object data[][] = TestUtil.getTestData("ServicesData");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getServicesTestData")
	public void verifyAddNewServicesTest(String servicesName)  {
		servicesPage.addNewServices(servicesName);
		String servicesSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+servicesName+"')]")).getText();
		Assert.assertEquals(servicesSearch, servicesName);
	}
	
	@Test(priority = 3, dataProvider = "getServicesTestData")
	public void verifyServicesSearchResult(String servicesName) {
		servicesPage.validateServicesNameBySearch(servicesName);
		String servicesSearch =  driver.findElement(By.xpath("//td[contains(text(),'"+servicesName+"')]")).getText();
		Assert.assertEquals(servicesSearch, servicesName, '"'+servicesName+"'" +"Services not Available in Search Result");
	}
	
	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/
	
	public void shutDown(){
		driver.quit();
	}	
	
		
}
