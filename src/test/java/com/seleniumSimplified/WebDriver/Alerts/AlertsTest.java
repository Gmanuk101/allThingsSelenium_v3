package com.seleniumSimplified.WebDriver.Alerts;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
    public void alertBox()
    {
        WebElement alertBox = driver.findElement(By.cssSelector("input[id='alertexamples']"));



        String alterAssertMessage = "I am an alert box!";
        alertBox.click();
        Assert.assertEquals(alterAssertMessage, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void promptMessage()
    {
        WebElement promptBoxMessage = driver.findElement(By.cssSelector("input[id='promptexample']"));
        String promptMessage = "I prompt you";
        promptBoxMessage.click();
        Assert.assertEquals(promptMessage, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void promptMessageChange()
    {
        WebElement promptBox = driver.findElement(By.cssSelector("input[id='promptexample']"));
        promptBox.click();
        String newMess = "New Message";
        Alert promtMessage = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys(newMess);
        promtMessage.accept();
        Assert.assertEquals(newMess, driver.findElement(By.cssSelector("p[id='promptreturn']")).getText());



    }

    @Test
    public void confirmBoxMessage()
    {
        String confirmMessage = "I am a confirm alert";
        WebElement confirmBox = driver.findElement(By.cssSelector("input[id='confirmexample']"));
        confirmBox.click();
        Assert.assertEquals(confirmMessage, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
    /*@AfterClass
    public static void tear()
    {
        driver.quit();
    }*/
}
