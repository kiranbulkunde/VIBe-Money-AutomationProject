package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.vib.base.TestBase;

public class AdminHomeVendorDetailsPage extends TestBase{
	
	//Page Factory or Object Repository for all webElements:

		@FindBy(xpath = "//h4[@class='ng-scope']")
		WebElement vendorDetailsTitle;

		@FindBy(xpath = "//button[@class='vib_save']")
		WebElement addVendorDetailsBtn;
		
		@FindBy(xpath = "//input[@placeholder='Enter name']")
		WebElement enterName;
		
		@FindBy(xpath = "//textarea[@placeholder='Address']")
		WebElement enterAddress;
		
		@FindBy(xpath = "//input[@placeholder='Enter user ID']")
		WebElement enterUserID;
		
		@FindBy(xpath = "//input[@placeholder='Password']")
		WebElement enterPassword;
		
		@FindBy(xpath = "//input[@placeholder='Enter unique key']")
		WebElement enterUniqueKey;
		
		@FindBy(xpath = "//input[@placeholder='IP Address']")
		WebElement enterIpAddress;
		
		@FindBy(xpath = "//input[@id='search']")
		WebElement searchField;
		
		@FindBy(xpath = "//select[@class='form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']")
		WebElement selectAML;

		@FindBy(xpath = "//td[contains(text(),'vendorName')]")
		WebElement srchVendorName;

		@FindBy(xpath = "//button[@type='submit']")
		WebElement saveBtnVendorDetails;

		//Actions or Features or Methods:

		public AdminHomeVendorDetailsPage() {
			PageFactory.initElements(driver, this);
		}

		public boolean validateVendorDetailsTitle() {
			return vendorDetailsTitle.isDisplayed();
		}

		public void addNewVendorDetails (String Name, String address,String userID,String password, String uniqueKey, String ipAddress, String AML) {
			addVendorDetailsBtn.click();
			enterName.sendKeys(Name);
			enterAddress.sendKeys(address);
			enterUserID.sendKeys(userID);
			enterPassword.sendKeys(password);
			enterUniqueKey.sendKeys(uniqueKey);
			enterIpAddress.sendKeys(ipAddress);
			
			Select select = new Select(selectAML);
			select.selectByVisibleText(AML);
			saveBtnVendorDetails.click();
		}

		public void validateVendorNameBySearch(String Name, String address,String userID,String password, String uniqueKey, String ipAddress, String AML) {
			searchField.sendKeys(Name);;
		}

	
	
	
	
	
	

}
