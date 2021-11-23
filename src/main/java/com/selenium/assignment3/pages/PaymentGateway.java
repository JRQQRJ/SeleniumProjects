package com.selenium.assignment3.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PaymentGateway {

    public String URL = "http://demo.guru99.com/payment-gateway/index.php";

    WebDriver driverx;

    @FindBy(xpath = "//nav[@id='nav']//child::a[2]")
    public WebElement generateCardNumber ;

    public PaymentGateway(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }

    public String launchPaymentGateway() throws InterruptedException {
        driverx.get(URL);
        String URL = driverx.getCurrentUrl();
        Thread.sleep(3000);
        return URL;
    }

    public void  clickGenerateCardNumber() throws InterruptedException {
        generateCardNumber.click();
        String currentWindows = String.valueOf(driverx.getWindowHandles());
        List<String> arrayOfWindow = new ArrayList<>(driverx.getWindowHandles());
        driverx.switchTo().window(arrayOfWindow.get(1));
    }

}
