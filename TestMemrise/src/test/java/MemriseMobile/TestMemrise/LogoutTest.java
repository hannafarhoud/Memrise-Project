package MemriseMobile.TestMemrise;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
