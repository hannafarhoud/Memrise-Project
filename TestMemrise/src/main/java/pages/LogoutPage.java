package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LogoutPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	
	private By userSetting = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(3)");
	private By signOutUser = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sign out\")");
	private By yesSignOut = MobileBy.id("android:id/button1");
	private By haveAccountBtn = By.id("com.memrise.android.memrisecompanion:id/already_have_an_account_button");
	
	public LogoutPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void logOutUser() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(userSetting)).click();
		scrollDown(2);
		wait.until(ExpectedConditions.elementToBeClickable(signOutUser)).click();
		wait.until(ExpectedConditions.elementToBeClickable(yesSignOut)).click();
		
	}

	public boolean isLoginScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(haveAccountBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	public void scrollDown(int numberOfScrolls) {
        Dimension size = driver.manage().window().getSize();
        int screenWidth = size.getWidth();
        int screenHeight = size.getHeight();

        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);
        int x = (int) (screenWidth * 0.5);

        for (int count = 0; count < numberOfScrolls; count++) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(x, startY))
                  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                  .moveTo(PointOption.point(x, endY))
                  .release()
                  .perform();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	

}
