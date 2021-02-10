package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement flyngNinjaProductLabel;
	WebElement deleteButton;
	WebElement textforassert;
	WebElement textforassert2;
	WebElement textforassert3;
	WebElement textforassert22;
	WebElement emptyCartText;
	public WebElement getEmptyCartText() {
		
		return driver.findElement(By.cssSelector("p[class='cart-empty woocommerce-info']"));
	}

	public WebElement getTextforassert22() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	WebElement removeItemButton;
	public WebElement getRemoveItemButton() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[1]/a"));
	}

	WebElement alertMessage;
	
	
	public WebElement getAlertMessage() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div[1]/div"));
	}

	public WebElement getTextforassert2() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[2]/td[3]/a"));
	}

	public WebElement getTextforassert3() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[3]/td[3]/a"));
	}

	public WebElement getTextforassert() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFlyngNinjaProductLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.className("remove"));
		
	}
	
	public void deleteItem() {
		this.getDeleteButton().click();
	}
	
}
