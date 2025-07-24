package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
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
}
