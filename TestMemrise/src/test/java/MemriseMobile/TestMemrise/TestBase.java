package MemriseMobile.TestMemrise;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	public static AndroidDriver<MobileElement> driver;
	private static String path = "http://127.0.0.1:4723/wd/hub";

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:deviceName", "GUYDU17C08000882");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:appPackage", "com.memrise.android.memrisecompanion");
		caps.setCapability("appium:appActivity", "com.memrise.android.alexlanding.AlexLandingActivity");
		caps.setCapability("noReset", true);
		caps.setCapability("fullReset", false);

		driver = new AndroidDriver<>(new URL(path), caps);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
}
