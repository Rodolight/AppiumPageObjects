package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreen extends ScreenBase{
	
	@FindBy(id="flipboard.app:id/first_launch_get_started_button")
	public WebElement continueButton;
	

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	
		PageFactory.initElements(driver, this);
	}
	
	
	public ChooseTopicScreen clickGetStartedBtn() {
		continueButton.click();
		
		return new ChooseTopicScreen(driver);
	}

}
