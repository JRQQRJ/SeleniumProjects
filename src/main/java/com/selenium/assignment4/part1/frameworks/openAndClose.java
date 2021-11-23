package com.selenium.assignment4.part1.frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class openAndClose{

    public WebDriver driverx;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driverx = new ChromeDriver();
        driverx.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void shut(){
        driverx.close();

    }
}
