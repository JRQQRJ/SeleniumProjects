package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticePayment {

    WebDriver driver;
    String shippingCharge;
    Float  price;

    @FindBy(xpath= "//a[@title= 'Pay by bank wire']")
    WebElement link_PayByBankWire;

    public AutomationPracticePayment(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickLink_PayByBankWire() throws InterruptedException {
        link_PayByBankWire.click();
        Thread.sleep(3000);
           }

}


