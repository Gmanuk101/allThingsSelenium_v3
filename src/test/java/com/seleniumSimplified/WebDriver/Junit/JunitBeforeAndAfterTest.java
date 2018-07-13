package com.seleniumSimplified.WebDriver.Junit;

import org.junit.*;

public class JunitBeforeAndAfterTest {

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("BEFORE CLASS");
    }

    @Before
    public void beforeTest()
    {
        System.out.println("This prints BEFORE");
    }

    @Test
    public void this1Test()
    {
        System.out.println("This is 1 test");
    }

    @Test
    public void this2Test()
    {
        System.out.println("this is 2 test");
    }

    @Test
    public void this3Test()
    {
        System.out.println("this is 3 test");
    }

    @After
    public void thisPrintsAfter()
    {
        System.out.println("this prints AFTER");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("AFTER CLASS");
    }
}
