package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguagesTest extends TestBase {

	private LoginPage authPage;
	private LanguagesPage languagesPage;

	@BeforeClass
	public void init() {
		authPage = new LoginPage(driver);
		languagesPage = new LanguagesPage(driver);
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

}
