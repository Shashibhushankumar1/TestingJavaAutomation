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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	String OfferPageProductName;
	TestContextSetup testContextSetup;
	//Single responsblity Principle
	//loosly coupled
	
	PageObjectManager pageObjectManager;
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Then("user searched for {string} shortname in offers page to check if product exist with same name")
	public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage=new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);
		   testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		   Thread.sleep(2000);
		    OfferPageProductName= offersPage.getProductName();
//		    System.out.println(OfferPageProductName);
	}
	
	public void switchToOffersPage() {
		//if switched to offer page-> skip below part
//		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			//Then Run Below code
//		pageObjectManager=new PageObjectManager(testContextSetup.driver);
		
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		   Set<String> s1=testContextSetup.driver.getWindowHandles();
		   Iterator<String> i1=s1.iterator();
		   String parentWindow=i1.next();
		   String childWindow=i1.next();
		   testContextSetup.driver.switchTo().window(childWindow);
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(OfferPageProductName, testContextSetup.landingPageProductName);
	}
}
