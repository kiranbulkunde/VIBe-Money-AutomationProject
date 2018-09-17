package com.qa.vib.pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeCountryPage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement countryTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addCountryBtn;

	@FindBy(xpath = "//input[@placeholder='Enter country name']")
	WebElement enterCountryName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[@type='reset']")
	WebElement clearBtn;

	@FindBy(xpath = "//button[@class='vib_cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//input[@id='msearch']")
	WebElement searchField;

	@FindBy(xpath = "//a[@data-ng-click='ondelete(country)']")
	WebElement validSearchResult;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement deleteCountryBtn;

	//Actions or Features or Methods:

	public AdminHomeCountryPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateCountryTitle() {
		return countryTitle.isDisplayed();
	}

	public void addNewCountry(String countryName) {
		addCountryBtn.click();
		enterCountryName.sendKeys(countryName);
		saveBtn.click();
	}

	public void validateCountryNameBySearch(String countryName) {
		searchField.sendKeys(countryName);;
	}

	public void deleteCountry(String countryName ) throws InterruptedException {

		searchField.sendKeys(countryName);;
		Point point =validSearchResult.getLocation();
		int x=point.getX();
		int y=point.getY();

		System.out.println(point);
		System.out.println(x);
		System.out.println(y);
		//deleteCountryBtn.click();

		Actions action = new Actions(driver);
		action.moveToElement(validSearchResult, x, y).click().build().perform();
		Thread.sleep(3000);
	}



}
