package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Class2DatePicker {


    WebDriver driver;
    String URL = "https://demoqa.com/date-picker";

    @BeforeMethod
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Binaries\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test

    public void datePicker() throws Exception{

        LocalDateTime dateTime = LocalDateTime.now();
        String day = String.valueOf(dateTime.getDayOfMonth()+5);
        String month = String.valueOf(dateTime.getMonth());
        String year = String.valueOf(dateTime.getYear()+1);
        String formattedMonth = month.substring(0,1)+ month.substring(1).toLowerCase(Locale.ROOT);

        driver.get(URL);
        Thread.sleep(3000);
        WebElement dateTxt_Box = driver.findElement(By.id("datePickerMonthYearInput"));
        dateTxt_Box.click();
        Thread.sleep(3000) ;
        WebElement elementMonth = driver.findElement(By.className("react-datepicker__month-select"));
        WebElement elementYear = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectMonth = new Select(elementMonth);
        Select selectYear = new Select(elementYear );
        selectMonth.selectByVisibleText(formattedMonth);
        selectYear.selectByVisibleText(year);
        Thread.sleep(3000) ;
        ////div[contains(@class , 'react-datepicker__day react-datepicker__day')]
        clickDayOfMonth(day);
        Thread.sleep(3000) ;
    }

    public void clickDayOfMonth(String day) throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class , 'react-datepicker__day react-datepicker__day--') and not(contains(@class, 'outside')) ] "));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase(day)) {
                elements.get(i).click();
                Thread.sleep(3000);
                break;
            }

        }
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();

    }

}