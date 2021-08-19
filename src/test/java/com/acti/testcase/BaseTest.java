package com.acti.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskListPage;
import com.acti.util.ExcelReader;
import com.acti.util.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript {
	
	LoginPage loginpage;
	EnterTimePage entertimepage;
	TaskListPage tasklistpage;
	public static ExtentTest logger;
	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	

	@BeforeSuite
	public void setUpReport()
	{
		//to make the screenshot dynamic with timestamp
		extent = new ExtentHtmlReporter("./atreports/index.html"+System.currentTimeMillis());
		extent = new ExtentHtmlReporter("./atreports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	@AfterSuite
	public void flushReport()
	{
		report.flush();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initApplicatio();
		loginpage = new LoginPage();
		entertimepage = new EnterTimePage();
		tasklistpage = new TaskListPage();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		quitApplication();
	}
	
	
	@DataProvider(name="actidata")
	public Object[][] testData()
	{
		ExcelReader excel = new ExcelReader("./attestdata/actidata.xlsx");
		int row = excel.getRowCount(0);
		Object[][] data = new Object[row][2];
		
		for(int i=0;i<row;i++)
		{
			data[i][0]=excel.getCellData(0, i, 0);
			data[i][1]=excel.getCellData(0, i, 1);
		}
		
		return data;
	}

}