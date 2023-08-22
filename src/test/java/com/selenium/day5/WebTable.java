package com.selenium.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.leafground.com/table.xhtml
public class WebTable {

    WebDriver driver;
    ChromeOptions Coptions;

    @BeforeMethod
    public void setUp() {

        Coptions = new ChromeOptions().addArguments("--disable-notifications");
        driver = new ChromeDriver(Coptions);
        driver.get("https://www.leafground.com/table.xhtml");
    }

    @Test
    public void webTableData() {
        List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']//tbody/tr"));
        List<WebElement> allCols = driver.findElements(By.xpath("//div[@class='ui-datatable-scrollable-body']//thead/tr/th/span"));
        List<CustomerDetails> Custlist = new ArrayList<>();
        for (int i = 1; i < allRows.size(); i++) {
                String name = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[" + i + "]/td[1]")).getText();
                String country = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
                String rep = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[" + i + "]/td[3]")).getText();
                String joinDate = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[" + i + "]/td[4]")).getText();
                String status = driver.findElement(By.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr[" + i + "]/td[5]")).getText();
                Custlist.add(new CustomerDetails(name,country,rep,joinDate,status));
        }
        System.out.println(Custlist);
    }
}
