package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.vib.base.TestBase;

public class AdminHomeMailManagementPage extends TestBase{
	
	//Page Factory or Object Repository for all webElements:

		@FindBy(xpath = "//form[@name='fordata']//h4[contains(text(),'Mail Management')]")
		WebElement mailManagementTitle;

		@FindBy(xpath = "//select[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']")
		WebElement selectServiceTypeName;
		
		@FindBy(xpath = "//input[@ng-model='fordata.mobilenumber' and @name='phone']")
		WebElement mobileNumberField;
		
		@FindBy(xpath = "//button[contains(text(),'Search')]")
		WebElement searchBtn;
		
		@FindBy(xpath = "//input[@id='search']")
		WebElement searchField;
		
		@FindBy(xpath = "//td[contains(text(),'mobNum')]")
		WebElement searchByMobNum;

		@FindBy(xpath = "//button[contains(text(),'Add Mail Management')]")
		WebElement addMailManagement;
		
		@FindBy(xpath = "//form[@name='addtomailmanagement']//input[@placeholder='Enter frequency']")
		WebElement frequencyField;
		
		@FindBy(xpath = "//input[@placeholder='Upload file']")
		WebElement attachmentURL;

		@FindBy(xpath = "//button[contains(text(),'Save')]")
		WebElement saveBtnAddMailMgt;

		//Actions or Features or Methods:

		public AdminHomeMailManagementPage() {
			PageFactory.initElements(driver, this);
		}

		public boolean validateMailManagementTitle() {
			return mailManagementTitle.isDisplayed();
		}

		public void addNewMailManagement(String serviceType, String mobNum, String freqField, String urlPath) {
			
			Select select = new Select(selectServiceTypeName);
			select.selectByVisibleText(serviceType);
			mobileNumberField.sendKeys(mobNum);
			searchBtn.click();
			addMailManagement.click();
			frequencyField.sendKeys(freqField);
			attachmentURL.sendKeys(urlPath);
			saveBtnAddMailMgt.click();
			
		}

		public void validateNewMailManagementByMobNumBySearch(String serviceType, String mobNum, String freqField, String urlPath) {
			searchByMobNum.sendKeys(mobNum);
		}	
	

}
