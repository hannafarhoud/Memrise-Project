package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LessonsPage;

public class LessonsTest extends TestBase {

	LessonsPage lesson;

	@BeforeClass
	public void setUpPage() {
		lesson = new LessonsPage(driver);
	}

	@Test(priority = 1)
	public void TC01_OpenMyLessonsPage() {
		boolean result = lesson.openMyLessonsPage();
		Assert.assertTrue(result, "MyLessons page didnt opened");
	}

	@Test(priority = 2)
	public void TC02_OpenWordlistsByMyLessons() {
		boolean result = lesson.openWordlists();
		Assert.assertTrue(result, "Wordlists page didnt opened");
		lesson.back();
	}

	@Test(priority = 3)
	public void TC03_StartLesson() {
		boolean result = lesson.startLesson();
		Assert.assertTrue(result, "Wordlists page didnt opened");
		lesson.back();
	}

	@Test(priority = 4)
	public void TC04_TC05_skipLessonThenCancel() {
		boolean result = lesson.skipLessonThenCancel();
		Assert.assertTrue(result, "Skip and Cancel are not performed");
	}

	@Test(priority = 5)
	public void TC06_selectAnotherGroupLevel() {
		boolean result = lesson.selectAnotherGroupLevel();
		Assert.assertTrue(result, "Select another group level is not performed");
	}
}
