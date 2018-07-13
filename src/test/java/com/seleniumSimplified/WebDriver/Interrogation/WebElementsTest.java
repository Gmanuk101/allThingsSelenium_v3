package com.seleniumSimplified.WebDriver.Interrogation;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public class WebElementsTest {

    public static String thisUrl = "https://compendiumdev.co.uk/selenium/find_by_playground.php";
    public static WebDriver driver;

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get(thisUrl);
    }

    @Test
    public void returnDivElements()
    {
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        Assert.assertEquals("19 div elements", 19, divs.size());

    }

    @Test
    public void returnAnchorTagHrefToPara()
    {
        List<WebElement> anch = driver.findElements(By.partialLinkText("jump to para"));
        Assert.assertEquals("25", 25, anch.size());
    }

    @Test
    public void numberOfNested()
    {
       List<WebElement> nested = driver.findElements(By.tagName("p"));
       int count = 0;
       for(WebElement e : nested)
       {
           if(e.getText().contains("nested")){
               count++;
           }
       }
       Assert.assertEquals("16", 16, count);
       Assert.assertEquals("41", 41, nested.size());
    }

    @Test
    public void messingByChained()
    {
       WebElement ele;
       ele  = driver.findElement(new ByIdOrName("p3"));
        System.out.println(ele.getSize());
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
