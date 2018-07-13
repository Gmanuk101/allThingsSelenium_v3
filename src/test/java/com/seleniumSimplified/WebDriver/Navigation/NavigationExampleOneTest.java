package com.seleniumSimplified.WebDriver.Navigation;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationExampleOneTest {

    private static WebDriver driver;

    @BeforeClass
    public static void startBrowser()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void gotoPage()
    {
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/search.php");
        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
