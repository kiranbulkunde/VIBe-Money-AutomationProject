package com.qa.vib.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.vib.base.TestBase;
import com.qa.vib.pages.AdminHomeAMLDetailsPage;
import com.qa.vib.pages.AdminHomeAllocationHistoryPage;
import com.qa.vib.pages.AdminHomeApprovalLevelPage;
import com.qa.vib.pages.AdminHomeCheckBalancePage;
import com.qa.vib.pages.AdminHomeCompanyConfigPage;
import com.qa.vib.pages.AdminHomeCountryPage;
import com.qa.vib.pages.AdminHomeCustomerKYCPage;
import com.qa.vib.pages.AdminHomeImageSliderPage;
import com.qa.vib.pages.AdminHomeInVendorWalletPage;
import com.qa.vib.pages.AdminHomeMailManagementPage;
import com.qa.vib.pages.AdminHomeMoneyTypePage;
import com.qa.vib.pages.AdminHomeOldOTPPage;
import com.qa.vib.pages.AdminHomeOperationPage;
import com.qa.vib.pages.AdminHomePGVendorPage;
import com.qa.vib.pages.AdminHomePage;
import com.qa.vib.pages.AdminHomePassPolicyPage;
import com.qa.vib.pages.AdminHomeProductArtistsPage;
import com.qa.vib.pages.AdminHomeProductAuthorsPage;
import com.qa.vib.pages.AdminHomeProductCollectionPage;
import com.qa.vib.pages.AdminHomeProductGenresPage;
import com.qa.vib.pages.AdminHomeProductMoodPage;
import com.qa.vib.pages.AdminHomeProductPage;
import com.qa.vib.pages.AdminHomeProductPublisherPage;
import com.qa.vib.pages.AdminHomeProductTypesPage;
import com.qa.vib.pages.AdminHomeServicesPage;
import com.qa.vib.pages.AdminHomeStockAllocApprovalPage;
import com.qa.vib.pages.AdminHomeStockAllocationPage;
import com.qa.vib.pages.AdminHomeStockAllowReportPage;
import com.qa.vib.pages.AdminHomeTransactionHistoryPage;
import com.qa.vib.pages.AdminHomeTransactionReportPage;
import com.qa.vib.pages.AdminHomeTransactionTypePage;
import com.qa.vib.pages.AdminHomeTransactionWiseReportPage;
import com.qa.vib.pages.AdminHomeUploadKYCPage;
import com.qa.vib.pages.AdminHomeVIBStorePage;
import com.qa.vib.pages.AdminHomeVendorDetailsPage;
import com.qa.vib.pages.AdminHomeWalletTablePage;
import com.qa.vib.pages.AdminHomeWalletTypePage;
import com.qa.vib.pages.AdminLoginPage;

public class AdminHomePageTest extends TestBase {

