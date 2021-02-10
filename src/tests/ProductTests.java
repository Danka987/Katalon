package tests;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 0)
	public void addProductToCart() throws InterruptedException {
		mainPage.navigateToShopTab();
		Thread.sleep(2000);
		shopPage.getFlyngNinjaAddToCardButton().click();
		Thread.sleep(2000);
		mainPage.navigateToCartTab();
		Thread.sleep(2000);
		String textForAssert = cartPage.getFlyngNinjaProductLabel().getText();
		Assert.assertEquals(textForAssert, "Flying Ninja");
	}

	@Test
	public void removeProductFromCart() throws InterruptedException {

		String textToAssert = excelCitac.getStringData("removeItem", 5, 2);

		this.addProductToCart();

		Thread.sleep(2000);
		cartPage.deleteItem();
		Thread.sleep(2000);
		String textForAssert = cartPage.getEmptyCartText().getText();
		Assert.assertEquals(textForAssert, textToAssert);

	}

	@Test
	public void dodajTriProizvoda() throws InterruptedException {

		String text1 = excelCitac.getStringData("dodajTriProizvoda", 6, 2);
		String text2 = excelCitac.getStringData("dodajTriProizvoda", 7, 2);
		String text3 = excelCitac.getStringData("dodajTriProizvoda", 8, 2);

		shopPage.getFlyngNinjaAddToCardButton().click();
		Thread.sleep(2000);
		shopPage.getFlyngNinjaAddToCardButton2().click();
		Thread.sleep(2000);
		shopPage.getFlyngNinjaAddToCardButton3().click();
		Thread.sleep(2000);
		mainPage.navigateToCartTab();
		Thread.sleep(2000);

		String textForAssert1 = cartPage.getTextforassert().getText();
		Assert.assertEquals(textForAssert1, text1);
		Thread.sleep(2000);
		String textForAssert2 = cartPage.getTextforassert2().getText();
		Assert.assertEquals(textForAssert2, text2);
		Thread.sleep(2000);
		String textForAssert3 = cartPage.getTextforassert3().getText();
		Assert.assertEquals(textForAssert3, text3);

	}

	@Test
	public void dodajDvaItema() throws InterruptedException {
		String text2 = excelCitac.getStringData("dodajDvaProizvoda", 7, 2);
		String text1 = excelCitac.getStringData("dodajDvaProizvoda", 6, 2);

		shopPage.getFlyngNinjaAddToCardButton().click();
		Thread.sleep(2000);
		shopPage.getFlyngNinjaAddToCardButton2().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		mainPage.navigateToCartTab();
		Thread.sleep(2000);
		cartPage.getRemoveItemButton().click();
		Thread.sleep(2000);
		String textForAssert1 = cartPage.getTextforassert22().getText();
		Assert.assertEquals(textForAssert1, text2);
		String textForAssert2 = cartPage.getAlertMessage().getText();
		Assert.assertEquals(textForAssert2, text1);

		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
