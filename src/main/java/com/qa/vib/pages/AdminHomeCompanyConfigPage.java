package com.qa.vib.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.vib.base.TestBase;

public class AdminHomeCompanyConfigPage extends TestBase {

	//Page Factory or Object Repository for all webElements:

	@FindBy(id = "search")
	WebElement search;

	@FindBy(xpath = "//td[contains(text(),'http://139.59.32.235/vibadmin/idproof/')]")
	WebElement searchResult;

	@FindBy(xpath = "//div[@class='card-title']")
	WebElement comConfigeTitle;

	//Actions or Features or Methods:

	public AdminHomeCompanyConfigPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateCompanyConfigTitle() {
		return comConfigeTitle.isDisplayed();

	}

	public void searchOption(String searchInput) {
		search.sendKeys(searchInput);
	}  


}