	AdminLoginPage aLoginPage;
	AdminHomePage aHomePage;
	AdminHomeCompanyConfigPage adminHomeCompanyConfigPage;
	AdminHomeCountryPage adminHomeCountryPage;
	AdminHomeServicesPage adminHomeServicesPage;
	AdminHomeOperationPage adminHomeOperationPage;
	AdminHomeWalletTypePage adminHomeWalletTypePage;
	AdminHomeApprovalLevelPage adminHomeApprovalLevelPage;
	AdminHomeAMLDetailsPage adminHomeAMLDetailsPage;
	AdminHomeTransactionTypePage adminHomeTransactionTypePage;
	AdminHomeMoneyTypePage adminHomeMoneyTypePage;
	//*******************************************************
	AdminHomeMailManagementPage adminHomeMailManagementPage;
	AdminHomeOldOTPPage adminHomeOldOTPPage;
	AdminHomePassPolicyPage adminHomePassPolicyPage;
	//******************************************************
	AdminHomeWalletTablePage adminHomeWalletTablePage;
	AdminHomeVendorDetailsPage adminHomeVendorDetailsPage;
	AdminHomePGVendorPage adminHomePGVendorPage;
	AdminHomeInVendorWalletPage adminHomeInVendorWalletPage;
	//******************************************************
	AdminHomeTransactionHistoryPage adminHomeTransactionHistoryPage;
	AdminHomeAllocationHistoryPage adminHomeAllocationHistoryPage;
	AdminHomeStockAllocationPage adminHomeStockAllocationPage;
	AdminHomeStockAllocApprovalPage adminHomeStockAllocApprovalPage;
	//*********************************************************
	AdminHomeCustomerKYCPage adminHomeCustomerKYCPage;
	AdminHomeUploadKYCPage adminHomeUploadKYCPage;
	//******************************************************
	AdminHomeCheckBalancePage adminHomeCheckBalancePage;
	//*******************************************************
	AdminHomeTransactionReportPage adminHomeTransactionReportPage;
	AdminHomeTransactionWiseReportPage adminHomeTransactionWiseReportPage;
	AdminHomeStockAllowReportPage adminHomeStockAllowReportPage;
	//*******************************************************
	AdminHomeProductAuthorsPage adminHomeProductAuthorsPage;
	AdminHomeProductArtistsPage adminHomeProductArtistsPage;
	AdminHomeProductGenresPage adminHomeProductGenresPage;
	AdminHomeProductMoodPage adminHomeProductMoodPage;
	AdminHomeProductPublisherPage adminHomeProductPublisherPage;
	AdminHomeProductTypesPage adminHomeProductTypesPage;
	AdminHomeProductCollectionPage adminHomeProductCollectionPage;
	AdminHomeProductPage adminHomeProductPage;
	AdminHomeVIBStorePage adminHomeVIBStorePage;
	//********************************************************
	AdminHomeImageSliderPage adminHomeImageSliderPage;
	//********************************************************
	AdminLoginPage adminLoginPage;
	//*********************************************************
	public AdminHomePageTest(){
		super(); //to call super class constructor which run properties method
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();//initialize
		adminHomeCompanyConfigPage = new AdminHomeCompanyConfigPage();
		adminHomeCountryPage = new AdminHomeCountryPage();
		adminHomeServicesPage = new AdminHomeServicesPage();
		adminHomeOperationPage = new AdminHomeOperationPage();
		adminHomeWalletTypePage = new AdminHomeWalletTypePage();
		adminHomeApprovalLevelPage = new AdminHomeApprovalLevelPage();
		adminHomeAMLDetailsPage = new AdminHomeAMLDetailsPage();
		adminHomeTransactionTypePage = new AdminHomeTransactionTypePage();
		adminHomeMoneyTypePage = new AdminHomeMoneyTypePage();
		//******************************************************
		adminHomeMailManagementPage = new AdminHomeMailManagementPage();
		adminHomeOldOTPPage = new AdminHomeOldOTPPage();
		adminHomePassPolicyPage = new AdminHomePassPolicyPage();
		//********************************************************
		adminHomeWalletTablePage = new AdminHomeWalletTablePage();
		adminHomeVendorDetailsPage = new AdminHomeVendorDetailsPage();
		adminHomePGVendorPage = new AdminHomePGVendorPage();
		adminHomeInVendorWalletPage = new AdminHomeInVendorWalletPage();
		//*********************************************************
		adminHomeTransactionHistoryPage = new AdminHomeTransactionHistoryPage();
		adminHomeAllocationHistoryPage = new AdminHomeAllocationHistoryPage();
		adminHomeStockAllocationPage = new AdminHomeStockAllocationPage();
		adminHomeStockAllocApprovalPage = new AdminHomeStockAllocApprovalPage();
		//**********************************************************
		adminHomeCustomerKYCPage = new AdminHomeCustomerKYCPage();
		adminHomeUploadKYCPage = new AdminHomeUploadKYCPage();
		//************************************************************
		adminHomeCheckBalancePage = new AdminHomeCheckBalancePage();
		//************************************************************
		adminHomeTransactionReportPage = new AdminHomeTransactionReportPage();
		adminHomeTransactionWiseReportPage = new AdminHomeTransactionWiseReportPage();
		adminHomeStockAllowReportPage = new AdminHomeStockAllowReportPage();
		//**************************************************************
		adminHomeProductAuthorsPage = new AdminHomeProductAuthorsPage();
		adminHomeProductArtistsPage = new AdminHomeProductArtistsPage();
		adminHomeProductGenresPage = new AdminHomeProductGenresPage();
		adminHomeProductMoodPage = new AdminHomeProductMoodPage();
		adminHomeProductPublisherPage = new AdminHomeProductPublisherPage();
		adminHomeProductTypesPage = new AdminHomeProductTypesPage();
		adminHomeProductCollectionPage = new AdminHomeProductCollectionPage();
		adminHomeProductPage = new AdminHomeProductPage();
		adminHomeVIBStorePage = new AdminHomeVIBStorePage();
		//****************************************************************
		adminHomeImageSliderPage = new AdminHomeImageSliderPage();
		//***************************************************************
		adminLoginPage = new AdminLoginPage();
		//*************************************************************
		aLoginPage = new AdminLoginPage();//create loginPage object to access loginpage class method
		aHomePage = aLoginPage.adminLogin(prop.getProperty("username"), prop.getProperty("password"));// thats why call login method
	}
	
