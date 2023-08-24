package com.selenium.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandle {

    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://www.leafground.com/window.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void windowHanldes() {
        System.out.println(driver.getWindowHandle());
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        List<String> listOfWindows = new ArrayList<String>(windows);
        System.out.println(listOfWindows);
        System.out.println(driver.getTitle());
        driver.switchTo().window(listOfWindows.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(listOfWindows.get(0));
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
