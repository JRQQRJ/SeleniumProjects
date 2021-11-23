package com.selenium.practice.frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class FrameworkClass1BaseTest {

    public WebDriver driver;
    FrameworkClass1BaseUtils baseUtils;

    @BeforeSuite
    public void setUpConfigration() throws Exception{
        FrameworkClass1PropertiesLoader.initializeProperties();
        FrameworkClass1PropertiesLoader.validateConfigration();
    }

    @BeforeMethod
    public WebDriver setUP() throws InterruptedException {

       baseUtils= new FrameworkClass1BaseUtils(driver);
       driver =baseUtils.launchBrowser(FrameworkClass1PropertiesLoader.runOnBrowser);
       return driver;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        baseUtils.closeBrowser(driver);
    }

    @AfterSuite
    public void tearDownObjects() throws  Exception{
        FrameworkClass1PropertiesLoader.configProperties = null;
        baseUtils =null;
    }

}
