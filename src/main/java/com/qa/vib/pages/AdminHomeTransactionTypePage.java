package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeTransactionTypePage extends TestBase {

	//Page Factory or Object Repository for all webElements:
	String transTypeName;
	
	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement transTypeTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addtransTypeBtn;

	@FindBy(xpath = "//input[@placeholder='Enter transaction type name']")
	WebElement entertransTypeName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "//td[contains(text(),'transTypeName')]")
	WebElement validSearchResult;

	@FindBy(xpath = "")
	WebElement deletetransTypeBtn;

	//Actions or Features or Methods:

	public AdminHomeTransactionTypePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateTransTypeTitle() {
		return transTypeTitle.isDisplayed();
	}

	public void addNewTransType(String transTypeName) {
		transTypeTitle.click();
		entertransTypeName.sendKeys(transTypeName);
		saveBtn.click();
	}

	public void validateTransTypeNameBySearch(String transTypeName) {
		searchField.sendKeys(transTypeName);;
	}

}
