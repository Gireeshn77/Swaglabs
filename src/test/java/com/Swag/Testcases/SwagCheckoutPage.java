package com.Swag.Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Swag.Pageobjects.SwagLabsCartPage;
import com.Swag.Pageobjects.SwagLabsLoginPage;
import com.Swag.Utilities.ReadDataFromXlsheet;


public class SwagCheckoutPage extends Base{
	@Test(dataProvider="testdata",dataProviderClass=ReadDataFromXlsheet.class)
	public void checkOutPage(String unm,String pas) throws IOException
	{
	SwagLabsLoginPage sa=new SwagLabsLoginPage(driver);
	Base bs=new Base();
	
	log.info("Enter the user name");
	sa.userName1(unm);
	log.info("Enter the password");
	sa.password1(pas);
	log.info("Click on login button");
	sa.loginButton();
	
	SwagLabsCartPage sc=new SwagLabsCartPage(driver);
	log.info("Click on add to cart");
	sc.addCart();
	log.info("Click on cart icon");
	sc.clickOnCartIcon();
	log.info("Click on continue button");
	sc.contButton();
	String pageName=driver.getTitle();
	if(pageName.equals("Swag Labs"))
	{
		log.info("Test case pass");
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(true);	
	}else
	{
		log.info("Test case fail");
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(false);
		bs.takeScreenshot("checkOutPage");
		sf.assertAll();
		
	}
	
	} 
	


//public  boolean isAlertPresent1()
//{
//	try
//	{
//		driver.switchTo().alert();
//		return true;
//	}
//	catch(Exception e)
//	{
//		return false;
//	}
//	
//}


	

}
