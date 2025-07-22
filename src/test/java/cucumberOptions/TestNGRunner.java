package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//tags="@SmokeTest or @RegressionTest" This will Run only run tags="@SmokeTest or @RegressionTest"
//tags="not @RegressionTest" So it will skip @RegressionTest
@CucumberOptions(features="src/test/java/features",
glue="stepDefinitions",monochrome=true,tags="@SmokeTest or @RegressionTest",
plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"} )
public class TestNGRunner extends AbstractTestNGCucumberTests {	
}
