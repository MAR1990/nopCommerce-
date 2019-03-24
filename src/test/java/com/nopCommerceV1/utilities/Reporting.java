package com.nopCommerceV1.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nopCommerceV1.testCases.TC_LoginTest_001;

public class Reporting extends TestListenerAdapter
{
	
	
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	ExtentTest logger;
	String timestamp;
	public String time;
	TC_LoginTest_001 TC;
	
	public void onStart(ITestContext context) 
	{
		timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "Test-Report"+timestamp+".html";
		
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportname);
		
	    htmlreport.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	    
	    extent = new ExtentReports();
	    extent.attachReporter(htmlreport);
	    extent.setSystemInfo("AuthorName", "Abhishek");
	    htmlreport.config().setDocumentTitle("nopCommerce Test Report");
	    htmlreport.config().setReportName("Test Report of Application");
	    htmlreport.config().setChartVisibilityOnOpen(true);
	    htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
	    htmlreport.config().setTheme(Theme.DARK);
	
	}
	public void onTestSuccess(ITestResult result)
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult result) 
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		time = new SimpleDateFormat("yyyy/MM/dd/HH/mm").format(new Date());
		String sspath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getInstanceName()+".png";
				
		try {
			logger.fail("Screenshot is bellow..."+ logger.addScreenCaptureFromPath(sspath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hmmmmmmmmmmmm");
	}
	
	
		public void onTestSkipped(ITestResult result)
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		}
		
		
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
		
		
	
		
	

}
