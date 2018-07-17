package com.seleniumSimplified.WebDriver.Alerts;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest  {

    private static WebDriver driver;
    private static String testPageUrl = "http://compendiumdev.co.uk/selenium/alerts.html";

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get(testPageUrl);
    }

    @Test //for each alert assert against get text
    public void eachAlert()
    {
        WebElement alertBox = driver.findElement(By.cssSelector("input[id='alertexamples']"));
        WebElement confirmBox = driver.findElement(By.cssSelector("input[id='confirmexample']"));
        WebElement promptBox = driver.findElement(By.cssSelector("input[id='promptexample']"));

        String alterAssertMessage = "I am an alert box!";
        alertBox.click();
        Assert.assertEquals(alterAssertMessage, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    @AfterClass
    public static void tear()
    {
        driver.quit();
    }
}
