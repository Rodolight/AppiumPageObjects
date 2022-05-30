package utilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	private static AppiumDriver<MobileElement> driver;
	private static URL serverUrl;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	private static String APPIUM_PORT;
	public static int IMPLICIT_WAIT_TIME;
	private static int EXPLICIT_WAIT_TIME;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
//	private static String APP_PATH;
//	private static String BROWSER_NAME;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static Properties prop = new Properties();
	private static FileInputStream fis;
	
	public static void loadAndroidConfProp(String loadPropertyFile) {
		
		
		try {
		 fis	 = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+loadPropertyFile);
		System.out.println(fis);
		log.info(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG = prop.getProperty("base.apk").toString();
		APP_ACTIVITY = prop.getProperty("application.activity");
//		APP_PATH = prop.getProperty("application.path");
//		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.point");
		
	}
	
	
	public static void setAndroidCapabilities() {
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,APP_ACTIVITY);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		
	}
	
	
	
	
	
	
public static void loadIOSConfProp(String loadPropertyFile) {
		
		
		
	}



public static void setIOSCapabilities() {
	
}


public static AppiumDriver<MobileElement> getAndroidDriver()  {
		
	try {
		
		serverUrl = new URL("http://localhost:"+APPIUM_PORT+ "/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);

	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info(driver.toString());
	return driver;
}


public static AppiumDriver<MobileElement> getIOSDriver(){
	return driver;
}




}
