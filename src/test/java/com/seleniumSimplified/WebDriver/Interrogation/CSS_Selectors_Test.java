package com.seleniumSimplified.WebDriver.Interrogation;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selectors_Test {

    public static WebDriver driver;
    public static String myUrl = "https://compendiumdev.co.uk/selenium/find_by_playground.php";

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get(myUrl);
    }

    @Test
    public void getByIdNormal()
    {
        WebElement e = driver.findElement(By.cssSelector("#p31"));
        Assert.assertEquals("pName", "pName31" ,e.getAttribute("name") );
    }

    @Test
    public void getByNameNormal()
    {
        WebElement e = driver.findElement(By.cssSelector("[name='ulName1']"));
        Assert.assertEquals("ul1", "ul1", e.getAttribute("id"));
    }

    @Test
    public void getByClassNameNormal()
    {
        WebElement e = driver.findElement(By.cssSelector(".specialDiv"));
        Assert.assertEquals("div1", "div1", e.getAttribute("id"));
    }

    @Test
    public void getByTagNameNormal()
    {
        WebElement e = driver.findElement(By.cssSelector("li"));
        Assert.assertEquals("liName1", "liName1", e.getAttribute("name"));
    }
    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

}
