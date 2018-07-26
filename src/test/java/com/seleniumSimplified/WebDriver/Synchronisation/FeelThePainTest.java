package com.seleniumSimplified.WebDriver.Synchronisation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FeelThePainTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static String url = "https://www.compendiumdev.co.uk/selenium/basic_ajax.html";

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get(url);
        wait = new WebDriverWait(driver, 10, 50);

    }

    @Test
    public void feelThePain() {
        //select server1 from combo1
        WebElement category = driver.findElement(By.id("combo1"));
        WebElement languageUsed = driver.findElement(By.id("combo2"));
        category.findElement(By.cssSelector("option[value='3'")).click();

       // new WebDriverWait(driver, 10).until(
         //       ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='23']")));


        languageUsed.findElement(By.cssSelector("option[value='23']")).click();
        WebElement codeItButton = driver.findElement(By.cssSelector("input[name='submitbutton']"));
        codeItButton.click();
        Assert.assertEquals("23", driver.findElement(By.cssSelector("li[id='_valuelanguage_id']")).getText(),
                "23");


    }
}
