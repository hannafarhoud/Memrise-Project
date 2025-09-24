package MemriseMobile.TestMemrise;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguagesPage {

	private AndroidDriver driver;
	private WebDriverWait wait;

	private By languageIcon = MobileBy.AccessibilityId("Currently selected language: Arabic");
	private By frenchOption = MobileBy.AndroidUIAutomator("new UiSelector().text(\"French\")");
	private By frenchIcon = MobileBy.AccessibilityId("Currently selected language: French");
	private By addBtn = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Add\")");
	private By germanOption = MobileBy.AndroidUIAutomator("new UiSelector().text(\"German\")");
	private By LearnFromScratch = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Learn from scratch\")");
	private By goalLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"I'm taking a short trip\")");
	private By continueLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Continue\")");

	private By startLearningBtnLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Start learning\")");

	private By maybeLaterLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Maybe later\")");
	private By germanIconLocator = MobileBy.AccessibilityId("Currently selected language: German");
	private By menuLocator = MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");

	private By deleteLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Delete language\")");
	private By deleteBtnLocator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Delete\")");
	private By arabicLoactor = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Arabic\")");

	public LanguagesPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void openLanguageList() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(languageIcon));
		icon.click();

	}

	public void selectFrench() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchOption));
		french.click();
	}

	public void changeLanguageToFrench() {
		openLanguageList();
		selectFrench();
	}

	public void clickFrenchIcon() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement french = wait.until(ExpectedConditions.visibilityOfElementLocated(frenchIcon));
		french.click();
	}

	public void clickAddBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
		addButton.click();

	}

	public void selectGerman() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement german = wait.until(ExpectedConditions.visibilityOfElementLocated(germanOption));
		german.click();

	}

	public void addLanguageToLearn() {
		clickFrenchIcon();
		clickAddBtn();
		selectGerman();
	}

	public void chooseYourLevel() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement level = wait.until(ExpectedConditions.visibilityOfElementLocated(LearnFromScratch));
		level.click();

	}

	public void chooseGoals() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement goal = wait.until(ExpectedConditions.visibilityOfElementLocated(goalLocator));
		goal.click();

	}

	public void clickContinueBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(continueLocator));
		continueBtn.click();

	}

	public void clickStartLearning() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement startLearningBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(startLearningBtnLocator));
		startLearningBtn.click();

	}

	public void clickMaybeLater() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement maybeLaterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(maybeLaterLocator));
		maybeLaterBtn.click();

	}

	public void setUpTheNewLanguage() {
		chooseYourLevel();
		chooseGoals();
		clickContinueBtn();
		clickStartLearning();
		clickMaybeLater();

	}

	public void delteLanguage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement germanIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(germanIconLocator));
		germanIcon.click();

		WebElement menuIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
		menuIcon.click();

		WebElement deleteFromMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocator));
		deleteFromMenu.click();

		WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtnLocator));
		deleteBtn.click();

		WebElement arabic = wait.until(ExpectedConditions.visibilityOfElementLocated(arabicLoactor));
		arabic.click();
	}

	public By getDeletedLanguageLocator() {
		return MobileBy.AccessibilityId("Currently selected language: German");
	}

}
