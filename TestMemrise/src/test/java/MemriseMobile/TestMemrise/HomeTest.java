package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

	private LoginPage authPage;
	private HomePage homePage;

	@BeforeClass
	public void init() {
		authPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void testValidLogin() {
		authPage.loginWithEmail("maifuad9898@gmail.com", "maiokasha999");
	}

	@Test(priority = 2)
	public void testMywords() {
		homePage.mywords();

	}

}
