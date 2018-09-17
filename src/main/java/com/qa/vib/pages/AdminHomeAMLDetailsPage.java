package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.vib.base.TestBase;

public class AdminHomeAMLDetailsPage extends TestBase{

	//Page Factory or Object Repository for all webElements:

	@FindBy(xpath = "//h4[@class='ng-scope']")
	WebElement amlDetailsTitle;

	@FindBy(xpath = "//button[@class='vib_save']")
	WebElement addAMLDetailsBtn;

	@FindBy(xpath = "//input[@placeholder='Enter transaction per day']")
	WebElement enterTransacPerDay;

	@FindBy(xpath = "//input[@placeholder='Enter transaction per week']")
	WebElement enterTransacPerWeek;

	@FindBy(xpath = "//input[@placeholder='Enter transaction per month']")
	WebElement enterTransacPerMonth;

	@FindBy(xpath = "//input[@placeholder='Enter transaction per year']")
	WebElement enterTransacPerYear;

	@FindBy(xpath = "//div[@class='card-body']//div[3]//div[1]//div[1]//input[1]")
	WebElement enterMinLimitTransac;

	@FindBy(xpath = "//div[@class='card-body']//div[3]//div[2]//div[1]//input[1]")
	WebElement enterDailyLimitTransac;

	@FindBy(xpath = "//input[@placeholder='Enter weekly limit']")
	WebElement enterWeeklyLimitTransac;

	@FindBy(xpath = "//input[@placeholder='Enter monthly limit']")
	WebElement enterMonthlyLimitTransac;

	@FindBy(xpath = "//input[@placeholder='Enter yearly limit']")
	WebElement enterYearlylimitTransac;

	@FindBy(xpath = "//input[@placeholder='Enter aml type']")
	WebElement enterAMlType;

	@FindBy(id = "search")
	WebElement searchField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtnAMLDetail;

	//Actions or Features or Methods:

	public AdminHomeAMLDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateAMLDetailsTitle() {
		return amlDetailsTitle.isDisplayed();
	}

	public void addNewAMLDetails(String tranPerDay, String tranPerWeek,String tranPerMonth,String tranPerYear,String minLimitTran,String dailyLimitTran,String weeklyLimitTran,String monthlyLimitTran,String yerlyLimitTran,String amlType) {
		addAMLDetailsBtn.click();
		/*enterTransacPerDay.sendKeys(tranPerDay);
				enterTransacPerWeek.sendKeys(tranPerWeek);
				enterTransacPerMonth.sendKeys(tranPerMonth);
				enterTransacPerYear.sendKeys(tranPerYear);
				enterMinLimitTransac.sendKeys(minLimitTran);
				enterDailyLimitTransac.sendKeys(dailyLimitTran);
				enterWeeklyLimitTransac.sendKeys(weeklyLimitTran);
				enterMonthlyLimitTransac.sendKeys(monthlyLimitTran);
				enterYearlylimitTransac.sendKeys(yerlyLimitTran);
				enterAMlType.sendKeys(amlType);
				saveBtnAMLDetail.click();*/
	}

	public void validateAMLDetailsBySearch(String amlType) {
		searchField.sendKeys(amlType);;
	}



}
