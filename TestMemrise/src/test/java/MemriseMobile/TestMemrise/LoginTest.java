package MemriseMobile.TestMemrise;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	private LoginPage authPage;

	@BeforeClass
	public void initPage() {
		authPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void testValidLogin() {
		authPage.loginWithEmail("testingmobile093@outlook.com", "PerformanceTest@2025");
	}
}
