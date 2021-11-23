package com.practice.selenium.envision;

import org.testng.annotations.*;

public class Class1SeleniumAutomationBeforeDuringAfterTest {

    /*
    Manual test cases are divided into 3 parts.
    1. Pre-requisites
    2. Test execution
    3. Post-test activities

    The above is true for automation as well
     */
    @BeforeTest // --> annotations are special comments for java

    public void doSomethingBeforeTest(){
        System.out.println("This is before testing");
    }

    @BeforeMethod // --> annotations are special comments for java

    public void doSomethingBeforeTestMethods(){
        System.out.println("This is Method before testing");
    }
    @Test
    public void doTest(){
        System.out.println("This is during testing");
    }
    @Test
    public void doTest1(){
        System.out.println("This is during testing 2");
    }
    @AfterTest

    public void doSomethingAfterTest(){
        System.out.println("This is after testing");
    }
    @AfterMethod // --> annotations are special comments for java

    public void doSomethingAfterTestMethods(){
        System.out.println("This is  Method after testing");
    }

}


