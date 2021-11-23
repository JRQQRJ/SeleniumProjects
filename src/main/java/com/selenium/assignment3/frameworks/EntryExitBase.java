package com.selenium.assignment3.frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public class EntryExitBase {

        public WebDriver driverx;

        @BeforeMethod
        public void setUP() throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
            driverx = new ChromeDriver();
            driverx.manage().window().maximize();
            driverx.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driverx.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            driverx.quit();
        }

    }
