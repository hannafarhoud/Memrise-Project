package MemriseMobile.TestMemrise;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ConversationsPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	private By selectConversationsTab = MobileBy.AccessibilityId("Conversations");
	private By selectConversation = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)");
	private By startConversation = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Start conversation\")");
	private By writeConversation = MobileBy.className("android.widget.EditText");
	private By sendButton = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Image\").instance(5)");
	private By micButton = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Image\").instance(4)");

	public ConversationsPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void clickConversationsTab() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(selectConversationsTab)).click();
		
	}
	
	public boolean conDisplayed() {
		return driver.findElement(selectConversationsTab).isDisplayed();
		
	}
	
	public void clickOnConversation() {
		wait.until(ExpectedConditions.elementToBeClickable(selectConversation)).click();
		wait.until(ExpectedConditions.elementToBeClickable(startConversation)).click();
		
	}
	
	public void writeOnConversation() {
		wait = new WebDriverWait(driver, 10);
		Set<String> contextHandles = driver.getContextHandles();
	    // Loop through contexts to find the web view
	    for (String context : contextHandles) {
	        if (context.contains("WebView")) {
	            driver.context(context); // Switch to the web view context
	            break;
	        }
	    }
	    wait.until(ExpectedConditions.elementToBeClickable(writeConversation)).click();
	    driver.hideKeyboard();
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    driver.findElement(writeConversation).sendKeys("Hello");
	    driver.findElement(sendButton).click();
		
	}
	
	public void useMicOnConversation() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(micButton)).click();
		Thread.sleep(5000);
	    driver.findElement(sendButton).click();

	}
	
	public void specialCharOnConversation() {
		wait.until(ExpectedConditions.elementToBeClickable(writeConversation)).click();
		driver.hideKeyboard();
	    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	    driver.findElement(writeConversation).sendKeys("###");
	    driver.findElement(sendButton).click();
	    driver.context("NATIVE_APP");

	}

}
