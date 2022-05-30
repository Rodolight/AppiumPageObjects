package utilies;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public  class ScrollUtil {
	
	
	public static void swipeDown(int howManySwipes, AppiumDriver<MobileElement> driver) {
		Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
				try {
					for (int i = 1; i <= howManySwipes; i++) {
					new TouchAction<>(driver).press(PointOption.point(startVerticalX, endVerticalY))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(startVerticalX, startVerticalY))
							.release().perform();
				}
			} catch (Exception e) {
			   //print error or something
				System.out.println(e);
			}
				
	}
	
	public static void swipeUp(int howManySwipes, AppiumDriver<MobileElement> driver) {
		Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
				try {
					for (int i = 1; i <= howManySwipes; i++) {
						
					new TouchAction<>(driver).press(PointOption.point(startVerticalX, startVerticalY))
							.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(startVerticalX, endVerticalY))
							.release().perform();
				}
			} catch (Exception e) {
			   //print error or something
				System.out.println(e);
			}
				
	}

}
