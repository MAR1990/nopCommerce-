package com.nopCommerceV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage (WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH ,using ="//input[@name='Email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement btnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	WebElement lnklogout;
	
	public void setUserName(String uname)
	{
		txtemail.sendKeys(uname);
	}
	public void setPassword(String pwd) 
	{
		txtpwd.sendKeys(pwd);
	}
	public void login() 
	{
		btnlogin.submit();
	}
	public void logout()
	{
		lnklogout.click();
	}

}
