package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeTransactionTypePage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "")
	WebElement transTypeTitle;

	@FindBy(xpath = "")
	WebElement addtransTypeBtn;

	@FindBy(xpath = "")
	WebElement entertransTypeName;

	@FindBy(xpath = "")
	WebElement saveBtn;

	@FindBy(xpath = "")
	WebElement searchField;

	@FindBy(xpath = "")
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
