package com.selenium.day9;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Screenshot {
    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications")
                .addArguments("--start-maximized");
        driver = new ChromeDriver(Coptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
    }

    @Test
    public void waitowait() throws InterruptedException {
       Assert.assertEquals(driver.getTitle(),"Google");
       File scrshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}