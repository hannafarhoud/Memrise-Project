package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

	private HomePage homePage;

	@BeforeClass
	public void init() {
		homePage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void testDisplayMyWords() {
		homePage.navigateToFrench();
		homePage.naviageToMyWords();

	}

	@Test(priority = 2)
	public void testSortBy() {
		homePage.sortWordsBy();
	}

	@Test(priority = 3)
	public void testhearThePronunciation() {
		homePage.hearThePronunciation();
	}

	@Test(priority = 4)
	public void testMarkAsKnown() {
		homePage.markAsKnown();
	}

	@Test(priority = 5)
	public void testunmarkAsKnown() {
		homePage.unmarkAsKnown();
	}

	@Test(priority = 6)
	public void testGetWordInformation() {
		homePage.getWordInformation();
	}

	@Test(priority = 7)
	public void testViewMyActivitieslast30Days() {
		homePage.viewMyActivities();
	}

	@Test(priority = 8)
	public void testViewJourney() {
		homePage.viewMyJourney();
	}

	@Test(priority = 9)
	public void changeToArabic() {
		homePage.changeToArabic();

	}

}
