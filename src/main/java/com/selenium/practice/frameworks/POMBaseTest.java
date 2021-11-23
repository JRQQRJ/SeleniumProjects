package com.selenium.practice.frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class POMBaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);



    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
    }



}
