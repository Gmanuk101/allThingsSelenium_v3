package com.seleniumSimplified.WebDriver.Frames;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPlayTest {

    private static String frameUrl = "http://compendiumdev.co.uk/selenium/frames/";
    private static WebDriver driver;


    @BeforeClass
    public static void start() //
    {
        driver = new ChromeDriver();
        driver.get(frameUrl);
    }

    @Test
    public void loadGreenPage()
    {
        //click content load greenpage
        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='green.html']")).click();
        driver.findElement(By.cssSelector("a[href='content.html']")).click();
        Assert.assertEquals("Content",driver.findElement(By.tagName("h1")).getText());
    }

    @Test
    public void iFrameTest() {
        //click on menu iFrames example
        //the example 5 in the iFrame
        //then content load main frames page
        driver.switchTo().frame("menu");
        driver.findElement(By.cssSelector("a[href*='iframe']")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("Example 5")).click();
        driver.switchTo().frame("content");
        driver.findElement(By.linkText("Load Main Frames Page")).click();
        driver.switchTo().frame("content");
        driver.findElement
                (By.xpath("//p[contains(text(),'Original page templates created by Quackit.com')]"));



    }

}
