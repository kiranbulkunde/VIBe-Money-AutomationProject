package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeApprovalLevelPage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement approvalLevelsTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addApprovalLevelBtn;

	@FindBy(id = "msearch")
	WebElement searchField;

	@FindBy(xpath = "//input[@placeholder='Enter Approval name']")
	WebElement enterApprovalLevelName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnApprovalLevel;

	//Actions or Features or Methods:

	public AdminHomeApprovalLevelPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateApprovalLevelTitle() {
		return approvalLevelsTitle.isDisplayed();
	}

	public void addNewApprovalLevel(String approvalName) {
		addApprovalLevelBtn.click();
		enterApprovalLevelName.sendKeys(approvalName);
		saveBtnApprovalLevel.click();
	}

	public void validateApprovalLevelBySearch(String approvalName) {
		searchField.sendKeys(approvalName);;
	}



}
