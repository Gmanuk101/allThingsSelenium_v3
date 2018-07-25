package com.seleniumSimplified.WebDriver.Windows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class WindowsTest {

    @Test
    public void switchToNewWindow() {
    WebDriver driver = new ChromeDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");

        driver.findElement(By.cssSelector("a[href=\'http://www.seleniumsimplified.com']")).click();

        String newWindowHandle = framesWindowHandle;

        Iterator<String> aHandle = driver.getWindowHandles().iterator();
        while(newWindowHandle.equals(framesWindowHandle)){
            newWindowHandle = aHandle.next();
        }

         driver.switchTo().window(newWindowHandle);

        assertTrue("Expected Selenium Simplified site",

                driver.getTitle().contains("Selenium Simplified"));

    }

}