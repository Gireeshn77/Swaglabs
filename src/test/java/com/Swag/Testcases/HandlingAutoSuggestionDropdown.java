package com.Swag.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Swag.Pageobjects.RedBus;

public class HandlingAutoSuggestionDropdown extends Base  {
	Base bs;
	SoftAssert sa;
	@Test()
	public void autoSuggestionDrop()
	{
		RedBus rb=new RedBus(driver);
		rb.searchbox("hyd");
		bs=new Base();
		//bs.waits(, 5);
		//rb.city();
		bs.waits(rb.cs(),50);
		rb.cs();
		log.info("scroll down and perform enter");
		bs.Keyboard();
		if(isAlertPresent()==true)
		{
			bs.alerts();
		WebElement ele=driver.findElement(By.xpath("//input[@id='src']"));
		String gt=ele.getText();
		System.out.println(gt);
		if(gt.equals("Kukatpally"))
		{
			sa=new SoftAssert();
			sa.assertTrue(true);
			log.info("Test case is pass");
			
		}
		else
		{
			sa.assertTrue(false);
			log.info("Test case is fail");
			
		}
		sa.assertAll();
		}
		else
		{
			WebElement ele=driver.findElement(By.xpath("//input[@id='src']"));
			String gt=ele.getText();
			System.out.println(gt);
			if(gt.equals("Kukatpally"))
			{
				sa=new SoftAssert();
				sa.assertTrue(true);
				log.info("Test case is pass");
				
			}
			else
			{
				sa.assertTrue(false);
				log.info("Test case is fail");
				
			}
			sa.assertAll();
			
		}
		
	}
	public  boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
