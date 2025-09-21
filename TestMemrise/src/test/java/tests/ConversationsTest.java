package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ConversationsPage;

public class ConversationsTest extends TestBase {
	ConversationsPage conversation;
	
  @Test (priority = 1)
  public void chooseConversationsTab() {
	  conversation.clickConversationsTab();
	  Assert.assertTrue(conversation.conDisplayed(), "Conversations Page should appear!");
	  System.out.println("Page Loads Successfully!");
	  
  }
  
  @Test (priority = 2)
  public void selectConversation() {
	  conversation.clickOnConversation();
	  
  }
  
  @Test (priority = 3)
  public void writeConversation() {
	  conversation.writeOnConversation();
	  
  }
  
  @Test (priority = 4)
  public void micConversation() throws InterruptedException {
	  conversation.useMicOnConversation();
	  
  }
  
  @Test (priority = 5)
  public void specialCharConversation() {
	  conversation.specialCharOnConversation();
	  
  }
  
  @BeforeClass
  public void initialize() {
	  conversation = new ConversationsPage(driver);
  }
}
