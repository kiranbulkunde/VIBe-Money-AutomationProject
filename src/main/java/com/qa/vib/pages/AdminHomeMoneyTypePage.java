package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeMoneyTypePage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "")
	WebElement moneyTypeTitle;

	@FindBy(xpath = "")
	WebElement addMoneyTypeBtn;

	@FindBy(xpath = "")
	WebElement enterMoneyTypeName;

	@FindBy(xpath = "")
	WebElement saveBtn;

	@FindBy(xpath = "")
	WebElement searchField;

	@FindBy(xpath = "")
	WebElement validSearchResult;

	@FindBy(xpath = "")
	WebElement deleteMoneyTypeBtn;

	//Actions or Features or Methods:

	public AdminHomeMoneyTypePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMoneyTypeTitle() {
		return moneyTypeTitle.isDisplayed();
	}

	public void addNewMoneyType(String moneyTypeName) {
		moneyTypeTitle.click();
		enterMoneyTypeName.sendKeys(moneyTypeName);
		saveBtn.click();
	}

	public void validateMoneyTypeNameBySearch(String moneyTypeName) {
		searchField.sendKeys(moneyTypeName);;
	}


}
