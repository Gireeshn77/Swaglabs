package com.Swag.Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Swag.Pageobjects.SwagLabsLoginPage;
import com.Swag.Utilities.JiraPolicy;
import com.Swag.Utilities.ReadDataFromXlsheet;


public class SwagaddtoCart extends Base{
	//@JiraPolicy(logTicketReady=true)
	Base bs;
	@Test(dataProvider="testdata",dataProviderClass=ReadDataFromXlsheet.class)
	public void verifyCart(String un,String ps) throws IOException
	{
		SwagLabsLoginPage sa=new SwagLabsLoginPage(driver);
		 bs=new Base();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("Enter the user name");
		sa.userName1(un);
		log.info("Enter the password");
		sa.password1(ps);
		log.info("Click on login button");
		sa.loginButton();
		if(isAlertPresent()==true)
		{
			SoftAssert so;
			driver.switchTo().alert().accept();
			String tname=driver.getTitle();
			if(tname.equals("Swag Labs"))
			{
				log.info("Test case pass");
				 so=new SoftAssert();
				so.assertTrue(true);
				
			}
			else
			{
				log.info("Test case fail");
				 so=new SoftAssert();
				so.assertTrue(false);
				takeScreenshot(" verifyCart");
				so.assertAll();
			}
			
		}else
		{
			SoftAssert so;
			String tname=driver.getTitle();
			if(tname.equals("Swag Labs"))
			{
				log.info("Test case pass");
				 so=new SoftAssert();
				so.assertTrue(true);
				
			}
			else
			{
				log.info("Test case fail");
				 so=new SoftAssert();
				so.assertTrue(false);
				bs.takeScreenshot(" verifyCart");
				so.assertAll();
			}
			
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
