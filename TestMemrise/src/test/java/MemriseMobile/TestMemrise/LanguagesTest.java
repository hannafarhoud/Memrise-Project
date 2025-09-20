package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguagesTest extends TestBase {

	private LoginPage authPage;
	private LanguagesPage languagesPage;
	private HomePage homePage;

	@BeforeClass
	public void init() {
		authPage = new LoginPage(driver);
		languagesPage = new LanguagesPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void testValidLogin() {
		authPage.loginWithEmail("maifuad9898@gmail.com", "maiokasha999");
	}

	@Test(priority = 2)
	public void testChangeLearningLanguage() {
		languagesPage.changeLanguageToFrench();
	}

	@Test(priority = 3)
	public void testAddLanguagesToLearn() {
		languagesPage.addLanguageToLearn();
		languagesPage.setUpTheNewLanguage();
	}

	@Test(priority = 4)
	public void testDeletLanguage() {
		languagesPage.delteLanguage();
	}
   // Do not forget to remove this 
	/*
	 * @Test(priority = 5) public void testhome() { homePage.mywords();
	 * 
	 * }
	 */

}
