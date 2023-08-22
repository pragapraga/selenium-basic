package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartGame {
	/*
	 * 
1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Accounts tab 
5. Click on New button
6. Enter 'your name' as account name                                           
7. Click save 
URL: https://login.salesforce.com/
Username :hari.radhakrishnan@qeagle.com
Password :

WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
	 */
	
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));

        username.sendKeys("hari.radhakrishnan@qeagle.com");
        password.sendKeys("Leaf$1234");
        loginButton.click();
        WebElement menu = driver.findElement(By.cssSelector("div.slds-icon-waffle"));
        menu.click();
	}

}
