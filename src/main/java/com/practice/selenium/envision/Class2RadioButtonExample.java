package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class2RadioButtonExample {



    WebDriver driver;
    String URL = "https://demoqa.com/radio-button";

    @BeforeMethod
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test

    public void testRadioButtonClick() throws Exception{
        driver.get(URL);
        Thread.sleep(3000);
        radioButton("yes");
        Thread.sleep(3000) ;

    }
    public String radioButton(String option) throws InterruptedException {

        WebElement radioBtn = driver.findElement(By.xpath("//label[@for='"+ option + "Radio']"));
        radioBtn.click();
        return null;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();

    }

}