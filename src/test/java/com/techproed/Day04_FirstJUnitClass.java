package com.techproed;

import org.junit.*;

public class Day04_FirstJUnitClass {
    //ANNOTATIONS: @Test, @Before, @After, @Ignore
    //We no longer need MAIN METHOD
    //@Test creates a test case
    //@Ignore skips test case
    //setUp -> tearDown -> test 1 -> test2(SKIPPED) -> test 3
    //@after runs after each method
    //@Before runs before each method
    @Before
    public void setup(){
        System.out.println("@Before runs before each @Test method");
    }

    @Test
    public void test01(){
        System.out.println("Test Case 1");
    }

    @Test
    public void test02(){
        System.out.println("Test Case 2");
    }
    @Test
    public void test03(){
        System.out.println("Test Case 3");
    }
    @After
    public void teardown(){
        System.out.println("@After runs after each @Test method");
    }

    //ASSERTIONS: If expected = actual

    //assertion()
    @Test
    public void assertion(){
        //1. Assert.assertTrue(Statement); if statement = True, then PASS, otherwuse FAIL
        //2. Assert.assertFalse(); if statement = false, then PASS, otherwise FAIL
        Assert.assertTrue(3==3);//PASS
        Assert.assertFalse(3==4);//PASS
        Assert.assertTrue("junit".contains("j"));
        //3. Assert.assertEquals("expected","actual"); if expected = actual, then PASS, otherwise FAIL
        Assert.assertEquals("junit","junit");
    }

}
