package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
LandingPage landingPage;
//Spring framework, EJB, 
//SRP
//
//Step :-2
public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
}
//
	@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
		//GetTitle of landing page
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
}

	//Dynamic string regular expression below example of Scenario Outline: 
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName ) throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName +" is extracted from Home page");
			
}
	//Step :-6
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		//Here calling from landingPage 
		// convert string to INT -->Integer.parseInt(quantity)
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
}
