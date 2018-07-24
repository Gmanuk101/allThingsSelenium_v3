package com.seleniumSimplified.WebDriver.Windows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class WindowsTest {

    @Test
    public void switchToNewWindow() {
    WebDriver driver = new ChromeDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());

        driver.switchTo().frame("content");

        driver.findElement(By.cssSelector("a[href=\'http://www.seleniumsimplified.com']")).click();

        assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());

        Set <String> myWindows = driver.getWindowHandles();

        String newWindowHandle ="";

        for (String aHandle : myWindows) {

            if (!framesWindowHandle.contentEquals(aHandle)) {

                newWindowHandle = aHandle;
                break;

            }

        }

        driver.switchTo().window(newWindowHandle);

        assertTrue("Expected Selenium Simplified site",

                driver.getTitle().contains("Selenium Simplified"));

    }

}