package com.selenium.assignment6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionDetails {

    WebDriver driver;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/table/tbody/tr[1]/td[2]")
    WebElement selectTransactionId;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/table/tbody/tr[2]/td[2]")
    WebElement selectTransactionDate;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/table/tbody/tr[3]/td[2]")
    WebElement selectTransactionDescription;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/table/tbody/tr[4]/td[2]")
    WebElement selectTransactionType;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/table/tbody/tr[5]/td[2]")
    WebElement selectTransactionAmount;

    @FindBy(xpath= "//div[@id=\"leftPanel\"]/ul/li[5]/a")
    WebElement clickFindTransaction;

    @FindBy(xpath= "//div[@id=\"leftPanel\"]/ul/li[5]/a")
    WebElement currentURl;


    public TransactionDetails(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String fetchTransactionId(){
    return selectTransactionId.getText();
    }

    public String fetchTransactionDate(){
        return selectTransactionDate.getText();
    }

    public String fetchTransactionDescription(){
        return selectTransactionDescription.getText();
    }

    public String fetchTransactionType(){
        return selectTransactionType.getText();
    }

    public String fetchTransactionAmount(){
        return selectTransactionAmount.getText();
    }

    public void clickFindTransactionPage(){
        clickFindTransaction.click();
    }

    public String getCurrentURl(){
      return driver.getCurrentUrl();
    }


}
