package tests;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class TestBase {

	protected AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "com.memrise.android.memrisecompanion");
		capabilities.setCapability("appActivity", "com.memrise.android.alexlanding.AlexLandingActivity");
		capabilities.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
	}
}
