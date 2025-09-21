package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LessonsPage {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	public LessonsPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10); // old constructor for Selenium 3
	}

	// locators
	private By myLessonPage = MobileBy.AccessibilityId("My Lessons");
	private By myLessonPageDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)");

	private By wordslistPage = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Wordlists\")");
	private By wordslistPageDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Wordlists\")");

	private By startLesson = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Start\")");
	private By startLessonDisplayed = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)");

	private By skipLesson = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Skip for now\")");
	private By skipLessonDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Skip this lesson?\")");
	private By cancelSkip = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Cancel\")");

	private By anotherGroupLevel = MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Learn words with locals\").instance(2)");
	private By anotherGroupLevelDisplayed = MobileBy.AndroidUIAutomator("new UiSelector().text(\"ABOUT THIS LESSON\")");

	// Functions
	public boolean openMyLessonsPage() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(myLessonPage));
		element.click();

		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(myLessonPageDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did MyLessons open? " + result);
		return result;
	}

	public boolean openWordlists() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(wordslistPage));
		element.click();

		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(wordslistPageDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did wordslist open? " + result);
		return result;
	}

	public boolean startLesson() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(startLesson));
		element.click();

		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(startLessonDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did startLesson open? " + result);
		return result;
	}

	public boolean skipLessonThenCancel() {
		MobileElement skipElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(skipLesson));
		skipElement.click();

		MobileElement skip = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(skipLessonDisplayed));

		boolean result1 = skip.isDisplayed();
		System.out.println("Did skipLesson open? " + result1);

		MobileElement cancelEement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(cancelSkip));
		cancelEement.click();

		MobileElement cancel = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(myLessonPageDisplayed));

		boolean result2 = cancel.isDisplayed();
		System.out.println("Did cancel displayed? " + result2);

		return result1 && result2;
	}

	public boolean selectAnotherGroupLevel() {
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(anotherGroupLevel));
		element.click();

		MobileElement page = (MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(anotherGroupLevelDisplayed));

		boolean result = page.isDisplayed();
		System.out.println("Did group level open? " + result);
		return result;
	}

	public void back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}