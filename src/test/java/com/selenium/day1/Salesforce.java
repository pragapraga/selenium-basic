package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Salesforce {
	
	WebDriver driver;
	ChromeOptions Coptions;
	@BeforeMethod
	public void setUp() {
		
		Coptions = new ChromeOptions().addArguments("--disable-notifications");
		driver = new ChromeDriver(Coptions);
		driver.get("https://login.salesforce.com");
	}
	
	@Test
	public void loginAndValidate() {
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
        driver.findElement(By.xpath("//input[@part='input']")).sendKeys("accounts");
        WebElement accLink = driver.findElement(By.xpath("//one-app-launcher-tab-item/a[@data-label='Accounts']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",accLink);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Account name");
		driver.findElement(By.xpath("//lightning-button/button[@name='SaveEdit']")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
