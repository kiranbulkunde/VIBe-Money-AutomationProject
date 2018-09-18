package com.qa.vib.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeCompanyConfigPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminLoginPage;
import com.qa.vib.util.TestUtil;

public class AdminHomeCompanyConfigPageTest extends TestBase {


	AdminLoginPage aLoginPage;   
	AdminHomePage aHomePage;
	AdminHomeCompanyConfigPage compConfigPage;
	TestUtil testUtil;

	public AdminHomeCompanyConfigPageTest(){
		super(); 
	}

	@BeforeMethod
	public void setUp() throws Throwable 
	{
		initialization();
		testUtil = new TestUtil();
		aLoginPage = new AdminLoginPage();
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		compConfigPage = new AdminHomeCompanyConfigPage();
		compConfigPage = aHomePage.clickonMasterCompanyConfig();
	}

	@Test(priority = 1)
	public void verifyComConfigTitleTest() {
		boolean title = compConfigPage.validateCompanyConfigTitle();
		Assert.assertTrue(title);
	}

	@DataProvider
	public Object[][] getSearchData() {
		Object data[][] = TestUtil.getTestData("CompConfigData");
		return data;	
	}

	@Test(priority = 2, dataProvider = "getSearchData")
	public void verifyCompanyConfigSearchTest(String searchInput) {
		compConfigPage.searchOption(searchInput);
		WebElement text = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));
		String actualSearch = text.getText();
		Assert.assertEquals(actualSearch, searchInput,"SEARCH INPUT provided by user is not in the SEARCH Result");	
	}

	@AfterMethod
	/*public void adminLogout() {
		aHomePage.clickonLogOut();
	}*/

	public void shutDown(){
		driver.quit();
	}


}
