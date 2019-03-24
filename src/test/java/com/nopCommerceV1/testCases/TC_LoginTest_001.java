package com.nopCommerceV1.testCases;

import org.testng.annotations.Test;

import com.nopCommerceV1.pageObject.LoginPage;

import junit.framework.Assert;



public class TC_LoginTest_001 extends BaseClass {
	
	public String str=getClass().getName();
	
			
	
	@Test
	public void loginTest() throws Throwable 
	{
		driver.get(baseurl);
		loger.info("Url open");
		Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		loger.info("User Name Provided");
		lp.setPassword(password);
		loger.info("Password Provided");
		lp.login();
		loger.info("Login button clicked");
		Thread.sleep(5000);
		//Dashboard / nopCommerce administration
		String pageTitle = driver.getTitle();
		loger.info("Getting Title");
			//String st = driver.getTitle();
		//System.out.println("mmmmm:::"+st);
		//Thread.sleep(30000);
		if(pageTitle.equals("Dashboard / nopCommerce administration")) 
		{
			//screenShot(driver,getClass().getName());
			lp.logout();
			loger.info("Test Passed");
			Assert.assertTrue(true);
			
		}
		else 
		{
			
			screenShot(driver,str);
			loger.info("Test Failed");
			lp.logout();
			Assert.assertTrue(false);
								
		}
		
		
		
	}
	
	
}
