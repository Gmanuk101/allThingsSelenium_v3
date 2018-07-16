package com.seleniumSimplified.WebDriver.Manipulation;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class SimpleFormChecking {

    private static WebDriver driver;

    public void clickSumbit()
    {
        driver.findElement(By.cssSelector("[value=submit")).click();
    }

    public void goBackToForm()
    {
        driver.findElement(By.id("back_to_form")).click();
    }

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormTitlePageChange()
    {
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();
        Assert.assertEquals("Processed Form Details","Processed " +
                "Form Details" , driver.getTitle());
        //then go back to form in a resetForm state
        goBackToForm();
        Assert.assertEquals("HTML Form Elements", "HTML Form Elements", driver.getTitle());

    }

    @Test
    public void clearTypeSumbitCheck()
    {

        WebElement test = driver.findElement(By.name("comments"));
        test.clear();
        test.sendKeys("this is a comment");
        clickSumbit();
         WebElement ele = driver.findElement(By.cssSelector("#_valuecomments"));
        Assert.assertEquals("this is a comment", "this is a comment",
                ele.getText());

    }

    @Test
    public void num2RadioButtonSelected()
    {
       // driver.findElement(By.id("back_to_form")).click();
        WebElement rd2 = driver.findElement(By.cssSelector("input[type='radio'][value='rd2']"));
        rd2.click();
        clickSumbit();
        WebElement checkRd2 = driver.findElement(By.id("_valueradioval"));
        Assert.assertEquals("rd2", "rd2", checkRd2.getText());
    }

    @Test
    public void subFormOneCheckBoxSelect()
    {
        WebElement check1 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb1']"));
        WebElement check2 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb2']"));
        WebElement check3 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb3']"));

        clickSumbit();
        WebElement checkBoxSelection = driver
                .findElement(By.xpath("//li[@id='_valuecheckboxes0']"));
        Assert.assertEquals("cb3", "cb3", checkBoxSelection.getText());

    }

    @Test
    public void selectNoFiveInDropDown()
    {
        WebElement dDown = driver.findElement(By.xpath("//select[@name='dropdown']"));
        dDown.click();
        WebElement dd5 = driver.findElement(By.xpath("//option[@value='dd5']"));
        dd5.click();
        clickSumbit();
        WebElement result = driver.findElement(By.cssSelector("#_valuedropdown"));
        Assert.assertEquals("dd5", "dd5", result.getText());
    }

    @Test
    public void multipleSelection()
    {
        //Submit form with multiple select 1, 2 & 3
        WebElement multiSelect = driver.findElement(By.cssSelector("select[multiple='multiple']"));
        List<WebElement> multiSelectOptions = driver.findElements(By.tagName("Option"));

        multiSelectOptions.get(0).click();
        multiSelectOptions.get(1).click();
        multiSelectOptions.get(2).click();
        if(multiSelectOptions.get(3).isSelected())
        {
            multiSelectOptions.get(3).click();
        }
        clickSumbit();
        Assert.assertEquals("ms1", driver.findElement(By.id("_valuemultipleselect0")).getText());
        Assert.assertEquals("ms2", driver.findElement(By.id("_valuemultipleselect1")).getText());
        Assert.assertEquals("ms3", driver.findElement(By.id("_valuemultipleselect2")).getText());




    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
}
