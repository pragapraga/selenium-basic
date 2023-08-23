package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SalesforceDashboard {

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
        driver.findElement(By.xpath("//input[@part='input']")).sendKeys("dashboard");
        WebElement dashLink = driver.findElement(By.xpath("//one-app-launcher-tab-item/a[@data-label='Dashboards']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dashLink);
        driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
        driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by Pragadeeswaran");
        driver.findElement(By.xpath("//div[@id='main']//button[contains(@class,'save')]")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
