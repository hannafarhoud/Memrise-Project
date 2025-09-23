package MemriseMobile.TestMemrise;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	private By haveAccountBtn = MobileBy.AndroidUIAutomator("new UiSelector().text(\"I have an account\")");
	private By signInWithEmailBtn = By.id("com.memrise.android.memrisecompanion:id/onboardingEmailView");
	private By emailField = By.id("com.memrise.android.memrisecompanion:id/onboarding_email_field");
	private By passwordField = By.id("com.memrise.android.memrisecompanion:id/onboarding_password_field");
	private By signInBtn = By.id("com.memrise.android.memrisecompanion:id/onboarding_email_authentication_button");
	private By dismissPopup = By.className("android.widget.Button");

	public LoginPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void clickHaveAccount() {

		WebElement haveAccount = wait.until(ExpectedConditions.elementToBeClickable(haveAccountBtn));
		haveAccount.click();
	}

	public void clickSignInWithEmail() {
		driver.findElement(signInWithEmailBtn).click();
	}

	public void enterEmail(String email) {
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickSignIn() {
		driver.findElement(signInBtn).click();
	}

	public void loginWithEmail(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		clickSignIn();
	}

	public boolean handleErrorPopupIfPresent() {
		WebDriverWait shortWait = new WebDriverWait(driver, 5);
		List<WebElement> buttons = shortWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dismissPopup));

		for (WebElement btn : buttons) {
			if (btn.isDisplayed() && btn.isEnabled()) {
				btn.click();
				clearFields();
				return true;
			}
		}
		return false;

	}

	public void clearFields() {
		driver.findElement(emailField).clear();
		driver.findElement(passwordField).clear();
	}

	public By getEmailField() {
		return emailField;
	}

}
