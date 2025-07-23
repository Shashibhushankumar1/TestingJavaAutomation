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

public class OfferPageStepDefinition {
	
	String OfferPageProductName;
	TestContextSetup testContextSetup;
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Then("user searched for {string} shortname in offers page to check if product exist with same name")
	public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String shortName) throws InterruptedException {
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		   Set<String> s1=testContextSetup.driver.getWindowHandles();
		   Iterator<String> i1=s1.iterator();
		   String parentWindow=i1.next();
		   String childWindow=i1.next();
		   testContextSetup.driver.switchTo().window(childWindow);
		   testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		   Thread.sleep(2000);
		    OfferPageProductName= testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		    System.out.println(OfferPageProductName);
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(OfferPageProductName, testContextSetup.landingPageProductName);
	}
}
