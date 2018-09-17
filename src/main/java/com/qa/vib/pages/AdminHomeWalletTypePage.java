package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeWalletTypePage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement walletTypeTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addWalletTypeBtn;

	@FindBy(id = "msearch")
	WebElement searchField;

	@FindBy(xpath = "//input[@placeholder='Enter wallet type name']")
	WebElement enterwalletTypeName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnwalletType;

	//Actions or Features or Methods:

	public AdminHomeWalletTypePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateWalletTypeTitle() {
		return walletTypeTitle.isDisplayed();
	}

	public void addNewWalletType(String walletTypeName) {
		addWalletTypeBtn.click();
		enterwalletTypeName.sendKeys(walletTypeName);
		saveBtnwalletType.click();
	}

	public void validateWalletTypeNameBySearch(String walletTypeName) {
		searchField.sendKeys(walletTypeName);;
	}


}
