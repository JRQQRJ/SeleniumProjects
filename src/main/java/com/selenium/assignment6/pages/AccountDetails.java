package com.selenium.assignment6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetails {

    WebDriver driver;

    @FindBy(xpath= "//table[@id=\"transactionTable\"]/tbody/tr[1]/td[2]/a")
    WebElement selectTransaction;


    public AccountDetails(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void fetchTransaction(){
selectTransaction.click();
    }

}
