package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeShipping {

    WebDriver driver;
    String shippingCharge;
    Float  price;

    @FindBy(xpath= "//input[@id=\"cgv\"]")
    WebElement checkboxTermsAndConditions;

    @FindBy(xpath= "//div[@class ='delivery_option_price' ]")
    WebElement shippingPrice;

    @FindBy(xpath= "//button[@name = 'processCarrier']")
    WebElement btn_proceedToCheckout;


    public AutomationPracticeShipping(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickTermsAndServiceCheckBox() throws InterruptedException {
        checkboxTermsAndConditions.click();
        Thread.sleep(3000);
           }

    public void compareShippingTotalPriceAndCheckOut() throws InterruptedException {
        shippingCharge = shippingPrice.getText();
        price= Float.valueOf(shippingCharge.substring(1,4));
        if(price<5){
        btn_proceedToCheckout.click();
        }
    }



}


