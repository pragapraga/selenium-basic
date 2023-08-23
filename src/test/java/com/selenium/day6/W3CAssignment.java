package com.selenium.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class W3CAssignment {


    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
    }

    @Test
    public void alertAndIframeValidate() {
    driver.switchTo().frame("iframeResult");
    driver.findElement(By.xpath("//button[contains(text(),'Try')]")).click();
    driver.switchTo().alert().accept();
    Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(),"You pressed OK!");
    }
}
