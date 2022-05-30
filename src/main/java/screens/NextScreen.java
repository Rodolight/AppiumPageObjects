package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NextScreen extends ScreenBase {
	
	@FindBy(xpath="//android.widget.TextView[contains(@text,'Continuar')]")
	public WebElement btnContinue;
	
	
	@FindBy(id="flipboard.app:id/icon_button_text")
	public WebElement btnShareContinue;
	

	public NextScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	public NextScreen clickContinueButton() {

		WaitForElementByXpath("//android.widget.TextView[contains(@text,'Continuar')]");
		
		btnContinue.click();
		return this;
	}

}
