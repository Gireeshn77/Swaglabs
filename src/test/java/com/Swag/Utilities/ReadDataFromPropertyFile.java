package com.Swag.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	Properties pro;
	public ReadDataFromPropertyFile() 
	{
		
		try
		{
			File fl=new File("./data.properties");
			FileInputStream fis = new FileInputStream(fl);
			pro=new Properties();
		 	pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("exception handled");
		}
		
	}
	
	public String getUsername()
	{
		String uName=pro.getProperty("username");
		return uName;
	}
	public String getPassword()
	{
		String passsword=pro.getProperty("password");
		return passsword;
	}

}
