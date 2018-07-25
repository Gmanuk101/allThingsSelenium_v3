package com.seleniumSimplified.WebDriver.Windows;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Dim;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowDimensionsTest {

    static WebDriver driver;
    public static String thisUrl = "http://www.compendiumdev.co.uk/selenium/bounce.html";

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get(thisUrl);

    }

    @Test
    public void randomPositionTest()
    {
        driver.manage().window().setPosition(new Point(10,20));
        Point pos = driver.manage().window().getPosition();
        Assert.assertEquals("10", 10, driver.manage().window().getPosition().getX());
        Assert.assertEquals("20", 20, driver.manage().window().getPosition().getY());
    }

    @Test
    public void anotherRandomPositionTest()
    {
        driver.manage().window().setSize(new Dimension(400,650));
        Dimension dim = driver.manage().window().getSize();
        Assert.assertEquals("400", 400, driver.manage().window().getSize().getWidth());
        Assert.assertEquals("650", 650, driver.manage().window().getSize().getHeight());
    }
/*
max window
reduce to half full
move reduced window to centre screen
make it smaller and bounce it around
 */

    @Test
    public void variousPlaying()
    {

         driver.manage().window().maximize();
         Dimension fullscreen = driver.manage().window().getSize();
         driver.manage().window().
                 setSize(new Dimension(fullscreen.getWidth()/2, fullscreen.getHeight()/2));






    }
}
