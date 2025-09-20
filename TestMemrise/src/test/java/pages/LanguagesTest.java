package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguagesTest extends TestBase {

	private LanguagesPage languagesPage;

	@BeforeClass
	public void init() {
		languagesPage = new LanguagesPage(driver);
	}

	@Test(priority = 1)
	public void testChangeLearningLanguage() {
		languagesPage.changeLanguageToFrench();
	}

	@Test(priority = 2)
	public void testAddLanguagesToLearn() {
		languagesPage.addLanguageToLearn();
		languagesPage.setUpTheNewLanguage();
	}

	@Test(priority = 3)
	public void testDeletLanguage() {
		languagesPage.delteLanguage();
	}

}
