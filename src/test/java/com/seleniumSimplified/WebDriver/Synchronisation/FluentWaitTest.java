package com.seleniumSimplified.WebDriver.Synchronisation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class FluentWaitTest {

    static WebDriver driver;
    static String thisTestUrl = "http://www.compendiumdev.co.uk/selenium/basic_html_form.html";

    @Test
    public void useAFluentWaitTestOne()
    {
        driver = new ChromeDriver();
        driver.get(thisTestUrl);

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(1,TimeUnit.SECONDS)
            .pollingEvery(500,TimeUnit.MILLISECONDS).ignoring(NotFoundException.class);

        wait.until(ExpectedConditions.titleIs("HTML Form Elements"));

        Assert.assertEquals("HTML Form Elements", driver.getTitle() );


    }





}
