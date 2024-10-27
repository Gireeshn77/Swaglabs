package com.Swag.Testcases;

import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Swag.Utilities.ReadDataFromPropertyFile;
import com.google.common.io.Files;
import org.openqa.selenium.WebElement;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	// new comment line for git branch z
	
	
	ReadDataFromPropertyFile rd= new ReadDataFromPropertyFile();
    WebDriver driver;
    SimpleDateFormat sdf;
	Date date;
	String dateformat;
	String Repname;
	public Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public  void setup(String browser)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		options.setBinary("C:\\Users\\bobbi\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
//		DesiredCapabilities cp=new DesiredCapabilities();
//		cp.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(cp);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\bobbi\\Downloads\\chromedriver-win64(1)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver(options);
		
		}else
		{
			//System.setProperty("WebDriver.gecko.driver", co.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		
	
	 log=LogManager.getLogger("Base.class");
	 DOMConfigurator.configure("Log4j.xml");
	 log.info("Enter the url");
	 driver.get("https://www.saucedemo.com/v1/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

}
	

	
	 public void takeScreenshot(String tname) throws IOException
	   {
		   TakesScreenshot shot=(TakesScreenshot)driver;
		   File src=shot.getScreenshotAs(OutputType.FILE);
		   sdf=new SimpleDateFormat("dd-MM-YYYY,HH.mm.ss");
		   date=new Date();
		   dateformat=sdf.format(date);
		   Repname=tname+dateformat+".png";
		   File dst =new File(System.getProperty("user.dir")+"/Screenshots/"+Repname);
		   Files.copy(src, dst);
		
		  System.out.println("Screenshot taken");
	   }
	 
	 public void waits(WebElement element,long time)
	 {
		WebDriverWait  wait =new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
	 public void seDrop(WebElement ename,int num, String val)
	 {
		Select se =new Select(ename);
		se.selectByIndex(num);
		se.deselectByIndex(num);
		se.deselectAll();
	 }
	 public void seDrop1(WebElement ename,String val)
	 {
		 Select se =new Select(ename);
		 se.selectByValue(val);
		 se.deselectByValue(val);
		 se.deselectAll();
		 
	 }
	 public void seDrop2(WebElement ename,String txt)
	 {
		 Select se =new Select(ename);
		 se.deselectByVisibleText(txt);
		 se.deselectByVisibleText(txt);
		 se.deselectAll(); 
	 }
	 
	public void actions(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver); 
		ac.moveToElement(element).build();
		
	}
	public void actionsC(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.contextClick(element).build().perform();
		
	}
	public void actionsD(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.doubleClick(element).build().perform();
		
	}
	public void actionsDD(WebDriver driver,WebElement element,WebElement element1)
	{
		Actions ac=new Actions(driver);
		ac.dragAndDrop(element, element1).build().perform();
	}
	
	 public void alerts()
	 {
		 Alert al=driver.switchTo().alert();
		 al.accept();
		 //al.dismiss();
		 //al.getText();
	 }
	 public void Keyboard()
	 {
		 try
		 {
		Robot ro =new Robot();
		//ro.keyPress(KeyEvent.VK_UP);
		//ro.keyRelease(KeyEvent.VK_UP);
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
		ro.keyPress(KeyEvent.VK_ENTER);
		
		 }catch(Exception e)
		 {
			System.out.println("solution") ;
		 }
	 }
	 public void framesind(String indexn)
	 {
		 driver.switchTo().frame(indexn);
		 driver.switchTo().parentFrame();
		 driver.switchTo().defaultContent();
		 
	 }
	 public void framesname(String fname)
	 {
		 driver.switchTo().frame(fname);
		 driver.switchTo().parentFrame();
		 driver.switchTo().defaultContent();
		 
	 }
	 public void framesele(WebElement ele)
	 {
		 driver.switchTo().frame(ele);
		 driver.switchTo().parentFrame();
		 driver.switchTo().defaultContent();
		 
	 }
	 public void windows(String ele)
	 {
		 driver.switchTo().window(ele);
		 
	 }
	 public void scroll(int l1,int l2)
	 {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		Point p = new Point(l1,l2);
		 js.executeScript("window.scrollBy(p)","");
	 }
	 public void scrollPaticularE(WebElement ele)
	 {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		Point lo=ele.getLocation();
		 js.executeScript("window.scrollBy()"+lo,"");
	 }
	 public void disableEsv(String ename,String val)
	 {
		
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("ename.value=val;" );
		 
	 }
	 public void disableEc(WebElement ele)
	 {
		
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click;", ele );
		 
	 }
	 public void eleSetToEnable(String ele)
	 {
		
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 String e="document.getElementsByName(fname)[0].setAttribute(enabled,);";
		 js.executeScript(ele);
	 }
	 
	 @AfterClass
		public  void teardown()
		{
			driver.quit();
		}
}
