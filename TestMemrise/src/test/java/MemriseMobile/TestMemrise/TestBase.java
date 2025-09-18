package MemriseMobile.TestMemrise;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
//	protected AndroidDriver<WebElement> driver;
	public static AndroidDriver<WebElement> driver;
	private static String path = "http://127.0.0.1:4723/wd/hub";

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("platformName", "Android");
//		caps.setCapability("appium:deviceName", "---");
//		caps.setCapability("appium:automationName", "UiAutomator2");
//		caps.setCapability("appium:appPackage", "---");
//		caps.setCapability("appium:appActivity", "---");
//		caps.setCapability("noReset", true);
//		caps.setCapability("fullReset", false);

		// this line here to handell allow popup
		// caps.setCapability("autoGrantPermissions", true);

		driver = new AndroidDriver<>(new URL(path), caps);
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
}
