package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Class5AlertsHandling extends POMBaseTest {


    @Test
    public void handleAlert() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#alertButton")).click(); //(#) --> is used to find an element by Id
//        driver.findElement(By.cssSelector(".btn btn-primary")); //(.) --> is used to find an element by class
        Thread.sleep(3000);

        //To switch focus from webpage to an alert

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);

        //selecting next element

        driver.findElement(By.cssSelector("#confirmButton")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#promtButton")).click();
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("Tarun");
        alert.accept();
        Thread.sleep(3000);

    }
}