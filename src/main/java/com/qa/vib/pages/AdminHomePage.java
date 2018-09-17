package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomePage extends TestBase{

	//Page Factory-Object Repository for all webElements:

	@FindBy(xpath = "//span[@class='user-level ng-binding']")
	WebElement userEmailLabel;

	@FindBy(xpath = "//span[contains(text(),'Masters')]")
	WebElement masterTab;

	@FindBy(xpath = "//span[contains(text(),'Company Config')]")
	WebElement m_companyConfig;

	@FindBy(xpath = "//span[contains(text(),'Country')]")
	WebElement m_country;

	@FindBy(xpath = "//span[contains(text(),'Services')]")
	WebElement m_services;

	@FindBy(xpath = "//span[contains(text(),'Operation')]")
	WebElement m_operation;

	@FindBy(xpath = "//span[contains(text(),'Wallet Type')]")
	WebElement m_walletType;

	@FindBy(xpath = "//span[contains(text(),'Approval Level')]")
	WebElement m_approvalLevel;

	@FindBy(xpath = "//span[contains(text(),'AML Details')]")
	WebElement m_amlDetails;

	@FindBy(xpath = "//span[contains(text(),'Transaction Type')]")
	WebElement m_transactionType;

	@FindBy(xpath = "//span[contains(text(),'Money Type')]")
	WebElement m_moneyType;

	//********************************************
	@FindBy(xpath = "//span[contains(text(),'Configuration')]")
	WebElement configurationTab;

	@FindBy(xpath = "//span[contains(text(),'Mail Management')]")
	WebElement c_mailManagement;

	@FindBy(xpath = "//span[contains(text(),'Old OTP')]")
	WebElement c_oldOTP;

	@FindBy(xpath = "//span[contains(text(),'Password Policy')]")
	WebElement c_passwordPolicy;

	//*********************************************
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[2]")
	WebElement vendorTab;

	@FindBy(xpath = "//span[contains(text(),'Wallet Table')]")
	WebElement m_walletTable;

	@FindBy(xpath = "//span[contains(text(),'Vendor Details')]")
	WebElement m_vendorDetails;

	@FindBy(xpath = "//span[contains(text(),'PG Vendor')]")
	WebElement m_pgVendor;

	@FindBy(xpath = "//span[contains(text(),'In Vendor Wallet')]")
	WebElement m_inVendorWallet;

	//********************************************
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/a[1]/span[2]")
	WebElement transactionTab;

	@FindBy(xpath = "//span[contains(text(),'Transaction History')]")
	WebElement t_transactionHistory;

	@FindBy(xpath = "//span[contains(text(),'Allocation History']")
	WebElement t_allocationHistory;

	@FindBy(xpath = "//li[@class='has-sub open']//ul//li[3]//a[1]//span[2]")
	WebElement t_stockAllocation;

	@FindBy(xpath = "//span[contains(text(),'Stock Allocation Approvals']")
	WebElement t_stockAllocationApprovals;

	//********************************************
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]")
	WebElement kycTab;

	@FindBy(xpath = "//span[contains(text(),'Customer KYC')]")
	WebElement kyc_customerKYC;

	@FindBy(xpath = "//span[contains(text(),'Upload KYC')]")
	WebElement kyc_uploadKYC;

	//********************************************
	@FindBy(xpath = "//span[contains(text(),'Check Balance']")
	WebElement checkBalanceTab;

	//********************************************
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[7]/a[1]/span[2]")
	WebElement reportTab;

	@FindBy(xpath = "//span[contains(text(),'Transaction Report')]")
	WebElement r_transactionReport;

	@FindBy(xpath = "//span[contains(text(),'Transaction Wise Report')]")
	WebElement r_tWiseReport;

	@FindBy(xpath = "//span[contains(text(),'Stock Allocation Report')]")
	WebElement r_sAllocationReport;	

	//********************************************
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[8]/a[1]/span[2]")
	WebElement productTab;

	@FindBy(xpath = "//span[contains(text(),'Authors')]")
	WebElement p_authors;	

	@FindBy(xpath = "//span[contains(text(),'Artists')]")
	WebElement p_artists;

	@FindBy(xpath = "//span[contains(text(),'Genres']")
	WebElement p_genres;

	@FindBy(xpath = "//span[contains(text(),'Mood']")
	WebElement p_Mood;

	@FindBy(xpath = "//span[contains(text(),'Publisher']")
	WebElement p_publisher;

	@FindBy(xpath = "//span[contains(text(),'Product Types']")
	WebElement p_productTypes;

	@FindBy(xpath = "//span[contains(text(),'Product Collection']")
	WebElement p_productCollection;

	@FindBy(xpath = "//li[@class='has-sub open']//ul//li[8]//a[1]")
	WebElement p_product;

	@FindBy(xpath = "//span[contains(text(),'VIB STORE']")
	WebElement p_vibStore;

	//********************************************
	@FindBy(xpath = "//span[contains(text(),'Image Slider']")
	WebElement imageSliderTab;

	//*********************************************
	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	WebElement logoutTab;

	//*********************************************
	//Initializing the page object

	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}

	////Actions or Features or Methods or functions of AdminHomePage: 

	//**********************MasterTab******************************
	public String verifyAdminHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserCorrectEmail() {
		return userEmailLabel.isDisplayed();
	}

	public AdminHomeCompanyConfigPage clickonMasterCompanyConfig() throws InterruptedException  {
		masterTab.click();
		Thread.sleep(1000);
		m_companyConfig.click();
		return new AdminHomeCompanyConfigPage();	

	}

	public AdminHomeCountryPage clickonMasterCountry() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_country.click();
		return new AdminHomeCountryPage();
	}

	public AdminHomeServicesPage clickonMasterServices() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_services.click();
		return new AdminHomeServicesPage();
	}

	public AdminHomeOperationPage clickonMasterOperation() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_operation.click();
		return new AdminHomeOperationPage();

	}

	public AdminHomeWalletTypePage clickonMasterWalletType() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_walletType.click();
		return new AdminHomeWalletTypePage();

	}

	public AdminHomeApprovalLevelPage clickonMasterApprovalLevel() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_approvalLevel.click();
		return new AdminHomeApprovalLevelPage();
	}

	public AdminHomeAMLDetailsPage clickonMasterALMDetails() throws InterruptedException {
		masterTab.click();
		Thread.sleep(1000);
		m_amlDetails.click();
		return new AdminHomeAMLDetailsPage();
	}

	public AdminHomeTransactionTypePage clickonTransactionType()   {
		masterTab.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m_transactionType.click();
		return new AdminHomeTransactionTypePage();
	}

	public AdminHomeMoneyTypePage clickonMoneyType()  {
		masterTab.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m_moneyType.click();
		return new AdminHomeMoneyTypePage();
	}

	//*************************ConfigurationTab************************

	public AdminHomeMailManagementPage clickonConfigMailManagement() throws InterruptedException  {
		configurationTab.click();
		Thread.sleep(1000);
		c_mailManagement.click();
		return new AdminHomeMailManagementPage();
	}

	public AdminHomeOldOTPPage clickonConfigOldOTP() throws InterruptedException  {
		configurationTab.click();
		Thread.sleep(1000);
		c_oldOTP.click();
		return new AdminHomeOldOTPPage();
	}

	public AdminHomePassPolicyPage clickonConfigPassPolicy() throws InterruptedException  {
		configurationTab.click();
		Thread.sleep(1000);
		c_passwordPolicy.click();
		return new AdminHomePassPolicyPage();
	}

	//***************************VendorTab*****************************

	public AdminHomeWalletTablePage clickonVendorWalletTable() throws InterruptedException  {
		vendorTab.click();
		Thread.sleep(1000);
		m_walletTable.click();
		return new AdminHomeWalletTablePage();
	}

	public AdminHomeVendorDetailsPage clickonVendorDetails() throws InterruptedException  {
		vendorTab.click();
		Thread.sleep(1000);
		m_vendorDetails.click();
		return new AdminHomeVendorDetailsPage();
	}

	public AdminHomePGVendorPage clickonPGVendor() throws InterruptedException  {
		vendorTab.click();
		Thread.sleep(1000);
		m_pgVendor.click();
		return new AdminHomePGVendorPage();
	}

	public AdminHomeInVendorWalletPage clickonInVendorWallet() throws InterruptedException  {
		vendorTab.click();
		Thread.sleep(1000);
		m_inVendorWallet.click();
		return new AdminHomeInVendorWalletPage();
	}

	//***********************TransactionTab*****************************

	public AdminHomeTransactionHistoryPage clickonTransactionHistory() throws InterruptedException  {
		transactionTab.click();
		Thread.sleep(1000);
		t_transactionHistory.click();
		return new AdminHomeTransactionHistoryPage();
	}

	public AdminHomeAllocationHistoryPage clickonAllocationHistory() throws InterruptedException  {
		transactionTab.click();
		Thread.sleep(1000);
		t_allocationHistory.click();
		return new AdminHomeAllocationHistoryPage();
	}

	public AdminHomeStockAllocationPage clickonStockAllocation() throws InterruptedException  {
		transactionTab.click();
		Thread.sleep(1000);
		t_stockAllocation.click();
		return new AdminHomeStockAllocationPage();
	}

	public AdminHomeStockAllocApprovalPage clickonStockAllocApproval() throws InterruptedException  {
		transactionTab.click();
		Thread.sleep(1000);
		m_inVendorWallet.click();
		return new AdminHomeStockAllocApprovalPage();
	}

	//*************************KYC_Tab***********************************

	public AdminHomeCustomerKYCPage clickonCustomerKYC() throws InterruptedException  {
		kycTab.click();
		Thread.sleep(1000);
		kyc_customerKYC.click();
		return new AdminHomeCustomerKYCPage();
	}

	public AdminHomeUploadKYCPage clickonUploadKYC() throws InterruptedException  {
		kycTab.click();
		Thread.sleep(1000);
		kyc_uploadKYC.click();
		return new AdminHomeUploadKYCPage();
	}

	//************************CheckBalance******************************

	public AdminHomeCheckBalancePage clickonCheckBalance() throws InterruptedException  {
		checkBalanceTab.click();
		return new AdminHomeCheckBalancePage();
	}

	//************************ReportTab*********************************

	public AdminHomeTransactionReportPage clickonTransactionReport() throws InterruptedException  {
		reportTab.click();
		Thread.sleep(1000);
		r_transactionReport.click();
		return new AdminHomeTransactionReportPage();
	}

	public AdminHomeTransactionWiseReportPage clickonTransactionWiseReport() throws InterruptedException  {
		reportTab.click();
		Thread.sleep(1000);
		r_tWiseReport.click();
		return new AdminHomeTransactionWiseReportPage();
	}

	public AdminHomeStockAllowReportPage clickonStockAllowReport() throws InterruptedException  {
		reportTab.click();
		Thread.sleep(1000);
		r_sAllocationReport.click();
		return new AdminHomeStockAllowReportPage();
	}

	//**************************ProductTab********************************

	public AdminHomeProductAuthorsPage clickonProductAuthors() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_authors.click();
		return new AdminHomeProductAuthorsPage();
	}

	public AdminHomeProductArtistsPage clickonProductArtists() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_artists.click();
		return new AdminHomeProductArtistsPage();
	}

	public AdminHomeProductGenresPage clickonProductGenres() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_genres.click();
		return new AdminHomeProductGenresPage();
	}

	public AdminHomeProductMoodPage clickonProductMood() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_Mood.click();
		return new AdminHomeProductMoodPage();
	}

	public AdminHomeProductPublisherPage clickonProductPublisher() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_publisher.click();
		return new AdminHomeProductPublisherPage();
	}

	public AdminHomeProductTypesPage clickonProductTypes() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_productTypes.click();
		return new AdminHomeProductTypesPage();
	}

	public AdminHomeProductCollectionPage clickonProductCollection() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_productCollection.click();
		return new AdminHomeProductCollectionPage();
	}

	public AdminHomeProductPage clickonProduct() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_product.click();
		return new AdminHomeProductPage();
	}

	public AdminHomeVIBStorePage clickonVIBStore() throws InterruptedException  {
		productTab.click();
		Thread.sleep(1000);
		p_vibStore.click();
		return new AdminHomeVIBStorePage();
	}

	//**************************ImageSliderTab******************************

	public AdminHomeImageSliderPage clickonImageSlider() {
		imageSliderTab.click();
		return new AdminHomeImageSliderPage();
	}

	//*************************LogoutTab************************************

	public AdminLoginPage clickonLogOut() {
		logoutTab.click();
		return new AdminLoginPage();
	}

}
