package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker1 {
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.setBinary("C:\\Users\\bobbi\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\bobbi\\Downloads\\chromedriver-win64(1)\\chromedriver-win64\\chromedriver.exe");
		 WebDriver driver=new FirefoxDriver();
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
	}

}
