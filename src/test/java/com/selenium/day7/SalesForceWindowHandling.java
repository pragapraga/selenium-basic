package com.selenium.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesForceWindowHandling {

    WebDriver driver;
    ChromeOptions Coptions;
    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://login.salesforce.com");
    }

    @Test
    public void loginAndTestWindowHandling() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));
        username.sendKeys("hari.radhakrishnan@qeagle.com");
        password.sendKeys("Leaf$1234");
        loginButton.click();
        driver.findElement(By.xpath("//button[@title='Learn More']")).click();
        System.out.println(driver.getTitle());
        Set<String> windows = driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<>(windows);
        driver.switchTo().window(listOfWindows.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(listOfWindows.get(0));
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
