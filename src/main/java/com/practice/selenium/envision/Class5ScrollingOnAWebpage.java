package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Class5ScrollingOnAWebpage extends POMBaseTest {


    @Test
    public void testScrollDown() throws InterruptedException {
        driver.get("https://www.saucedemo.com/inventory.html");

        JavascriptExecutor jse = (JavascriptExecutor) driver;// converts driver into javaScriptExecutor type
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);
    }

        public void testScrollUp () throws InterruptedException {
            driver.get("https://www.saucedemo.com/inventory.html");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
            Thread.sleep(3000);
        }

        public void scrollToElement () throws InterruptedException {

            driver.get("https://www.saucedemo.com/inventory.html");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement elementArea = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
            jse.executeScript("arguments[0].scrollIntoView(true);", elementArea); // fetches the bottom end of the perticular element
            Thread.sleep(3000);//hence the page view changes depending on what view we are at

            jse.executeScript("arguments[0].scrollIntoView(false);", elementArea); // fetches the top end of the perticular element
            Thread.sleep(3000);//hence the page view does not change


        }
    }