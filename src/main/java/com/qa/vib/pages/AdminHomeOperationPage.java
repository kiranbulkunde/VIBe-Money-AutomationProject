package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.vib.base.TestBase;

public class AdminHomeOperationPage extends TestBase{

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement operationTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addOperationBtn;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']")
	WebElement selectServiceName;

	@FindBy(xpath = "//input[@placeholder='Enter Operation name']")
	WebElement operationNameField;

	@FindBy(xpath = "//input[@placeholder='Enter shortcode based on service']")
	WebElement shortCodeField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnOperation;

	//Actions or Features or Methods:

	public AdminHomeOperationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateOperationTitle() {
		return operationTitle.isDisplayed();
	}

	public void addNewOperation(String servicesName, String operationName, String shortCode) {
		addOperationBtn.click();

		Select select = new Select(selectServiceName);
		select.selectByVisibleText(servicesName);

		operationNameField.sendKeys(operationName);
		shortCodeField.sendKeys(shortCode);
		saveBtnOperation.click();
	}

	public void validateOperationNameBySearch(String operationName) {
		searchField.sendKeys(operationName);;
	}



}
