package com.qa.allsober.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.alsober.base.BasePage;
import com.qa.alsober.utils.ElementUtil;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementutil;
	
	By logout=By.xpath("//a[@id='dnn_userLogin_logoffLink']");
	By accountname=By.xpath("//a[@id='dnn_dnnUser_userNameLink']");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}
	
	
	public String getHomePageLogouttext()
	{
		if(elementutil.doIsDisplayed(logout))
			return elementutil.doGetText(logout);
		return null;
	}
	
	public  String getAccountnametext()
	{
		
		if(elementutil.doIsDisplayed(accountname))
		    return elementutil.doGetText(accountname);
		 return null;
		
	}
}
