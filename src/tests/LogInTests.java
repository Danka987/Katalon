package tests;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void logIn() throws InterruptedException {
		String username = excelCitac.getStringData("LogIn", 5, 2);
		String password = String.valueOf(excelCitac.getIntData("LogIn", 6, 2));
		String logOutText = excelCitac.getStringData("LogIn", 9, 2);

		mainPage.navigateToMyAccount();
		Thread.sleep(2000);

		// myAccountPage.logIn("customer","123456789");
		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);

		String textForAssert = myAccountPage.getLogOutLabel().getText();
		Assert.assertEquals(textForAssert, logOutText);
	}

	 @Test (priority = 5)
	public void logInWithoutCredentials() throws InterruptedException {
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		// myAccountPage.logIn("customer","123456789");
		myAccountPage.insertUsername("");
		Thread.sleep(2000);
		myAccountPage.insertPassword("");
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);

		String textForAssert = myAccountPage.getNoCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, "Error: Username is required.");
	}

	 @Test (priority = 10)
	public void logInWrongCredentials() throws InterruptedException {
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		// myAccountPage.logIn("customer","123456789");
		myAccountPage.insertUsername("customer1");
		Thread.sleep(2000);
		myAccountPage.insertPassword("asdasdasd");
		Thread.sleep(2000);
		myAccountPage.logInButtonClick();
		Thread.sleep(2000);

		String textForAssert = myAccountPage.getWrongCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, "ERROR: Invalid username. Lost your password?");
	}

	 @Test (priority = 15)
	public void logOut() throws InterruptedException {
		logIn();
		myAccountPage.getLogOutLabel().click();

		String textForAssert = myAccountPage.getLogInButton().getText();
		Assert.assertEquals(textForAssert, "LOG IN");
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
