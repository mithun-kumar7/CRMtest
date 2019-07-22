package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement psword;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button'] ")
	WebElement loginbtn;
	
	//Initializing the Page Objects:
			public LoginPage(){
				PageFactory.initElements(driver, this);
			}
	//Actions		
			public String loginPageTitle() {
				return driver.getTitle();
			}
			
			public String emailAttribute() {
				return username.getAttribute("placeholder");
			}
			
			public String passwordAttribute() {
				return psword.getAttribute("placeholder");
			}
			
			public HomePage login(String un, String ps){
				username.sendKeys(un);
				psword.sendKeys(ps);
				
				driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		    	return new HomePage();
			}
	
}
