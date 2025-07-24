package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

TestContextSetup testContextSetup;
	//2)Here created TestContextSetup object
	public Hooks(TestContextSetup testContextSetup)
	{
		//assign
		this.testContextSetup = testContextSetup;
	}
	@After
	public void AfterScenario() throws IOException
	{
		//3)Then you can Access TestBase WebDriverManager
		
		testContextSetup.testBase.WebDriverManager().quit();
	}
	//It will execute feature file written every scenario check any failure then take screenshot
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver =testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
		
	}
}
