package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.VideosPage;

public class VideosTest extends TestBase {

	private VideosPage videos;

	@BeforeClass
	public void setUpPage() {
		videos = new VideosPage(driver);
	}

	@Test(priority = 1)
	public void TC07_OpenVideosPage() {
		boolean result = videos.openVideosPage();
		Assert.assertTrue(result, "Videos page did not open");
	}

	@Test(priority = 2)
	public void TC08_WatchVideo() throws InterruptedException {
		boolean result = videos.watchVideo();
		Assert.assertTrue(result, "Video did not played");
		videos.back();
	}

	@Test(priority = 3)
	public void TC9_SearchByTopics() {
		boolean result = videos.searchByTopicFood();
		Assert.assertTrue(result, "Search is not working");
		videos.back();
	}

	@Test(priority = 5)
	public void TC10_ClickLearnWords() {
		boolean result = videos.clickLearnWords();
		Assert.assertTrue(result, "Learn words from watched videos did not opened");
		videos.xIcon();
	}

	@Test(priority = 6)
	public void TC11_TC12_ClickPracticeWordsFrom() {
		boolean result = videos.clickPracticeWordsFrom();
		Assert.assertTrue(result, "Practice words from unwatched videos did not opened");
		videos.xIcon();
	}
}
