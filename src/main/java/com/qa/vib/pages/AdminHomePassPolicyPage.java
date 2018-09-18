package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.vib.base.TestBase;

public class AdminHomePassPolicyPage extends TestBase {
	
	//Page Factory or Object Repository for all webElements:

			@FindBy(xpath = "//h4[@class='ng-scope']")
			WebElement passwordPolicyTitle;

			@FindBy(xpath = "//button[@class='vib_save']")
			WebElement clickAddPassPolicyBtn;
			
			@FindBy(xpath = "//input[@placeholder='Enter password policy name']")
			WebElement enterPassPolicyName;
			
			@FindBy(xpath = "//textarea[@placeholder='Enter policy details']")
			WebElement enterPolicyDetails;
			
			@FindBy(xpath = "//input[@placeholder='Enter notification priority']")
			WebElement enterNotificationPriority;
			
			@FindBy(xpath = "//input[@id='dt1']")
			WebElement pickValidityDate;
			
			@FindBy(xpath = "//input[@id='search']")
			WebElement searchField;
			
			@FindBy(xpath = "//td[contains(text(),'passPolicyName')]")
			WebElement searchBypassPolicyName;
			
			@FindBy(xpath = "//button[@type='submit']")
			WebElement saveBtnPassPolicy;

			//Actions or Features or Methods:

			public AdminHomePassPolicyPage() {
				PageFactory.initElements(driver, this);
			}

			public boolean validatePasswordPolicyTitle() {
				return passwordPolicyTitle.isDisplayed();
			}

			public void addPasswordPolicy(String passPolicyName, String policyDetails, String notificationPriority, String date) {

				clickAddPassPolicyBtn.click();
				enterPassPolicyName.sendKeys(passPolicyName);
				enterPolicyDetails.sendKeys(policyDetails);
				enterNotificationPriority.sendKeys(notificationPriority);
				
				pickValidityDate.sendKeys(date);
				
				saveBtnPassPolicy.click();
			}

			public void validatePassworPolicyByNameInSearch(String passPolicyName,String policyDetails, String notificationPriority, String date) {
				searchField.sendKeys(passPolicyName);
				
			}

	
	

}
