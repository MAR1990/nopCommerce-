package com.nopCommerceV1.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerceV1.utilities.ReadConfig;
import com.nopCommerceV1.utilities.Reporting;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseurl = readconfig.getUrl();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	WebDriver driver;
	public static Logger loger;
	public String timetamp1;
	Reporting rp;
	public String scrpath;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		loger = Logger.getLogger("nopCommerceV1");
		PropertyConfigurator.configure("Log4j.Properties");
		
		if (br.equals("Chrome")) {

		System.setProperty("webdriver.chrome.driver",readconfig.getChroPath());
		driver=new ChromeDriver();
		}
		else if (br.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			
		}
       else if (br.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loger = Logger.getLogger("nopCommerceV1");
		PropertyConfigurator.configure("Log4j.Properties");
			}
	
	@AfterClass
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.quit();
	}
	public void screenShot(WebDriver driver,String tname) throws IOException
	{
		timetamp1 = new SimpleDateFormat("yyyy-MM-dd-mm").format(new Date());
		TakesScreenshot sr = (TakesScreenshot) driver;
		File source = sr.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		scrpath =target.getPath();
		System.out.println(scrpath);
		System.out.println(tname);
		FileUtils.copyFile(source, target);
		
	}


}
