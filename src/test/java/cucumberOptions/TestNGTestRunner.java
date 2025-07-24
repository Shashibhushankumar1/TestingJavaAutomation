package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue = "stepDefinitions",
monochrome = true,tags ="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	//Step :-7 (for run particular tag related scenarios Run for tags ="@PlaceOrder" only
	//it will pick from feature file (Checkout.feature)  -->@PlaceOrder
	
	//Run scenarios parllel
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		//super.scenarios(); it is calling from parent AbstractTestNGCucumberTests
		return super.scenarios();
	}
}
