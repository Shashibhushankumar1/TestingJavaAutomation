package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue = "stepDefinitions",monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	//Run scenarios parllel
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		//super.scenarios(); it is calling from parent AbstractTestNGCucumberTests
		return super.scenarios();
	}
}
