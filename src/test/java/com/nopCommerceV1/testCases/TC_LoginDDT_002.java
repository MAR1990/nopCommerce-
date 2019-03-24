package com.nopCommerceV1.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceV1.pageObject.LoginPage;
import com.nopCommerceV1.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass 
{
	public String str1=getClass().getName();
	XLUtils xl;
	public int i;
	public int j;
	public String xlpath= System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopCommerceV1\\testData\\LoginData.xlsx";
	public int rownum;
	public int colnum;
	@Test(dataProvider="LoginData")
	public void loginTest(String uname , String pwd , String h ) throws IOException, Throwable 
	{
		driver.get(baseurl);
		loger.info("Url open");
		Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		loger.info("User Name Provided");
		lp.setPassword(pwd);
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
		
		
		
		
		//FileOutputStream f2 = new FileOutputStream(xlpath1);
		int x = Integer.valueOf(h);

		if(pageTitle.equals("Dashboard / nopCommerce administration")) 
		{
			//screenShot(driver,getClass().getName());
			lp.logout();
			loger.info("Test Passed");
			
			XLUtils.setCellData(xlpath, "Sheet1", x, (colnum) , "Pass");			
			Assert.assertTrue(true);
			
		}
		else 
		{
			
			screenShot(driver,str1);
			loger.info("Test Failed");
			XLUtils.setCellData(xlpath, "Sheet1", x, (colnum) , "fail");
			lp.logout();
			Assert.assertTrue(false);
								
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//String xlpath= System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopCommerceV1\\testData\\LoginData.xlsx";
		rownum = XLUtils.getRowCount(xlpath, "Sheet1");
		colnum = XLUtils.getCellCount(xlpath, "Sheet1", 1);
		String [][] logindata = new String[rownum][colnum+1];
		System.out.println(rownum);
		System.out.println(colnum);
		for ( i =1 ; i <= rownum;i++ )
		{
			System.out.println(i);
			for ( j =0 ; j < colnum;j++ )
			{
				logindata [i-1][j]= XLUtils.getCellData(xlpath, "Sheet1", i, j);
				logindata[i-1][j+1]= Integer.toString(i);
			}
			
		}
		return logindata;
	
	
	
	
	
	
	}
	
	
	
	

}
