package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ShopPage;

public class BaseTest {
	WebDriver driver;
	MyAccountPage myAccountPage;
	MainPage mainPage;
	
	ShopPage shopPage;
	CartPage cartPage;
	ExcelCitac excelCitac;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.mainPage = new MainPage(driver);
		this.shopPage = new ShopPage(driver);
		this.cartPage = new CartPage(driver);
		excelCitac = new ExcelCitac("data/test plan.xlsx");
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
        driver.quit();
        excelCitac.fis.close();
	}
}
