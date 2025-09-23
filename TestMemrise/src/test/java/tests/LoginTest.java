package MemriseMobile.TestMemrise;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends SetupLoginTest {

	private LoginPage authPage;

	@BeforeClass
	public void initPage() {
		authPage = new LoginPage(driver);
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		List<String[]> dataList = new ArrayList<>();
		String csvFilePath = "src\\test\\java\\LoginData.csv";

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {
				String[] values = line.split(",");
				String email = values.length > 0 ? values[0].trim() : "";
				String password = values.length > 1 ? values[1].trim() : "";
				dataList.add(new String[] { email, password });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object[][] data = new Object[dataList.size()][2];
		for (int i = 0; i < dataList.size(); i++) {
			data[i] = dataList.get(i);
		}
		return data;
	}

	@Test(priority = 1)
	public void testHaveAnAccount() throws InterruptedException {

		authPage.clickHaveAccount();
		authPage.clickSignInWithEmail();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailField = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.memrise.android.memrisecompanion:id/onboarding_email_field")));
		Assert.assertTrue(emailField.isDisplayed());

	}

	@Test(dataProvider = "loginData", priority = 2)
	public void testLogin(String email, String password) {
		authPage.loginWithEmail(email, password);
		boolean isError = authPage.handleErrorPopupIfPresent();

		if (isError) {
			authPage.loginWithEmail(email, password);
			isError = authPage.handleErrorPopupIfPresent();
		}

		if (!isError) {
			System.out.println("Login with: " + email + " / " + password);
		} else {
			System.out.println("Login failed with: " + email + " / " + password);
		}
	}

}
