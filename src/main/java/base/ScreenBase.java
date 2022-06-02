package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenBase {

	public static  AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public int TimeoutValue = 5;
	
	public ScreenBase(AppiumDriver<MobileElement> driver) {
		ScreenBase.driver = driver;
		}
	
	public Object WaitForElementByXpath(Object object) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((String) object)));
	
	}
	
    public Object WaitForElementById(Object object) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id((String) object)));
	
	}
	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}
	
	
}
