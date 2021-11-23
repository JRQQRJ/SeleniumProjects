package com.selenium.assignment3.pages;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentProcessing {

    WebDriver driverx;

    @FindBy(xpath = "//input[@id='card_nmuber']")
    WebElement cN;

    @FindBy(xpath = "//input[@id='cvv_code']")
    WebElement cVV;

    @FindBy(xpath = "//select[@id='month']")
    WebElement month;

    @FindBy(xpath = "//select[@id='year']")
    WebElement year;


    @FindBy(xpath = "//font[@color='red']")
    WebElement amount;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement click_pay;


    public PaymentProcessing(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }


    public int checkDisplayAmount(){
        String s_totalAmount = amount.getText();
        System.out.println(s_totalAmount + " is charged from credit card");
        String amount = s_totalAmount.substring(1,3);
        int displayedAmount = Integer.valueOf(amount);
        return displayedAmount;
    }

    public void enterCardDetails(String cN,String cVV,String month,String year) throws InterruptedException {
        this.cN.sendKeys(cN);
        Thread.sleep(3000);
        this.cVV.sendKeys(cVV);
        Thread.sleep(3000);
        this.month.sendKeys(month);
        Thread.sleep(3000);
        this.year.sendKeys(year);
        Thread.sleep(3000);
    }

    public void clickPayBtn(){
        click_pay.click();
    }

}

