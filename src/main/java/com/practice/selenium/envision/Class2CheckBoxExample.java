package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class2CheckBoxExample {


    WebDriver driver;
    String URL = "https://demoqa.com/checkbox";

    @BeforeMethod
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);
        WebElement chkbox_Home = driver.findElement(By.xpath("//span[@class = 'rct-title' and text() = 'Home' ]"));
        chkbox_Home.click();
        Thread.sleep(3000);
////span[@class = 'rct-title' and text() = 'Home']/preceding-sibling::span[@class = 'rct-checkbox']
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();

    }
}