package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeOldOTPPage extends TestBase {


	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement oldOTPTitle;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "")
	WebElement searchByOldOTP;


	//Actions or Features or Methods:

	public AdminHomeOldOTPPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateOldOTPTitle() {
		return oldOTPTitle.isDisplayed();
	}

	public void validateOldOTPBySearch(String oldOTP) {
		searchField.sendKeys(oldOTP);;
	}


}
