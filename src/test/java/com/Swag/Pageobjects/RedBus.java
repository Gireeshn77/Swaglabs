package com.Swag.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Swag.Testcases.Base;

public class RedBus {
	WebDriver driver;
	Base bs;
	public RedBus(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//input[@id='src']")private WebElement search;
	@FindBy(xpath="//li[@class='sc-iwsKbI jTMXri cursorPointing']")private WebElement loc;
	@FindBy(xpath="//ul[@class='sc-dnqmqq dZhbJF']")private WebElement cities;
	public void searchbox(String sname)
	{
		bs=new Base();
		bs.waits(search, 5);
		search.sendKeys(sname);
	}
	public void city()
	{
		bs.waits(loc, 30);
		loc.click();
	}
	public WebElement cs()
	{
		return cities;
	}
	

}
