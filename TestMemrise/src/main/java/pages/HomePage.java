package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	private AndroidDriver driver;
	private WebDriverWait wait;

	private By arabicIconLocator = MobileBy.AccessibilityId("Currently selected language: Arabic");
	private By frenchLocator = By.xpath("//android.widget.TextView[@text=\"French\"]");
	private By mywordsLocator = By.xpath("//android.widget.TextView[@text=\"My words (75)\"]");
	private By sortByLocator = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View");
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
	private By backFromActivities = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]");
	private By unmarkAsKnown = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Unmark as known\")");
	private By view2Locator = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(3)");
	private By frenchIconLocator = MobileBy.AccessibilityId("Currently selected language: French");
	private By arabicLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Arabic\")");
	private By backToHome = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)");
	private By myJourneyLocator = MobileBy
			.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void navigateToFrench() {
		WebElement arabicIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(arabicIconLocator));
		arabicIcon.click();

		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchLocator));
		french.click();

	}

	public void naviageToMyWords() {
		WebElement mywords = wait.until(ExpectedConditions.visibilityOfElementLocated(mywordsLocator));
		mywords.click();
	}

	public void sortWordsBy() {
		WebElement sortBy = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByLocator));
		sortBy.click();

		WebElement sortByEng = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByEngLocator));
		sortByEng.click();
	}

	public void hearThePronunciation() {
		WebElement listenIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(listenIconLocator));
		listenIcon.click();
	}

	public void markAsKnown() {
		driver.findElement(viewBtnLocator).click();
		WebElement markAsKnown = wait.until(ExpectedConditions.visibilityOfElementLocated(markAsKnownLocator));
		markAsKnown.click();
	}

	public void unmarkAsKnown() {
		WebElement viewMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(view2Locator));
		viewMenu.click();

		WebElement unmark = wait.until(ExpectedConditions.visibilityOfElementLocated(unmarkAsKnown));
		unmark.click();

	}

	public void getWordInformation() {
		WebElement menuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(menuBtnLocator));
		menuBtn.click();

		WebElement wordInformation = wait.until(ExpectedConditions.visibilityOfElementLocated(wordInformationLocator));
		wordInformation.click();

		WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(backLocator));
		back.click();

		driver.findElement(backBtn).click();

	}

	public void viewMyActivities() {
		WebElement myActitvity = wait.until(ExpectedConditions.visibilityOfElementLocated(myActivitiesLocator));
		myActitvity.click();

		WebElement last30DaysBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(last30DaysLocator));
		last30DaysBtn.click();

		driver.findElement(backFromActivities).click();

	}

	public void viewMyJourney() {
		String journeyText = driver.findElement(journeyLocator).getText();
		WebElement journey = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"" + journeyText + "\"))"));

		journey.click();
		driver.findElement(myJourneyLocator);
		driver.findElement(backToHome).click();

	}

	public void changeToArabic() {
		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchIconLocator));
		french.click();

		WebElement arabicBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(arabicLocator));
		arabicBtn.click();

	}

}
