package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Class2DatePickerUsingKeyboardActions {

    WebDriver driver;
    String URL = "https://demoqa.com/date-picker";

    @BeforeMethod
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test

    public void datePicker() throws Exception{

        driver.get(URL);
        Thread.sleep(3000);
        WebElement dateTxt_Box = driver.findElement(By.id("datePickerMonthYearInput"));
        dateTxt_Box.click();
        Thread.sleep(3000) ;
        Actions actions =new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a");
        Thread.sleep(3000) ;
        actions.sendKeys(Keys.BACK_SPACE);
        actions.keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(3000) ;
        actions.sendKeys("10/31/2021").sendKeys(Keys.ENTER).build().perform();
    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();

    }

}
