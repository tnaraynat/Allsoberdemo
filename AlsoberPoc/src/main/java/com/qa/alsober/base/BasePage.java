package com.qa.alsober.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.alsober.utils.Optionsmanager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public Optionsmanager optionsmanager;
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<WebDriver>();
	
	/**
	 * this method is used to initialize the browser
	 * @param browsername
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop)
	
	{
		String browsername=prop.getProperty("browser");
		
		optionsmanager = new Optionsmanager(prop);
		System.out.println("AUT is performing in "+ browsername+ " Browser ");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver(optionsmanager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		}
		
		else
		{
			System.out.println("Sorry, browser name you passed' "+browsername +" 'is not found, please pass the correct browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
   
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	/**
	 * this method is used to return properties from config.prooerpties
	 * @return prop
	 */
	public Properties init_prop()
	{
		prop= new Properties();
		
			
		String currentPath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\alsober\\config\\config.properties";
		
		System.out.println("current properti file oath"+currentPath);
		try {
			FileInputStream ip=new FileInputStream(currentPath);
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("file not found at" +currentPath);
		}
		
		return prop;
		
	}
	
	//take screenshot
	public String getScreenshot()
	{
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			
		}
		return path;
	}
	
}
