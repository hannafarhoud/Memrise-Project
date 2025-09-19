package MemriseMobile.TestMemrise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	private AndroidDriver driver;

	private By arabicIconLocator = MobileBy.AccessibilityId("Currently selected language: Arabic");
	private By frenchLocator = By.xpath("//android.widget.TextView[@text=\"French\"]");
	private By mywordsLocator = By.xpath("//android.widget.TextView[@text=\"My words (75)\"]");
	private By sortByLocator = By.xpath("//android.widget.TextView[@text=\"Sort by\"]");
	private By sortByEngLocator = By.xpath("(//android.widget.TextView[@text=\"English (US)\"])[1]");
	private By listenIconLocator = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.widget.Button");

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void navigateToFrench() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement arabicIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(arabicIconLocator));
		arabicIcon.click();

		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchLocator));
		french.click();

	}

	public void naviageToMyWords() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement mywords = wait.until(ExpectedConditions.visibilityOfElementLocated(mywordsLocator));
		mywords.click();
	}

	public void sortWordsBy() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement sortBy = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByLocator));
		sortBy.click();

		WebElement sortByEng = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByEngLocator));
		sortByEng.click();
	}

	public void hearThePronunciation() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement listenIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(listenIconLocator));
		listenIcon.click();
	}

	public void mywords() {
		navigateToFrench();
		naviageToMyWords();
		sortWordsBy();
		hearThePronunciation();
	}

	/*
	 * public void markAsKnown() {
	 * 
	 * }
	 */

}
