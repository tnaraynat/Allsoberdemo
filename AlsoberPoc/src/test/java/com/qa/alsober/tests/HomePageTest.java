package com.qa.alsober.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.allsober.pages.HomePage;
import com.qa.alsober.base.BaseTest;
import com.qa.alsober.utils.Constants;

public class HomePageTest extends BaseTest{
	
	HomePage homepage;
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
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	*/
	@BeforeClass
	public void HomePageSetUp()
	{	
		
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
		
	@Test(priority=2)
	public void VerifyLOgoutTextTest()
	{
		
		String Logouttext=homepage.getHomePageLogouttext();
		Assert.assertEquals(Constants.HOME_PAGE_LOGOUT_TEXT, Logouttext);
	}
	
	@Test(priority=1)
	
	public void VerifyLoggedinUserAccountName()
	{
		String ReturnedAccountName=homepage.getAccountnametext();
		System.out.println("Returned account name" +ReturnedAccountName);
		System.out.println("Accountname from prop file"+prop.getProperty("accountname"));
		Assert.assertEquals(prop.getProperty("accountname"), ReturnedAccountName);
	}
	
	
	
	

}
