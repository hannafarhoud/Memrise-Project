package MemriseMobile.TestMemrise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage {

	private AndroidDriver driver;

	private By arabicIconLocator = MobileBy.AccessibilityId("Currently selected language: Arabic");
	private By frenchLocator = By.xpath("//android.widget.TextView[@text=\"French\"]");
	private By mywordsLocator = By.xpath("//android.widget.TextView[@text=\"My words (75)\"]");
	private By sortByLocator = By.xpath("//android.widget.TextView[@text=\"Sort by\"]");
	private By sortByEngLocator = By.xpath("(//android.widget.TextView[@text=\"English (US)\"])[1]");
	private By listenIconLocator = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.widget.Button");
	private By viewBtnLocator = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.widget.Button");
	private By markAsKnownLocator = By.xpath("//android.widget.TextView[@text=\"Mark as known\"]");
	private By backBtn = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
	private By journeyLocator = By.xpath("//android.widget.TextView[@text=\"Beginner\"]");
	private By menuBtnLocator = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]/android.widget.Button");
	private By wordInformationLocator = By.xpath("//android.widget.TextView[@text=\"Word information\"]");
	private By backLocator = By.xpath("//android.widget.ScrollView/android.view.View[1]");
	private By myActivitiesLocator = By.xpath("//android.widget.TextView[@text=\"My Activities\"]");
	private By last30DaysLocator = By.xpath("//android.widget.TextView[@text=\"Last 30 days\"]");
	private By backFromActivities = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
	
	

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void navigateToFrench() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement arabicIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(arabicIconLocator));
		arabicIcon.click();

		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchLocator));
		french.click();

	}

	public void naviageToMyWords() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mywords = wait.until(ExpectedConditions.visibilityOfElementLocated(mywordsLocator));
		mywords.click();
	}

	public void sortWordsBy() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement sortBy = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByLocator));
		sortBy.click();

		WebElement sortByEng = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByEngLocator));
		sortByEng.click();
	}

	public void hearThePronunciation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement listenIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(listenIconLocator));
		listenIcon.click();
	}

	public void markAsKnown() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement viewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewBtnLocator));
		viewBtn.click();

		WebElement markAsKnown = wait.until(ExpectedConditions.visibilityOfElementLocated(markAsKnownLocator));
		markAsKnown.click();
	}

	public void getInformation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtnLocator));
		menuBtn.click();

		WebElement wordInformation = wait.until(ExpectedConditions.visibilityOfElementLocated(wordInformationLocator));
		wordInformation.click();

		WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(backLocator));
		back.click();

		driver.findElement(backBtn).click();

	}

	public void viewMyJourney() {

		driver.findElement(backBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement journey = wait.until(ExpectedConditions.visibilityOfElementLocated(journeyLocator));
		journey.click();

		// Scroll down and up
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);
		TouchAction action = new TouchAction(driver);

		// Scroll down
		action.press(PointOption.point(startX, endY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY)).release().perform();

		// Scroll up
		action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, endY)).release().perform();

		driver.findElement(backBtn).click();

	}

	public void viewMyActivities() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement myActitvity = wait.until(ExpectedConditions.visibilityOfElementLocated(myActivitiesLocator));
		myActitvity.click();
		
		WebElement last30DaysBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(last30DaysLocator));
		last30DaysBtn.click();
		
		//Try to scroll here (Later)
		driver.findElement(backFromActivities).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	

}
