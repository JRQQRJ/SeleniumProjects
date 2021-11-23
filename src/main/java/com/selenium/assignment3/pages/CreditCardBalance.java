package com.selenium.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardBalance {

    WebDriver driverx;

    @FindBy(xpath = "//*[@id=\"card_nmuber\"]")
    WebElement tbx_CCN;

    @FindBy(xpath = "//*[@id=\"three\"]/div/form/div/div[6]/input")
    WebElement clk_sumbit;

    public CreditCardBalance(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }

    public void enterCCNAndSumit(String CNN){
        tbx_CCN.sendKeys(CNN);
        clk_sumbit.click();
    }

}
