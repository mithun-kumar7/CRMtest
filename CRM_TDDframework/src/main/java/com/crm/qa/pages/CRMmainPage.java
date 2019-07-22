package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CRMmainPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
		WebElement loginOptn;
		
		@FindBy(xpath="//a[@title='free cm home']")
		WebElement crmLogo;
		
		@FindBy(xpath="//div[@class='telephone']")
		WebElement phoneNo;
		
		
		//Initializing the Page Objects:
		public CRMmainPage(){
			PageFactory.initElements(driver, this);
		}

		
		//Actions:
			public String validateCRM_MainPageTitle(){
				return driver.getTitle();
			}
			public boolean validateCRMImage(){
				return crmLogo.isDisplayed();
			}
			
			public String validatePhoneNo(){
				return phoneNo.getText();
			}
			
			public LoginPage clickOnLoginOption() {
				loginOptn.click();
				return new LoginPage();
			}


}
