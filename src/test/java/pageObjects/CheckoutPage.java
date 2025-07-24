package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	// Step :-2
	public WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	//cart 
	By cartBag = By.cssSelector("[alt='Cart']");
	//x-path based upon button text 
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	//For promo
	By promoBtn = By.cssSelector(".promoBtn");
	//For placeordr to type promocode
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	
	
	//For Add to cart and checkout
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	//
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	//PlaceOrder
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	
	
	
}
