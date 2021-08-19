package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
 * Title: DriverScript
 * Description: 
 * Developed By: Pooja Prahlad
 * Data : 30/07/2021
 * Approved By: Shantosh Kumar
 * Approved Date: 30/07/2021
 */

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public DriverScript()
	{
		try
		{
			File src = new File("./atconfig/config.properties");
			FileInputStream fis= new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to read property file."+e.getMessage());
		}
		
	}
	
	@Test
	public void initApplicatio()
	{
			String browser = prop.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./atbrowser/chromedriver.exe");
				driver=new ChromeDriver();
						
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./atbrowser/geckodriver.exe");
				driver=new FirefoxDriver();
						
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", "./atbrowser/msedgedriver.exe");
				driver=new EdgeDriver();				
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			String url = prop.getProperty("url");
			driver.get(url);
			
			
	}
	
	@Test
	public void quitApplication()
	{
		//driver.close();
	}

}



