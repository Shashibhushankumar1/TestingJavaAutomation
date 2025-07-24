package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
//TestContextSetup is main class or Heart of framework
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	//Step :-3
	public TestContextSetup() throws IOException {
		//1)Here Object Created
		testBase=new TestBase();
		
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		 genericUtils =new GenericUtils(testBase.WebDriverManager()); 
	}
	
}
