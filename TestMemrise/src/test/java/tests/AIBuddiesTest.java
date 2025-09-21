package tests;

import java.time.Duration;
import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AIBuddiesPage;

public class AIBuddiesTest extends TestBase{
	AIBuddiesPage buddies;
	
	@Test (priority = 1)
	  public void chooseBuddiesTab() {
		  buddies.clickOnBuddies();
		  Assert.assertTrue(buddies.BuddiesDisplayed(), "AIBuddies Page should appear!");
		  System.out.println("Page Loads Successfully!");
		  
	  }
	
	@Test (priority = 2)
	public void selectHelperOnBuddies() {
		buddies.clickOnHelper();
		Assert.assertTrue(buddies.helperClickable(), "Helper AI should appear!");

	}
	
	@Test (priority = 3)
	public void verifyResponseTime() {
		Instant startTime = Instant.now();
		buddies.sendMessageToHelper();
		buddies.waitForAIResponse();
		Instant endTime = Instant.now();
		long responseTime = Duration.between(startTime, endTime).toMillis();
		final long maxResponse = 5000;
		Assert.assertTrue(responseTime < maxResponse,
				"AI response time (" + responseTime + "ms) exceeded the maximum limit of " + maxResponse + "ms.");
		buddies.closeHelper();
		
	}
	
	@Test(priority = 4)
	public void switchBetweenAI() throws InterruptedException {
		buddies.switchBuilderAI();
		
	}
  
  @BeforeClass
  public void initialize() {
	  buddies = new AIBuddiesPage(driver);
  }
}
