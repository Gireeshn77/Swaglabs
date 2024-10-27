package com.Swag.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Swag.Testcases.Base;

import java.time.Duration;
public class SwagLabsLoginPage {
	WebDriver driver;
	Base bs;
	public SwagLabsLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='user-name']")private WebElement usename;
	
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//input[@id='login-button']")private WebElement lbutton;
	
//	 public  void waits(WebElement element,long time)
//     {
//		WebDriverWait  wait =new WebDriverWait(driver,Duration.ofSeconds(time));
//		wait.until(ExpectedConditions.visibilityOf(element));
//	 }
//	
	public void userName1(String uname)
	{
		bs=new Base();
		bs.waits(usename, 10);
		usename.sendKeys(uname);
		
	}
	
	public void password1(String pword)
	{
		bs.waits(password, 10);
		password.sendKeys(pword);
		
	}
	public void loginButton()
	{
		bs.waits(lbutton, 10);
		lbutton.click();
		
	}
	
	
	
}
