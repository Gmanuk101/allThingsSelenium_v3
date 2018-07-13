package com.seleniumSimplified.WebDriver.Junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitExampleTest
{

    @Test
    public void twoPlusTwoEqualsFour()
    {
        Assert.assertEquals("2+2=4", 4, 2+2);

    }
}
