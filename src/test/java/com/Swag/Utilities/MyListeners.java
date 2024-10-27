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
    		spark.config().setDocumentTitle("FitPeo Tech");
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
		
		if (result.getStatus() == ITestResult.FAILURE) {
			JiraUtilityCode.createJiraIssue("Test Failed: " + result.getName(), result.getThrowable().toString());
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
