package com.selenium.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PurchaseToyPage {

    WebDriver driverx;

    @FindBy(xpath = "//select[@name='quantity']//child::option[4]")
    public WebElement clickToSelectQuanity ;

    @FindBy(xpath = "//input[@type= 'submit']")
    public WebElement clickBuy ;

    public PurchaseToyPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }



    public int selectQuantityAndClickBuy() throws InterruptedException {
        clickToSelectQuanity.click();
        int qty;
        qty = Integer.parseInt(clickToSelectQuanity.getText());
        System.out.println("You are about to purchase " + qty+ " (Mother Elephant With Babies Soft Toys)");
        clickBuy.click();
        System.out.println("Your purchase is successful");
        String currentWindows= String.valueOf(driverx.getWindowHandles());
        List<String> arrayOfWindow = new ArrayList<>(driverx.getWindowHandles());
        driverx.switchTo().window(arrayOfWindow.get(1));
        return qty;
    }


}
