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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	String OfferPageProductName;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		testContextSetup.driver =new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		testContextSetup.landingPageProductName= testContextSetup.driver.findElement(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")).getText().split("-")[0].trim();
		 System.out.println(landingPageProductName);
		System.out.println(landingPageProductName +" Is extracted from home page");
	}
	
}
