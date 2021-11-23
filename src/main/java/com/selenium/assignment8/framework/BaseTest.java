package com.selenium.assignment8.framework;

import com.selenium.assignment8.framework.BaseUtils;
import com.selenium.assignment8.framework.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    BaseUtils baseUtils;

    @BeforeSuite
    public void setUpConfigration() throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesLoader.validateConfigration();
    }

    @BeforeMethod
    public WebDriver setUP() throws InterruptedException {

       baseUtils= new BaseUtils(driver);
       driver =baseUtils.launchBrowser(PropertiesLoader.runOnBrowser);
       return driver;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        baseUtils.closeBrowser(driver);
    }

    @AfterSuite
    public void tearDownObjects() throws  Exception{

        PropertiesLoader.configProperties = null;
        baseUtils =null;


    }

}
