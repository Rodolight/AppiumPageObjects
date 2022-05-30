package screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.ScreenBase;
import extentlisteners.ExtentListeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ChooseTopicScreen  extends ScreenBase{
	
	@FindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<WebElement> topic;

	
	@FindBy(id="flipboard.app:id/topic_picker_continue_button")
	public WebElement pickerContinueButton;
	
	
	@FindBy(id="flipboard.app:id/icon_button_text")
	public WebElement nextButton;


	public ChooseTopicScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		System.out.println(nextButton);
		
	}
	
	public ChooseTopicScreen chooseTopics(int topicsCount) {
		
		
		for (int i = 0; i < topicsCount; i++) {
			topic.get(i).click();
			ExtentListeners.testReport.get().log(Status.INFO, "selecting the value "+topic.get(i).getText()+"\n");
		}
		
		return new ChooseTopicScreen(driver);
	}
	
	public ChooseTopicScreen clickContinue() {
		pickerContinueButton.click();
		
		return this;
	}
	
	
	public ShareScreen clickNextButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flipboard.app:id/icon_button_text")));
	
		nextButton.click();
		return new ShareScreen(driver);
		
	}

}
