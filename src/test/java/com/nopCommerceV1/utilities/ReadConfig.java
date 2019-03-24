package com.nopCommerceV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig()
	{
	
	File src = new File("./Configrations/config.properties");
	
	try 
	{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}
	catch (Exception e) {
		
		System.out.println("Error Message"+e.getMessage());
		
	}
	
	 	
	}
	public String getUrl()
	{
		String url = pro.getProperty("baseurl1");
		return url;
	}
	public String getUserName()
	{
		String userid = pro.getProperty("username");
		return userid;
	}
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	public String getChroPath()
	{
		String chropath = pro.getProperty("chromepath");
		return chropath;
	}
	public String getIEPath()
	{
		String ie = pro.getProperty("iepath");
		return ie;
	}
	public String getFirefoxPath()
	{
		String fxpath = pro.getProperty("firepath");
		return fxpath;
	}

}
