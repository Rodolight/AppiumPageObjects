package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ShareScreen extends ScreenBase {
	
	@FindBy(xpath="//android.widget.TextView[contains(@text,'Continuar')]")
	public WebElement btnContinue;
	
	
	   @FindBys({
		  @FindBy(id="flipboard.app:id/account_login_buttons_skip"),
	      @FindBy(xpath="//android.widget.TextView[contains(@text, 'Omitir por ahora')]"),
		})
	public WebElement btnSkip;
	
	public ShareScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	public ShareScreen clickContinueButton() {
	
        WaitForElementByXpath("//android.widget.TextView[contains(@text,'Continuar')]");
        
		btnContinue.click();
		return this;
	
	}
	
	
	public HomeScreen skipLogin() {
		
   	    WaitForElementByXpath("//android.widget.TextView[contains(@text,'Omitir por ahora')]"); 
   	    
		btnSkip.click();
		
		return new HomeScreen(driver);
	}

}
