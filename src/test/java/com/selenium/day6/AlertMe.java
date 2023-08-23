package com.selenium.day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertMe {

    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertValidate() {
        driver.findElement(By.xpath("//h5[contains(text(),'Prompt')]/following-sibling::button")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Hey this is Pragadeeswaran");
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//span[@id='confirm_result']")).getText());
        driver.switchTo().defaultContent();
    }
}
