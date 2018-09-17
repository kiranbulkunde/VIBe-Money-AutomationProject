package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeServicesPage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement servicesTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addServicesBtn;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "//input[@placeholder='Enter service name']")
	WebElement enterServicesName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnServices;

	//Actions or Features or Methods:

	public AdminHomeServicesPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateServicesTitle() {
		return servicesTitle.isDisplayed();
	}

	public void addNewServices(String servicesName) {
		addServicesBtn.click();
		enterServicesName.sendKeys(servicesName);
		saveBtnServices.click();
	}

	public void validateServicesNameBySearch(String servicesName) {
		searchField.sendKeys(servicesName);;
	}


}
