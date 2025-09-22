
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class VideosPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	public VideosPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	private By openVideosPage = MobileBy.AccessibilityId("Videos");
	private By openVideosPageDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Unwatched\")");

	private By selectVideo = MobileBy.AndroidUIAutomator("new UiSelector().text(\"أنا أرى\")");
	private By selectVideoDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Listen in context\")");
	private By watchVideo = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Watch video\")");
	private By watchVideoDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)");

	private By searchTopics = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search\")");
	private By searchTopicsDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Search by Topics\")");
	private By xIconSearch = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)");
	private By food = MobileBy.AndroidUIAutomator("new UiSelector().text(\"طعام\")");
	private By foodDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"طعام\")");

	private By learnWords = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Learn words\").instance(0)");
	private By learnWordsDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)");

	private By watchedTap = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Watched\")");
	private By watchedTapDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)");
	private By xIcon = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)");

	private By practiceWords = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Practice words\").instance(0)");
	private By practiceWordsDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)");

	
	public boolean openVideosPage() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(openVideosPage));
		element.click();
		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(openVideosPageDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did Videos open? " + result);
		return result;
	}

	public boolean watchVideo() throws InterruptedException {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"أنا أرى\"))"));

		MobileElement selectElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(selectVideo));
		selectElement.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectVideoDisplayed));

		MobileElement videoElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(watchVideo));
		videoElement.click();
		Thread.sleep(24000);
		MobileElement sub = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(watchVideoDisplayed));

		boolean result = sub.isDisplayed();
		System.out.println("Did videos and subtitle opend? " + result);
		return result;
	}

	public boolean searchByTopicFood() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(searchTopics));
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTopicsDisplayed));

		MobileElement foodElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(food));
		foodElement.click();
		MobileElement page = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(foodDisplayed));
		driver.findElement(xIconSearch);

		boolean result = page.isDisplayed();
		System.out.println("Did food displayed? " + result);
		return result;
	}

	public boolean clickLearnWords() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(learnWords));
		element.click();

		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(learnWordsDisplayed));
		
		boolean result = page.isDisplayed();
		System.out.println("Did words open? " + result);
		return result;
	}

	public boolean openWatchedSection() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(watchedTap));
		element.click();
		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(watchedTapDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did wathced tap opened? " + result);
		return result;
	}

	public boolean clickPracticeWordsFrom() {
		openVideosPage();
		
		MobileElement watchedTapElement = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(watchedTap));
		watchedTapElement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(watchedTapDisplayed));

		MobileElement practiceElement = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(practiceWords));
		practiceElement.click();
		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(practiceWordsDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did practice words displayed open? " + result);
		return result;

	}

	public void back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void xIcon() {
		driver.findElement(xIcon).click();
	}

}
