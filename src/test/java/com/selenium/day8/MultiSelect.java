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

public class MultiSelect {
    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://jqueryui.com/selectable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void multiSelect() throws InterruptedException {
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement optionOne = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
        WebElement optionTwo = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
        WebElement optionThree = driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
        //actions.clickAndHold(optionOne).pause(Duration.ofSeconds(1)).clickAndHold(optionTwo).build().perform();

        Thread.sleep(3000);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
