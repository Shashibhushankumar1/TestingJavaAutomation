package com.locaters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameId {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.id("inputUsername")).sendKeys("shashi");
	driver.findElement(By.name("inputPassword")).sendKeys("Yadav");
	driver.findElement(By.className("signInBtn")).click();
	// 1.Css Selector (Tagname.classname)
	//2.Genric css when --> Tagname[attribute='value']
	// Ex:-<input type="text" placeholder="Username"  value=""> 
	// input[placeholder='Username']
	//Ex:-<p class="error">* Incorrect username or password </p>
	// (Tagname.classname) p.error
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	// 3) <a href="#">Forgot your password?</a>
	//Link text 
	driver.findElement(By.linkText("Forgot your password?")).click();
	// 4 ) X -path --> //tagname[@attribute='value']
	//Ex:-<input type="text" placeholder="Name">
	//    //input[@placeholder='Name']
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sonu");
	//5) Css selector with custmize
	//<input type="text" placeholder="Email" xpath="1">
	driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("shashi@123");
	//With Index   //input[@type='text'][2]
	driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
	//Css
	driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rock@123");
	//Parent to child with help of X-path   //form/input[3] --//ParentChildName/childTagName
	driver.findElement(By.xpath("//form/input[3]")).sendKeys("rock");
	driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
	System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
	driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("shashi");
	//Regular Expression Partial text 
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("chkboxOne")).click();
	//Custmize x-path (@class Attribue)
	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	
	
	
	
	
	
}
}
