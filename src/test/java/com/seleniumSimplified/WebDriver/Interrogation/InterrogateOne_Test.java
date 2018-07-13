package com.seleniumSimplified.WebDriver.Interrogation;

/*
nav to compendiumdev.co.uk/selenium/basic_web_page.html
assert title = basic web page
assert current url is "Basic Web Page Title
check Page source contains "A paragraph of text"
 */

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class InterrogateOne_Test {

    private static WebDriver driver;
    private static String myURL = "http://compendiumdev.co.uk/selenium/basic_web_page.html";

    @BeforeClass
    public static void startBrowser()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void mainTest()
    {
        driver.navigate().to(myURL);
        Assert.assertThat(driver.getTitle(), is("Basic Web Page Title"));
        Assert.assertThat(driver.getCurrentUrl(), is(myURL));
        Assert.assertThat(driver.getPageSource(), containsString("A paragraph of text"));
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
