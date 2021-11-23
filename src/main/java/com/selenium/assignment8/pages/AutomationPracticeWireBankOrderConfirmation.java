package com.selenium.assignment8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeWireBankOrderConfirmation {

    WebDriver driver;

    @FindBy(xpath= "//button[@class= 'button btn btn-default button-medium']")
    WebElement btn_IConfirmMyOrder;

    public AutomationPracticeWireBankOrderConfirmation(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickIConfirmMyOrder() throws InterruptedException {
        btn_IConfirmMyOrder.click();
        Thread.sleep(3000);
           }

}


