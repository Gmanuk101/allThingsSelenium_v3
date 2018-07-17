package com.seleniumSimplified.WebDriver.UserInteractions;

import org.junit.AfterClass;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/*
Using: http://compendiumdev.co.uk/selenium/gui_user_interactions.html





Optional Challenges:
Can you draw something in the canvas?
Control+Space and red squares say “Let GO!!” can you assert for this?
 */



public class UserInteractionTest {

    private static WebDriver driver;
    private WebElement dragMe1Yellow = driver.findElement
            (By.cssSelector("div[id='draggable1']"));

    private WebElement dragMe2Yellow = driver.findElement(By.cssSelector("div[id='draggable2']"));
    private WebElement drop1Red = driver.findElement(By.cssSelector("div[id='droppable1']"));
    private WebElement drop2Red = driver.findElement(By.cssSelector("div[id='droppable2']"));
    private WebElement canv = driver.findElement(By.cssSelector("canvas[id='canvas']"));


    @Test
    public void moveDrag1onToDrop1()//drag 1 onto drop 1
    {
        Actions act = new Actions(driver);
        act.dragAndDrop(dragMe1Yellow, drop1Red).build().perform();
        Assert.assertEquals("Dropped!", drop1Red.getText());


    }
    @Test //Drag and Drop draggable2 to droppable1 Assert droppable 1 text change to “Get Off Me!”
    public void drag2ToDrop1()
    {

        Actions act1 = new Actions(driver);
        act1.dragAndDrop(dragMe2Yellow, drop1Red).build().perform();
        Assert.assertEquals("Get Off Me!", drop1Red.getText());

    }

    @Test //Press control+B and assert for text change on draggable1 to “Bwa! Ha! Ha!”
    public void controlB()
    {
        Actions cnt = new Actions(driver);
        cnt.keyDown(Keys.CONTROL).sendKeys(Keys.chord("B")).build().perform();
        Assert.assertEquals("Bwa! Ha! Ha!", dragMe1Yellow.getText());

    }

    @Test //Can you draw something in the canvas?
    public void drawShit()
    {
        //driver.findElement(By.tagName("html")).click();
        Actions act = new Actions(driver);

        act.moveToElement(canv, 8,8);
        act.clickAndHold(canv);
        act.moveByOffset(120, 120)
                .moveByOffset(60,70)
                .moveByOffset(-140,-140);
        act.release(canv);
        act.perform();


    }

    @BeforeClass
    public static void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/gui_user_interactions.html");
       // driver.findElement(By.tagName("html")).click();
    }


    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
