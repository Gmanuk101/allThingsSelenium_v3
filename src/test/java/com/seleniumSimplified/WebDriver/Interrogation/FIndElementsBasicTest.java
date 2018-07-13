package com.seleniumSimplified.WebDriver.Interrogation;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FIndElementsBasicTest {

    final String myURL = "https://compendiumdev.co.uk/selenium/find_by_playground.php";
    private static WebDriver driver;

    /*
    by id, by linkText, byName, byPartialLinkText, byClassName
     */
    @BeforeClass
    public static void startDriver() {
        driver = new ChromeDriver();
    }

    @Before
    public void gotoWebPage() {
        driver.get(myURL);
    }

    @Test
    public void findById()
    {
        WebElement id = driver.findElement(By.id("p1"));
        Assert.assertEquals("This is a paragraph text", id.getText());
    }

    @Test
    public void findByLinkText()
    {
        WebElement linkText = driver.findElement(By.linkText("jump to para 10"));
        Assert.assertEquals(linkText.getText(), "jump to para 10");
    }

    @Test
    public void findByName()
    {
        WebElement byName  = driver.findElement(By.name("preName1"));
        Assert.assertEquals("within div of multiple class styles", byName.getText());
    }

    @Test
    public void byPartialLinkText()
    {
        WebElement part = driver.findElement(By.partialLinkText("jump"));
        Assert.assertEquals("jump to para 0", part.getText());
        part = null;
        part = driver.findElement(By.partialLinkText("to"));
        Assert.assertEquals("jump to para 0", part.getText());
        part = null;
        part = driver.findElement(By.partialLinkText("6"));
        Assert.assertEquals("jump to para 6", part.getText());
    }
    @After
    public void tearDownAfterEachTestMethod() {
        driver.quit();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
