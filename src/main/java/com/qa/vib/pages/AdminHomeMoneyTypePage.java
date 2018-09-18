package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeMoneyTypePage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	String moneyTypeName;
	
	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement moneyTypeTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addMoneyTypeBtn;

	@FindBy(xpath = "//input[@placeholder='Enter addmoney type name']")
	WebElement enterMoneyTypeName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "//td[contains(text(),'moneyTypeName')]")
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
