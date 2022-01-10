package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeCartSummary {

    WebDriver driver;
    String cartPrice;
    Float  price;

    @FindBy(xpath= "//span[@id=\"total_price\"]")
    WebElement cartTotalPrice;

    @FindBy(xpath= "//div[@id=\"center_column\"]/p[2]/a[1]")
    WebElement btn_proceedToCheckOut;

    @FindBy(xpath= "//button[@name = 'processAddress']")
    WebElement btn_proceedToCheckoutAddress;


    public AutomationPracticeCartSummary(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void fetchAndDisplayCartTotalPrice() throws InterruptedException {
        cartPrice = cartTotalPrice.getText();
        price = Float.valueOf(cartPrice.substring(1,5));
           }

    public void compareCartTotalPriceAndCheckOut() throws InterruptedException {
        if(price<20){
            btn_proceedToCheckOut.click();
            btn_proceedToCheckoutAddress.click();

        }
    }



}


