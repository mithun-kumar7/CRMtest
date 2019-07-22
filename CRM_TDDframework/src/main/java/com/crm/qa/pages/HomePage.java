package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//span[@class='user-display']")
	WebElement clientName;
	
	@FindBy(xpath="//span[@class='trial-indicator']")
	WebElement daysLeft;
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Contacts')]")
	WebElement contactsBtn;
	
	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public String verifyUserLabel(){
			return clientName.getText();
		}
		
		public String verifyDaysLeft() {
			return daysLeft.getText();
		}
		
		public ContactsPage contactsLink() {
			contactsBtn.click();
			return new ContactsPage();
		}
		

}
