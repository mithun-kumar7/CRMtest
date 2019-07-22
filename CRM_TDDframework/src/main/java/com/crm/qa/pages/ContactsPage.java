package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="(//input[@name='value'])[1]")
	WebElement email;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="department")
	WebElement dept;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactsLabel(){
		return contactsLabel.getText();
	}
	
	public void clickonNewLink() {
		newBtn.click();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding-sibling::td"
				+ "//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void createNewContact(String ftName, String ltName, String mail, String add, String departmnt){
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		email.sendKeys(mail);
		address.sendKeys(add);
		dept.sendKeys(departmnt);
	}

}
