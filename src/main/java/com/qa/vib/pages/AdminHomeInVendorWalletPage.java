package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.vib.base.TestBase;

public class AdminHomeInVendorWalletPage extends TestBase{
	
	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement InVendorWalletTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addInVendorWalletBtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter vendor name']")
	WebElement enterVendorName;
	
	@FindBy(xpath = "//input[@placeholder='Enter vendor user name']")
	WebElement enterVendorUserName;
	
	@FindBy(xpath = "//input[@placeholder='Enter password']")
	WebElement enterVendorPassword;
	
	@FindBy(xpath = "//input[@placeholder='Enter url']")
	WebElement enterUrl;
	
	@FindBy(xpath = "//input[@placeholder='Enter token']")
	WebElement enterToken;
	
	@FindBy(xpath = "//input[@placeholder='Enter token']")
	WebElement enterVendorAccountNum;
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchField;

	@FindBy(xpath = "//th[contains(text(),'VendorName')]")
	WebElement srchByVendorName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnInVendorWallet;

	//Actions or Features or Methods:

	public AdminHomeInVendorWalletPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateInVendorWalletTitle() {
		return InVendorWalletTitle.isDisplayed();
	}

	public void addNewInVendorWallet (String VendorName, String VendorUserNam,String VendorPassword,String URL, String token,String AccNum) {
		addInVendorWalletBtn.click();
		enterVendorName.sendKeys(VendorName);
		enterVendorUserName.sendKeys(VendorUserNam);
		enterVendorPassword.sendKeys(VendorPassword);
		enterUrl.sendKeys(URL);
		enterToken.sendKeys(token);
		enterVendorAccountNum.sendKeys(AccNum);
		
		saveBtnInVendorWallet.click();
	}

	public void validateVendorNameBySearch(String VendorName, String VendorUserNam,String VendorPassword,String URL, String token,String AccNum) {
		searchField.sendKeys(VendorName);;
	}


}
