package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LogoutPage;

public class LogoutTest extends TestBase {
	LogoutPage logout;
	
  @Test
  public void userLogout() {
	  logout.logOutUser();
	  
  }
  
  @BeforeClass
  public void initialize() {
	  logout = new LogoutPage(driver);
  }
}
