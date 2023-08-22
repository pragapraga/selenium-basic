package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SalesforceSalesChatter {
	
	WebDriver driver;
	ChromeOptions Coptions;
	@BeforeMethod
	public void setUp() {
		
		Coptions = new ChromeOptions().addArguments("--disable-notifications");
		driver = new ChromeDriver(Coptions);
		driver.get("https://login.salesforce.com");
	}
	
	@Test
	public void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));

        username.sendKeys("hari.radhakrishnan@qeagle.com");
        password.sendKeys("Leaf$1234");
        loginButton.click();
        WebElement menu = driver.findElement(By.cssSelector(".slds-icon-waffle"));
        menu.click();
        driver.findElement(By.xpath("//lightning-button")).click();
        driver.findElement(By.xpath("//input[@part='input']")).sendKeys("Content");
        WebElement dashLink = driver.findElement(By.xpath("//div[@data-name='Content']"));
		dashLink.click();
		WebElement campLink = driver.findElement(By.xpath("//a[@title='Chatter']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",campLink);
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		String currentTitle  = driver.getTitle();
		System.out.println(currentTitle);
		driver.findElement(By.xpath("//label/span[contains(text(),'Question')]//parent::label//following-sibling::textarea")).sendKeys("This is my question");
		driver.findElement(By.xpath("//div[@id='outerContainer']//span[text()='Details']//parent::span//following-sibling::div//p")).sendKeys("This is my details");
		//driver.findElement(By.xpath("//label/span[text()='End Date']//parent::label//following-sibling::div/input")).sendKeys("8/25/2023");
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
	}

}
