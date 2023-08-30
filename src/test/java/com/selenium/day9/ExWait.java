package com.selenium.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExWait {
    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications").addArguments("--show-taps");
        driver = new ChromeDriver(Coptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void waitowait() throws InterruptedException {
    driver.findElement(By.xpath("//span[text()='Click']")).click();
    WebElement visibleText = driver.findElement(By.xpath("//h5[contains(text(),'Visibility')]/following-sibling::div//span[text()='Click']"));
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOf(visibleText));
    Assert.assertTrue(driver.findElement(By.xpath("//span[text()='I am here']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