	@Test(priority = 1)
	public void verifyAdminHomePageTitleTest() throws Throwable {
		Thread.sleep(1000);
		String HomePTitle = aHomePage.verifyAdminHomePageTitle();
		Assert.assertEquals(HomePTitle, "VIB-e-Money","Home Page Title not Matched");
	}

	@Test(priority = 2)
	public void verifyUserEmailTest() {
		Assert.assertTrue(aHomePage.verifyUserCorrectEmail());
	}

	//******************MasterTabTest*************************
	@Test(priority = 3)
	public void verifyCompanyConfigLinkTest() throws Throwable {
		adminHomeCompanyConfigPage = aHomePage.clickonMasterCompanyConfig();
	}
	
	
	@Test(priority = 4)
	public void verifyCountryLinkTest() throws Throwable {
		adminHomeCountryPage = aHomePage.clickonMasterCountry();
	}
	
	@Test(priority = 5)
	public void verifyServicesLinkTest() throws Throwable {
		adminHomeServicesPage = aHomePage.clickonMasterServices();
	}
	
	@Test(priority = 6)
	public void verifyOperationLinkTest() throws Throwable {
		adminHomeOperationPage = aHomePage.clickonMasterOperation();
	}
	
	@Test(priority = 7)
	public void verifyWalletTypeLinkTest() throws Throwable {
		adminHomeWalletTypePage = aHomePage.clickonMasterWalletType();
	}
	
	@Test(priority = 8)
	public void verifyApprovalLevelLinkTest() throws Throwable {
		adminHomeApprovalLevelPage = aHomePage.clickonMasterApprovalLevel();
	}
	
	@Test(priority = 9)
	public void verifyAMLDetailsLinkTest() throws Throwable {
		adminHomeAMLDetailsPage = aHomePage.clickonMasterALMDetails();
	}
	
	@Test(priority = 10)
	public void verifyTransactionTypeLinkTest(){
		adminHomeTransactionTypePage = aHomePage.clickonTransactionType();
	}
	
	@Test(priority = 11)
	public void verifyMoneyTypeLinkTest() {
		adminHomeMoneyTypePage = aHomePage.clickonMoneyType();
	}
	
	//*****************ConfigurationTabTest*******************************
	@Test(priority = 12)
	public void verifyMailManagementLinkTest() throws Throwable {
		adminHomeMailManagementPage = aHomePage.clickonConfigMailManagement();
	}

	@Test(priority = 13)
	public void verifyOldOTPLinkTest() throws Throwable {
		adminHomeOldOTPPage = aHomePage.clickonConfigOldOTP();
	}

	@Test(priority = 14)
	public void verifyPassPolicyTest() throws Throwable {
		adminHomePassPolicyPage = aHomePage.clickonConfigPassPolicy();
	}
	
	//****************VendorTabTest****************************************
	@Test(priority = 15)
	public void verifyWalletTableLinkTest() throws Throwable {
		adminHomeWalletTablePage = aHomePage.clickonVendorWalletTable();
	}
	
	@Test(priority = 16)
	public void verifyVendorDetailsLinkTest() throws Throwable {
		adminHomeVendorDetailsPage = aHomePage.clickonVendorDetails();
	}
	
	@Test(priority = 17)
	public void verifyPGVendorLinkTest() throws Throwable {
		adminHomePGVendorPage = aHomePage.clickonPGVendor();
	}
	
	@Test(priority = 18)
	public void verifyInVendorWalletLinkTest() throws Throwable {
		adminHomeInVendorWalletPage = aHomePage.clickonInVendorWallet();
	}
	
