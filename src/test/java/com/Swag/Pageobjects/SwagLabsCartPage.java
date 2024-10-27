package com.Swag.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Swag.Testcases.Base;

public class SwagLabsCartPage {
	WebDriver driver;
	Base bs;
	public  SwagLabsCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement addtoCart;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement cartIcon;
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small cart_button']")private WebElement removeButton;
	@FindBy(xpath="//button[@name='continue-shopping']")private WebElement continueButton;
	@FindBy(xpath="//button[@name='checkout']")private WebElement checkoutButton;

	public void addCart()
	{
		bs.waits(addtoCart, 10);
		addtoCart.click();
	}
	public void clickOnCartIcon()
	{
		bs.waits(cartIcon, 10);
		cartIcon.click();
	}
	public void remButton()
	{
		bs.waits(removeButton, 10);
		removeButton.click();
	}
	public void contButton()
	{
		bs.waits(continueButton, 10);
		continueButton.click();
	}
	public void checkButton()
	{
		bs.waits(checkoutButton, 10);
		checkoutButton.click();
	}
}
