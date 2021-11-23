package com.selenium.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreditCardSummary {

    WebDriver driverx;

    @FindBy(xpath = "//*[@id=\"three\"]/div/div/h4/span")
    WebElement balance;

    @FindBy(xpath = " //*[@id=\"three\"]/div/div/table/tbody/tr/td[6]/b/font")
    WebElement orderId;


    public CreditCardSummary(WebDriver driverx) {
        this.driverx = driverx;
        PageFactory.initElements(driverx, this);
    }

    public int creditCardCurrentBalance() {
        String b = balance.getText();
        int ba = Integer.valueOf(b);
        return ba;
    }

    public void orderId() {
        Assert.assertTrue(orderId.isDisplayed());
    }
}


