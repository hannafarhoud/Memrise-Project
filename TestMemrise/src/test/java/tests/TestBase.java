package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class TestBase {

	public static AndroidDriver<MobileElement> driver;
	private static String path = "http://127.0.0.1:4723/wd/hub";

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException {

		// ==================== Appium Desired Capabilities ====================
		DesiredCapabilities caps = new DesiredCapabilities();

		// 🔹 Platform & Device
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:deviceName", "Redmi Note 9");
		caps.setCapability("appium:udid", "059c149b0405"); // from adb devices
		caps.setCapability("appium:automationName", "UiAutomator2");

		// 🔹 App Under Test
		/*
		 * How to find appPackage and appActivity (if you don’t know): 
		 * 1. Launch the app on emulator or device. 
		 * 2. Run: adb shell dumpsys window | find "mCurrentFocus"
		 */
		caps.setCapability("appium:appPackage", "com.memrise.android.memrisecompanion");
		caps.setCapability("appium:appActivity", "com.memrise.android.alexlanding.AlexLandingActivity");

		// 🔹 Useful (real-world stability)
		caps.setCapability("appium:noReset", true); // Keep app data (don’t clear cache/login each run)
		caps.setCapability("appium:fullReset", false); // Don’t uninstall app between tests
		caps.setCapability("appium:newCommandTimeout", 3600); // Session timeout in seconds

		// 🔹 Xiaomi/MIUI quirks
		caps.setCapability("appium:ignoreHiddenApiPolicyError", true); // Bypass hidden API restrictions
		caps.setCapability("appium:skipDeviceInitialization", true); // Skip extra device setup to speed up runs

		// 🔹 Permissions
		caps.setCapability("appium:autoGrantPermissions", true); // Auto-allow app permissions (camera, storage, etc.)

		// ==================== Driver Initialization ====================
		driver = new AndroidDriver<>(new URL(path), caps);
		System.out.println("✅ App launched successfully on Redmi Note 9!");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(3000);
			driver.quit();
		}
	}
}
