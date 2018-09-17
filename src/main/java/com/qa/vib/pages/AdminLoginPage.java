package com.qa.vib.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminLoginPage extends com.qa.vib.base.TestBase{

	//Page Factory or Object Repository for all webElements:

	@FindBy(id = "usr")
	@CacheLookup
	WebElement username;

	@FindBy(id = "loginpassword")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "html/body/div[1]/div[2]/div/div[2]/div/form/div[3]/button")
	@CacheLookup
	WebElement signTnBtn;

	@FindBy(xpath = "//img[contains(@src,'assets/img/vib.png')]")
	WebElement vibemLogo;

	public AdminLoginPage(){
		PageFactory.initElements(driver, this);//this means pointing to current class object
	}

	//Actions or Features or Methods:

	public String validateLoginTitle(){
		return driver.getTitle();
	}

	public boolean validateVibemLogo(){
		return vibemLogo.isDisplayed();
	}

	public AdminHomePage adminLogin(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signTnBtn.click();

		return new AdminHomePage();
	}


}
