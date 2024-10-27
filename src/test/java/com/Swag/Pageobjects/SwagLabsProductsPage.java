package com.Swag.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Swag.Testcases.Base;

public class SwagLabsProductsPage {
	
	WebDriver driver;
	Base bs;
	public SwagLabsProductsPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement usename;
	@FindBy(xpath="//button[@name='remove-sauce-labs-backpack']")private WebElement remove;
	
	public void usernames()
	{
		bs.waits(usename, 10);
		usename.click();
	}
	
	public void removeButton()
	{
		bs.waits(remove, 10);
		remove.click();
	}
	

}
