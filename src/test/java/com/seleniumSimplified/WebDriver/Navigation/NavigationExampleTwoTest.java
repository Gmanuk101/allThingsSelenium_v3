package com.seleniumSimplified.WebDriver.Navigation;
/*
use:  navigate.to(), forward(), back(), refresh() methods
assert on titles
url = http//compendiumdev.co.uk
url = protocol (http), domain ( the .co.uk bit) , path (any slashes after domain),
path 1 - /selenium
path 2 = /selenum/search.php
path3 =  /selenium./basic_html_form.html
path4 =  /selenium/basic_web_page.html
path5 = /selenium/refresh.php

 */

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationExampleTwoTest {

    private static String protocal = "HTTP://";
    private static String domain = "www.compendiumdev.co.uk";
    private static WebDriver driver;

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void navToSelSimpCheckTitle()
    {
        driver.navigate().to(protocal+domain+"/selenium");
        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void navToSearch()
    {
        driver.navigate().to(protocal+domain+"/selenium/search.php");
        Assert.assertEquals("Selenium Simplified Search Engine", driver.getTitle());
    }

    @Test
    public void checkHtmlForm()
    {
        driver.navigate().to(protocal+domain+"/selenium/basic_html_form.html");
        Assert.assertTrue("HTML Form Elements", true);

    }

    @Test
    public void checkBasicWebPage()
    {
        driver.navigate().to(protocal+domain+"/selenium/basic_web_page.html");
        Assert.assertTrue("Basic Web Page", true);
    }

    @Test
    public void refreshTest()
    {
        driver.navigate().to(protocal+domain+"/selenium/refresh.php");
        String initialTitle = driver.getTitle();
        driver.navigate().refresh();
        String afterRefresh = driver.getTitle();

        if(initialTitle == afterRefresh)
        {
            System.out.println("Test Failed");
        }else
            System.out.println("Test Passed");
    }


    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

}
