package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	//Increment click on + icon
	By increment=   By.cssSelector("a.increment");
	//Parnt to child Add To Cart button(Selected for Tomato Product)
	By addToCart = By.cssSelector(".product-action button");

	
	
	//5-6
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	//Step :-6
	//Take input as argument how many need click item (2)
	public void incrementQuantity(int quantity)
	{
		//i=3-1 =2
		int i = quantity-1;
		while(i>0)
		{
			//This loop reapeat two time until i=0 -->click on + icon to increse items
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	//Step :-6 Till
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	
	
}
