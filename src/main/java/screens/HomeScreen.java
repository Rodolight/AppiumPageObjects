package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreen extends ScreenBase {
	
	@FindBys({
		@FindBy(id="flipboard.app:id/sliding_title_strip_container"),
		@FindBy(id="flipboard.app:id/sliding_title_text_view")
	})
	
	public List <WebElement> title;
	
	@FindBy(id="flipboard.app:id/bottom_nav_view_icon")
	public List<WebElement> bottonNavigation;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	    PageFactory.initElements(driver, this);
	
	}
	
	public void gotoTitleSection(int sectionCount) {
	 
		 WaitForElementById("flipboard.app:id/sliding_title_text_view");
	     title.get(sectionCount-1).click();	
	}
	
	
	public void selectBottomPanel(int screenNo) {
		bottonNavigation.get(screenNo-1).click();
	}

}
