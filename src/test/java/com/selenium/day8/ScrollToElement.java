package com.selenium.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollToElement {
        WebDriver driver;
        ChromeOptions Coptions;

        @BeforeMethod
        public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        @Test
        public void scrollToElement() {
        System.out.println(driver.getTitle());
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
        actions.moveToElement(element).perform();
        element.click();
        System.out.println(driver.getTitle());

    }
        @AfterMethod
        public void tearDown(){
        driver.quit();
    }

}
