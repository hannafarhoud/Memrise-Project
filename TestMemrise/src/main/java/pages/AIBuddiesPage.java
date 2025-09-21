package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AIBuddiesPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	
	private By selectBuddiesTab = MobileBy.AccessibilityId("AI Buddies");
	private By contentBuddies = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)");
	private By selectHelperBuddies = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)");
	private By contentHelper = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)");
	private By textBoxHelper = MobileBy.className("android.widget.EditText");
	private By sendButtonHelper = MobileBy.className("android.widget.Button");
	private By responseMessage = MobileBy.xpath("//android.widget.TextView[contains(@text, 'help')]");
	private By closeHelper = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)");
	private By sentencesBuilder = MobileBy.xpath("//android.widget.TextView[@text=\"باني الجُمَل\"]");
	private By startBuilding = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Start building\")");
	
	public AIBuddiesPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void clickOnBuddies() {
		wait = new WebDriverWait(driver, 10);
		wait.until((ExpectedConditions.elementToBeClickable(selectBuddiesTab))).click();
		
	}
	
	public boolean BuddiesDisplayed() {
		return driver.findElement(contentBuddies).isDisplayed();
		
	}
	
	public void clickOnHelper() {
		wait.until(ExpectedConditions.elementToBeClickable(selectHelperBuddies)).click();
		
	}
	
	public boolean helperClickable() {
		return driver.findElement(contentHelper).isDisplayed();
	}
	
	public void sendMessageToHelper() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxHelper)).sendKeys("I need help!");
		driver.findElement(sendButtonHelper).click();
		
	}
	
	public MobileElement waitForAIResponse() {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(responseMessage));
	}
	
	public void closeHelper() {
		driver.findElement(closeHelper).click();
		
	}
	
	public void switchBuilderAI() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(sentencesBuilder)).click();
		wait.until(ExpectedConditions.elementToBeClickable(startBuilding)).click();
		Thread.sleep(3000);
		closeHelper();
		
	}
	
}
