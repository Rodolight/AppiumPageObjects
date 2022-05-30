package testCases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.HomeScreen;
import screens.LoginScreen;
import utilies.ScrollUtil;

public class TitleSectionTest extends TestBase {
	
	LoginScreen login;
	HomeScreen home;
	
	@BeforeTest
	public void init() throws MalformedURLException
	{
		setUp();
		login = new LoginScreen(driver);
	    home = new HomeScreen(driver);
	}
	
	
	@Test()
	public void validateTitle() {
		login.clickGetStartedBtn().chooseTopics(3).clickContinue().clickNextButton().clickContinueButton().skipLogin();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScrollUtil.swipeUp(2, driver);
		
		home.gotoTitleSection(2);
	}
	
	
	@AfterTest
	public void quitDriver() {
		quit();
	}

}
