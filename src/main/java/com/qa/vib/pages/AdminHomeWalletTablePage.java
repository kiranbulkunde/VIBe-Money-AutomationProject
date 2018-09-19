package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeWalletTablePage extends TestBase {
	
	
	
	
	//Page Factory or Object Repository for all webElements:

		@FindBy(xpath = "//h4[@class='ng-scope']")
		WebElement walletTableTitle;

		@FindBy(xpath = "//input[@id='search']")
		WebElement searchField;

		@FindBy(xpath = "//td[contains(text(),'walletID')]")
		WebElement walletIdSearch;
		
		@FindBy(xpath = "//td[contains(text(),'walletBal')]")
		WebElement walletBalSearch;
		
		@FindBy(xpath = "//td[contains(text(),'walletCustomerNam')]")
		WebElement walletCustomerNamSearch;
		
		@FindBy(xpath = "//td[contains(text(),'walletType')]")
		WebElement walletTypeSearch;
		
		@FindBy(xpath = "//td[contains(text(),'status')]")
		WebElement statusSearch;

		//Actions or Features or Methods:

		public AdminHomeWalletTablePage() {
			PageFactory.initElements(driver, this);
		}

		public boolean validateWalletTableTitle() {
			return walletTableTitle.isDisplayed();
		}

		public void validateWalletIdBySearch(String walletID) {
			searchField.sendKeys(walletID);;
		}
		
		public void validateWalletBalBySearch(String walletBal) {
			searchField.sendKeys(walletBal);;
		}
	
		public void validatewalletCustomerNamBySearch(String walletCustomerNam) {
			searchField.sendKeys(walletCustomerNam);;
		}
		
		public void validatewalletTypeBySearch(String walletType) {
			searchField.sendKeys(walletType);;
		}
		
		public void validateStatusBySearch(String status) {
			searchField.sendKeys(status);;
		}
		
		
}
