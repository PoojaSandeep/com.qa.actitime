package com.acti.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest="C:\\Users\\sandeep\\git\\com.qa.actitime\\atreports\\screenshots\\screen.png";
		
		try 
		{
			FileHandler.copy(src, new File(dest));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return dest;
	}
	
	public static void sleep()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}