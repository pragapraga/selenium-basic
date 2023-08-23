package com.selenium.day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameMe {

    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void alertValidate() {
       driver.switchTo().frame(0);
       driver.findElement(By.xpath("//button[@id='Click']")).click();
       driver.switchTo().defaultContent();
       driver.switchTo().frame(1);
        driver.findElement(By.xpath("//button[@id='Click']")).click();
        driver.switchTo().defaultContent();
       driver.switchTo().frame(2);
       driver.switchTo().frame("frame2");
        driver.findElement(By.xpath("//button[@id='Click']")).click();
    }
}
