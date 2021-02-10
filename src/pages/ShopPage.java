package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	WebDriver driver;
	WebElement flyngNinjaAddToCardButton;
	WebElement flyngNinjaAddToCardButton2;
	WebElement flyngNinjaAddToCardButton3;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFlyngNinjaAddToCardButton2() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[2]/div/a[2]"));
	}

	public WebElement getFlyngNinjaAddToCardButton3() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[3]/div/a[2]"));
	}

	public WebElement getFlyngNinjaAddToCardButton() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[2]"));
	}
	
	
}
