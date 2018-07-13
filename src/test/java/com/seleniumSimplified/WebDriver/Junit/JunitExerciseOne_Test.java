package com.seleniumSimplified.WebDriver.Junit;

/*
create test with assertTrue, assertFalse, assertEquals
use @Before to assign value to a field and use it in a test
use @BeforeClass to assign value to a field and use it in a test
attempt to use assertThat

 */

import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class JunitExerciseOne_Test {

    static int beforeClassVarible = 0;
    int beforeMethodVariable = 0;

    @BeforeClass
    public static void assignNumberToBeforeClass() {
        beforeClassVarible = 2;
        System.out.println("BeforeClass Variable = "+beforeClassVarible);
    }

    @Before
    public void beforeMethod() {
        int changed = beforeMethodVariable + 2;
    }

    @Test
    public void testVariableChangedPartOne()
    {
        beforeClassVarible = 10;
        Assert.assertTrue("10", true);
        System.out.println("Changed BeforeClass Variable = "+beforeClassVarible);
    }

    @Test
    public void testVarIsNowOneHundred()
    {
        beforeMethodVariable = 100;
        Assert.assertFalse("Is now 100", false);
        System.out.println("Before Method Variable now = "+beforeMethodVariable);
    }

    @Test
    public void testVarIsNowTwoHundred()
    {
        beforeMethodVariable = beforeMethodVariable + 200;
        Assert.assertEquals("zero + 200 = 200", 200, beforeMethodVariable);
        System.out.println("value should be 200, is actually = "+beforeMethodVariable);
    }

    @Test
    public void useAssertThat()
    {
        int assertThatVar = beforeMethodVariable + 99;
        Assert.assertThat(assertThatVar, is(not(999)));

    }

    @After
    public void afterMethod() {
        beforeMethodVariable = 0;
        System.out.println("Reset Before Method Variable = "+beforeMethodVariable);
    }


    @AfterClass
    public static void resetNumberAfterClass() {
        beforeClassVarible = 0;
        System.out.println("AfterClass Variable = "+beforeClassVarible);
    }


}