	//****************TransactionTabTest**********************************
	@Test(priority = 19)
	public void verifyTransactionHistoryLinkTest() throws Throwable {
		adminHomeTransactionHistoryPage = aHomePage.clickonTransactionHistory();
	}
	
	@Test(priority = 20)
	public void verifyAllocationHistoryLinkTest() throws Throwable {
		adminHomeAllocationHistoryPage = aHomePage.clickonAllocationHistory();
	}
	
	@Test(priority = 21)
	public void verifyStockAllocationLinkTest() throws Throwable {
		adminHomeStockAllocationPage = aHomePage.clickonStockAllocation();
	}
	
	@Test(priority = 22)
	public void verifyStockAllowApprovalLinkTest() throws Throwable {
		adminHomeStockAllocApprovalPage = aHomePage.clickonStockAllocApproval();
	}
	
	//****************KYC_TabTest****************************************
	@Test(priority = 23)
	public void verifyCustomerKYCLinkTest() throws Throwable {
		adminHomeCustomerKYCPage = aHomePage.clickonCustomerKYC();
	}
	
	@Test(priority = 24)
	public void verifyUploadKYCLinkTest() throws Throwable {
		adminHomeUploadKYCPage = aHomePage.clickonUploadKYC();
	}
	
	//****************CheckBalanceTabTest******************************
	@Test(priority = 25)
	public void verifyCheckBalanceLinkTest() throws Throwable {
		adminHomeCheckBalancePage = aHomePage.clickonCheckBalance();
	}
	
	//*******************ReportTabTest*****************************
	@Test(priority = 26)
	public void verifyTransactionReportLinkTest() throws Throwable {
		adminHomeTransactionReportPage = aHomePage.clickonTransactionReport();
	}
	
	@Test(priority = 27)
	public void verifyTransactionWiseReportLinkTest() throws Throwable {
		adminHomeTransactionWiseReportPage = aHomePage.clickonTransactionWiseReport();
	}
	
	@Test(priority = 28)
	public void verifyStockAllowReportLinkTest() throws Throwable {
		adminHomeStockAllowReportPage = aHomePage.clickonStockAllowReport();
	}
	
	//***********************ProductTabTest********************************
	@Test(priority = 29)
	public void verifyProductAuthorsLinkTest() throws Throwable {
		adminHomeProductAuthorsPage = aHomePage.clickonProductAuthors();
	}
	@Test(priority = 30)
	public void verifyProductArtistsLinkTest() throws Throwable {
		adminHomeProductArtistsPage = aHomePage.clickonProductArtists();
	}
	@Test(priority = 31)
	public void verifyProductGenresTest() throws Throwable {
		adminHomeProductGenresPage = aHomePage.clickonProductGenres();
	}
	@Test(priority = 32)
	public void verifyProductMoodTest() throws Throwable {
		adminHomeProductMoodPage = aHomePage.clickonProductMood();
	}
	@Test(priority = 33)
	public void verifyProductPublisherTest() throws Throwable {
		adminHomeProductPublisherPage = aHomePage.clickonProductPublisher();
	}
	@Test(priority = 34)
	public void verifyProductTypesLinkTest() throws Throwable {
		adminHomeProductTypesPage = aHomePage.clickonProductTypes();
	}
	@Test(priority = 35)
	public void verifyProductCollectionLinkTest() throws Throwable {
		adminHomeProductCollectionPage = aHomePage.clickonProductCollection();
	}
	@Test(priority = 36)
	public void verifyProductLinkTest() throws Throwable {
		adminHomeProductPage = aHomePage.clickonProduct();
	}
	@Test(priority = 37)
	public void verifyVIBStoreLinkTest() throws Throwable {
		adminHomeVIBStorePage = aHomePage.clickonVIBStore();
	}
	
	//********************************************************************
	@Test(priority = 38)
	public void verifyImageSliderLinkTest() throws Throwable {
		adminHomeImageSliderPage = aHomePage.clickonImageSlider();
	}
	
	//******************************************************************
	@Test(priority = 39)
	public void verifyLogoutLinkTest() throws Throwable {
		adminLoginPage = aHomePage.clickonLogOut();
	}
	
	//******************************************************************
	@AfterMethod
	public void shutDown(){
		driver.quit();
	}



}
