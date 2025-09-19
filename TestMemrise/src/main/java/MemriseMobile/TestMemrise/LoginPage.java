package MemriseMobile.TestMemrise;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AndroidDriver<WebElement> driver;
    private WebDriverWait wait;

    private By haveAccountBtn = By.id("com.memrise.android.memrisecompanion:id/already_have_an_account_button");
    private By signInWithEmailBtn = By.id("com.memrise.android.memrisecompanion:id/onboardingEmailView");
    private By emailField = By.id("com.memrise.android.memrisecompanion:id/onboarding_email_field");
    private By passwordField = By.id("com.memrise.android.memrisecompanion:id/onboarding_password_field");
    private By signInBtn = By.id("com.memrise.android.memrisecompanion:id/onboarding_email_authentication_button");

    public LoginPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    public void clickHaveAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(haveAccountBtn)).click();
    }

    public void clickSignInWithEmail() {
        driver.findElement(signInWithEmailBtn).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInBtn).click();
    }

    public void loginWithEmail(String email, String password) {
        clickHaveAccount();
        clickSignInWithEmail();
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }
}
