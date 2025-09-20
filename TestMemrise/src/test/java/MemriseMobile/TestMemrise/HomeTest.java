package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

	//private LoginPage authPage;
	private HomePage homePage;

	@BeforeClass
	public void init() {
		//authPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	/*
	 * @Test(priority = 1) public void testValidLogin() {
	 * authPage.loginWithEmail("maifuad9898@gmail.com", "maiokasha999"); }
	 */

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
	public void testGetInformation() {
		homePage.getInformation();
	}
	
	@Test(priority = 6)
	public void testViewJourney() {
		homePage.viewMyJourney();
	}
	
	@Test(priority = 7)
	public void testViewMyActivities() {
		homePage.viewMyActivities();
	}
	
	
	
	
	
	
	
	
	
	
	

}
