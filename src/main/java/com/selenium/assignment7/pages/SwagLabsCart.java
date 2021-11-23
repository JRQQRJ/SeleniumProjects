package com.selenium.assignment7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwagLabsCart {

        WebDriver driver;

        String checkpoint1Value,Checkpoint2Value;

        @FindBy(css = "#checkout")
        WebElement btn_CheckOut;

         public SwagLabsCart(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void checkPoint3() {
            Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"));
            Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Fleece Jacket"));
        }

    public void checkOut() {
            btn_CheckOut.click();
    }


    }


