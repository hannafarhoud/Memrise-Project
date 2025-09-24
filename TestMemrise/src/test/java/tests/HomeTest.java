package MemriseMobile.TestMemrise;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

	private HomePage homePage;
	private WebDriverWait wait;

	@BeforeClass
	public void init() {
		homePage = new HomePage(driver);
		wait = new WebDriverWait(driver, 10);

	}

	@Test(priority = 1)
	public void testDisplayMyWords() {
		homePage.navigateToFrench();
		homePage.naviageToMyWords();

		WebElement myWordsElement = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getMyWordsLocator()));

		Assert.assertTrue(myWordsElement.isDisplayed());

	}

	@Test(priority = 2)
	public void testSortBy() {
		homePage.sortWordsBy();

		WebElement sortByEng = wait
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSortByEngLocator()));
		Assert.assertTrue(sortByEng.isDisplayed());
	}

	@Test(priority = 3)
	public void testhearThePronunciation() {
		homePage.hearThePronunciation();

		WebElement listenIcon = wait.until(ExpectedConditions.elementToBeClickable(homePage.getListenIconLocator()));
		Assert.assertTrue(listenIcon.isEnabled());
	}

	@Test(priority = 4)
	public void testMarkAsKnown() {
		homePage.markAsKnown();

		WebElement unmarkBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getUnmarkAsKnownLocator()));
		Assert.assertTrue(unmarkBtn.isDisplayed());
	}

	@Test(priority = 5)
	public void testunmarkAsKnown() {
		homePage.unmarkAsKnown();

		WebElement markBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getMarkAsKnownLocator()));
		Assert.assertTrue(markBtn.isDisplayed());
	}

	@Test(priority = 6)
	public void testGetWordInformation() {
		homePage.getWordInformation();

		WebElement wordInfo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getWordInformationLocator()));
		Assert.assertTrue(wordInfo.isDisplayed());
	}

	@Test(priority = 7)
	public void testViewMyActivitieslast30Days() {
		homePage.viewMyActivities();

		WebElement last30Days = wait
				.until(ExpectedConditions.visibilityOfElementLocated(homePage.getLast30DaysLocator()));
		Assert.assertTrue(last30Days.isDisplayed());
	}

	@Test(priority = 8)
	public void testViewJourney() {
		homePage.viewMyJourney();
		WebElement journey = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getJourneyLocator()));
		Assert.assertTrue(journey.isDisplayed());
	}

	@Test(priority = 9)
	public void changeToArabic() {
		homePage.changeToArabic();

		WebElement arabicText = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getArabicLocator()));
		Assert.assertTrue(arabicText.isDisplayed());

	}

}
