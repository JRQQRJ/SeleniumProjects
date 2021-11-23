package com.selenium.assignment6.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionResultPage {

    WebDriver driver;

    @FindBy(xpath= "//table[@id=\"transactionTable\"]/tbody/tr/td[2]/a")
    WebElement transaction;

    public TransactionResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String transactionOnPage(){
    String transactionRecord = transaction.getText();
    return transactionRecord;
    }

    public void clickTransactionOnPage(){
    transaction.click();
    }

}
