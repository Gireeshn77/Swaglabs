package com.Swag.Utilities;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyListeners implements ITestListener{
     public static  ExtentReports reports;
      public static ExtentTest test;
      
      public void onStart(ITestContext testContext)
      {
    	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    		Date date=new Date();
    		String timeStamp=sdf.format(date);
    		String repName="report"+timeStamp+".html" ;
    		ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repName);
    		 reports = new ExtentReports();
    		reports.attachReporter(spark);
    		spark.config().setDocumentTitle("Telecare");
    		spark.config().setReportName("Test Automation Report");
    		spark.config().setTheme(Theme.DARK);
    		spark.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");
    		reports.setSystemInfo("Host name", "Localhost");
    		reports.setSystemInfo("Environment", "QA");
    		reports.setSystemInfo("user", "Hari");
      }


    
	public void onTestSuccess(ITestResult result) {
		String tname=result.getName();
		test=reports.createTest(tname);
		test.log(Status.INFO, "actual out put is matched with excepted out put");
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tname+"-Test Case Pass",ExtentColor.GREEN));
	}

    
	public void onTestFailure(ITestResult result) {
		String tname=result.getName();
		test=reports.createTest(tname);
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tname+"-Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed", ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		File fe=new File(screenshotpath);
		if(fe.exists())
		{
			test.fail("screentshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
		}
		
		JiraPolicy jirapolicy =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady= jirapolicy.logTicketReady();
		if(isTicketReady)
		{
			System.out.println("is ticket is ready for jira: "+isTicketReady);
			JiraServiceProvide jService=new JiraServiceProvide("https://prasad34.atlassian.net","bobbilihariprasad222@gmail.com","ATATT3xFfGF0j1Y1lDlYe9jsuEOtm0cdJUMcPUhvmpN0VCwqbcxt3KZuEO3qxXz3nZdVPDKg2nuQRDk3GHqEHUpld_HoqttQqRwUs22u7BiNHuAdM0CYQWa_3XQ3vTYibyFb0J7HuXMCqmrE2Ov3ZiNiLbAt-kD6N5lscbLhRFyjNFRziZ4Di_I=120752F5","TEL");
			String summary=result.getMethod().getConstructorOrMethod().getMethod().getName()+"issue got faile due to expection";
			String description=result.getThrowable().getMessage()+"\n";
			description.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			jService.createJiraTicket("Bug", summary, description,"hariprasad");
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		String tname=result.getName();
		test=reports.createTest(tname);
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tname+"-Test Case Skipped", ExtentColor.ORANGE));
		
	}


	
	public void onFinish(ITestContext testContext) {
		reports.flush();
		
	}
	

}
