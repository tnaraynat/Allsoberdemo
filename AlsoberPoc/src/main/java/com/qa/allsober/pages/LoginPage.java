package com.qa.allsober.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.alsober.base.BasePage;
import com.qa.alsober.utils.Constants;
import com.qa.alsober.utils.ElementUtil;

public class LoginPage extends BasePage {

	
	private WebDriver driver;
	ElementUtil elementutil;
	
	By Signup        =By.xpath("//a[text()='Sign up']");
	By Loginbutton1  =By.xpath("//a[text()='Log in']");
	By username      =By.xpath("//input[@id='UserId']");
	By password      =By.xpath("//input[@id='password']");
	By Loginbutton2  =By.xpath("//button[@id='next']");
	
	
	//Constructor of the lognpage 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
		
	}
	
	//Login page actions
	
	public String  getLoginPageTitle()
	{
		return elementutil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isSignUpExists()
	{
		
		return elementutil.doIsDisplayed(Signup);
	}
	
	public HomePage doLogin(String uname,String pwd)
	{
			
		elementutil.waitForElementToBeVisible(Loginbutton1,30);		
		elementutil.doClick(Loginbutton1);
		elementutil.waitForElementToBeVisible(username, 10);
		elementutil.doSendKeys(username, uname);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(Loginbutton2);
		return new HomePage(driver);
	}	
	
	
}
