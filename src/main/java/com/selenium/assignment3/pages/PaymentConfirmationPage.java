package com.selenium.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentConfirmationPage {

    WebDriver driverx;

    @FindBy(xpath = "//div[@class = 'table-wrapper']/h2")
    WebElement msg;

    @FindBy(xpath = "//*[@id=\"three\"]/div/div/table/tbody/tr[1]/td[2]/h3/strong")
    WebElement orderId ;

    @FindBy(xpath = " //*[@id=\"nav\"]/a[3]")
    WebElement clickCheckCreditCardLimit ;

    public PaymentConfirmationPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }

    public void displayMsgCheck()
    {
        String msg = this.msg.getText();
        Assert.assertEquals(msg, "Payment successfull!", "Payment not successful");
    }

    public String fetchOrderID(){
        String orderId= this.orderId.getText();
        return orderId;
    }

    public void clickCheckCreditCardLimit(){
        clickCheckCreditCardLimit.click();
    }

    }
