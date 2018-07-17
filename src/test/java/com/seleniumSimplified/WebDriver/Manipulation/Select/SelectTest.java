package com.seleniumSimplified.WebDriver.Manipulation.Select;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class SelectTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");


    }

    @Test
    public void subFormAssertTitle() {
        WebElement submitButton = driver
                .findElement(By.cssSelector("[type='submit'][value='submit']"));
        String oldTItle = driver.getTitle();
        submitButton.click();
        String newTitle = driver.getTitle();
        if (oldTItle.equals(newTitle)) {
            System.out.println("titles are the same");
        } else {
            System.out.println("titles are different");
        }


    }//Submit form and assert page title changes

    @Test
    public void submitMultiSelectionMenu() {
        WebElement multiGrp = driver.findElement(By.cssSelector("select[multiple]"));
        Select selMultiGrp = new Select(multiGrp);
        selMultiGrp.selectByIndex(0);
        selMultiGrp.selectByIndex(1);
        selMultiGrp.selectByIndex(2);
        selMultiGrp.deselectByIndex(3);
        clickSubmitButton();
    }

    @Test
    public void formDd5Selected()
    {
        Select ddGroup = new Select(driver.findElement(By.cssSelector("select[name='dropdown']")));

        ddGroup.selectByIndex(4);
        clickSubmitButton();

    }//Submit form with drop down item 5 selected

    @Test
    public void getFileName() throws URISyntaxException
    {
        WebElement fileButton = driver.findElement(By.cssSelector("input[type='file']"));
        //find the element
        //instatiate new file
        //user getClass and Get resource
        File testFile = new File
                (this.getClass().getResource("/barclay.txt  ").toURI());

        fileButton.sendKeys(testFile.getAbsolutePath());
        clickSubmitButton();


    }

    private void clickSubmitButton() {

        WebElement submitButton = driver
                .findElement(By.cssSelector("[type='submit'][value='submit']"));
        submitButton.click();
    }

}//Submit form with multiple select 1, 2 & 3

   /* @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }






Bonus points, submit with a file, and check name on output
 */
