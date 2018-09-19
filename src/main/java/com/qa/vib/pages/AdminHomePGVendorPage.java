package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.vib.base.TestBase;

public class AdminHomePGVendorPage extends TestBase {
	
	//Page Factory or Object Repository for all webElements:

			@FindBy(xpath = "//h4[@class='ng-scope']")
			WebElement PGvendorTitle;

			@FindBy(xpath = "//button[@class='vib_save']")
			WebElement addPGVendorBtn;
			
			@FindBy(xpath = "//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']")
			WebElement selectVendorDetails;
			
			@FindBy(xpath = "//input[@placeholder='Enter vendor user name']")
			WebElement enterVendorUserName;
			
			@FindBy(xpath = "//input[@placeholder='Enter vendor password']")
			WebElement enterVendorPassword;
			
			@FindBy(xpath = "//input[@placeholder='Enter vendor url']")
			WebElement enterVendorUrl;
			
			@FindBy(xpath = "//input[@placeholder='Enter payment gateway url']")
			WebElement enterPaymentGateUrl;
			
			@FindBy(xpath = "//input[@id='search']")
			WebElement searchField;

			@FindBy(xpath = "//td[contains(text(),'vendorDetails')]")
			WebElement srchByVendorDetails;

			@FindBy(xpath = "//button[@type='submit']")
			WebElement saveBtnPGVendor;

			//Actions or Features or Methods:

			public AdminHomePGVendorPage() {
				PageFactory.initElements(driver, this);
			}

			public boolean validateVendorDetailsTitle() {
				return PGvendorTitle.isDisplayed();
			}

			public void addNewVendorDetails (String Vendor, String VendorUserNam,String VendorPassword,String VendorURL, String PaymentURL) {
				addPGVendorBtn.click();
				Select select = new Select(selectVendorDetails);
				select.selectByVisibleText(Vendor);
				enterVendorUserName.sendKeys(VendorUserNam);
				enterVendorPassword.sendKeys(VendorPassword);
				enterVendorUrl.sendKeys(VendorURL);
				enterPaymentGateUrl.sendKeys(PaymentURL);
				
				saveBtnPGVendor.click();
			}

			public void validateVendorNameBySearch(String Vendor, String VendorUserNam,String VendorPassword,String VendorURL, String PaymentURL) {
				searchField.sendKeys(Vendor);;
			}


}
