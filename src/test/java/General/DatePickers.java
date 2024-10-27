package General;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickers {
	public static void main(String args[])
	{
		String eyear="2025";
		String emonth="June";
		String eday="08";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.setBinary("C:\\Users\\bobbi\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\bobbi\\Downloads\\chromedriver-win64(1)\\chromedriver-win64\\chromedriver.exe");
		 WebDriver driver=new FirefoxDriver();
		 driver.get("https://jqueryui.com/datepicker/");
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		 //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/30/2023");
	    // String actualm=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		 //String actualy=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		 while(true)
		 {		 String actualm=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                 String actualy=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
			 if(eyear.equals(actualy)&& emonth.equals(actualm))
			 {
				 break;
			 }
			 driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		 }
		// driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		 List<WebElement> teles=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		 for(WebElement tele:teles)
		 {
			 String aday=tele.getText();
			 if(eday.equals(aday))
			 {
				 tele.click();
				 break;
			 }
			 
		 }
		 driver.quit();
	}

}
