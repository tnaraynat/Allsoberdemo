package com.qa.alsober.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.allsober.pages.LoginPage;
import com.qa.alsober.base.BasePage;
import com.qa.alsober.base.BaseTest;
import com.qa.alsober.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	/*public BasePage basepage;
	public WebDriver driver;
	public LoginPage loginpage;
	public Properties prop;
	
	@BeforeTest 
	public void setUp()
	{
		
		basepage=new BasePage();
		prop=basepage.init_prop();
		driver=basepage.init_driver(prop);	
		loginpage=new LoginPage(driver);
				
	}
	*/
	
	@Test(priority=1)
	public void verifySignupLinkTest()
	{
		
	Assert.assertEquals(loginpage.isSignUpExists(), true);
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest()
	{
		System.out.println("Returned Loginpage title is--"+loginpage.getLoginPageTitle());
		Assert.assertEquals(loginpage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=3)
	public void logintest()
	{
		String uname=prop.getProperty("username");
		String wd=prop.getProperty("password");
		System.out.println("name s "+uname);
		System.out.println("name s "+wd);
		
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	

}
