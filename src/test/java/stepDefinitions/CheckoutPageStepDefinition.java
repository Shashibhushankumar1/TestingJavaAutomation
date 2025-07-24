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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	//Step :-5
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
public CheckoutPage checkoutPage;
TestContextSetup testContextSetup;
//Spring framework, EJB, 
//SRP
//
//Step :-5
public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
{
	
	this.testContextSetup=testContextSetup;
	//Below line of code execute first then any code will execute because constructor execute first
	this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
}


@Then("verify user has ability to enter promo code and place the order")
public void  verify_user_has_ability_enter_promo()
{
	//This method return true or false so validate
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	
}
//Dynamic Scenario
@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout(String name) throws InterruptedException
{
	//name is product name
	checkoutPage.CheckoutItems();
//	Thread.sleep(2000);
	//Assertion to extract name from screen and compare with name
}


	
}
