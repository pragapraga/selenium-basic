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

public class DragAndDrop {
    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(enabled = false)
    public void draggable() throws InterruptedException {
        driver.get("https://jqueryui.com/draggable/");
        driver.switchTo().frame(0);
        System.out.println(driver.getTitle());
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.dragAndDropBy(element, 200, 0).perform();
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void droppable() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        System.out.println(driver.getTitle());
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(3000);
    }

    @Test
    public void selectable() throws InterruptedException {
        driver.get("https://jqueryui.com/selectable/");
        driver.switchTo().frame(0);
        WebElement optionOne = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
        WebElement optionTwo = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(optionOne).click(optionTwo).perform();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
