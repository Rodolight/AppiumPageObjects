package testCases;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.TestBase;
import screens.ChooseTopicScreen;
import screens.LoginScreen;
import screens.NextScreen;
import screens.ShareScreen;

public class FlipboardLoginTest extends TestBase {
	
	LoginScreen login;
	ChooseTopicScreen topicScreen;
	NextScreen nextScreen;
	ShareScreen shareScreen;
	
	@BeforeTest
	public void init() throws MalformedURLException
	{
		setUp();
		login = new LoginScreen(driver);
		topicScreen = new ChooseTopicScreen(driver);
		nextScreen = new NextScreen(driver);
		shareScreen = new ShareScreen(driver);
	}
	
	
	@Test(priority=1)
	public void validateGetStartetBtn() {
		login.clickGetStartedBtn();
		Assert.fail("Failing the test");
	}
	
	@Test(priority=2)
	public void chooseTopicsTest() {
		topicScreen.chooseTopics(3).clickContinue().clickNextButton();
		nextScreen.clickContinueButton();
	}
	

	@AfterTest
	public void quitDriver() {
		quit();
	}

}
