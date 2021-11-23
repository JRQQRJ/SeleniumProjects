package com.practice.selenium.envision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1BasicsAndGoogleAutomation{

    WebDriver driver;
    String URL;

    //------------------------------------------------------------------------------------------------------------



    @BeforeMethod // annotation are special comments/ instructions for compilers to understand the flow of code
    public void setUP() throws InterruptedException {
    // setup property for exe
        // System.setProperty( "webdriver.chrome.driver","/path/to/chromedriver");
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }


    // -----------------------------------------------------------------------------------------------------------



    @Test // annotation lets compiler understand this is test and lets us run the test
    public void testSomething() throws InterruptedException {
        URL = "https://www.google.ca/";
        //driver.get(URL);
        driver.navigate().to(URL); // CAN TAKE USTO  NEXT AND PREVIOUS PAGE , REFRESH AS WELL
        Thread.sleep(2000); // --> WAY 1
        String title = driver.getTitle();
        System.out.println("Title is : "+ title);
        Assert.assertEquals(title,"Google");
        Assert.assertEquals(title,"Amazon",  "Validation Failed");
        Assert.assertTrue(title.equalsIgnoreCase("google"));

        String currentURrl = driver.getCurrentUrl();
        System.out.println("Current URL :" + currentURrl);
        Assert.assertTrue(URL.contains("google"));

        String pageSource = driver.getPageSource();
        System.out.println("Page Source :"+ pageSource);
        Thread.sleep(2000);
//txtUsername

    }

    //------------------------------------------------------------------------------------------------------------
    @AfterMethod
    public void tearDown(){
        driver.close(); // closes single window
        //driver.quit(); --> closes all windows
    }


}
