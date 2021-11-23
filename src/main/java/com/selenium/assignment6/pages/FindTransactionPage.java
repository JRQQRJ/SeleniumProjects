package com.selenium.assignment6.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionPage {

    WebDriver driver;

    @FindBy(xpath= "//input[@id=\"criteria.fromDate\"]")
    WebElement tbx_FromDate;

    @FindBy(xpath= "//input[@id=\"criteria.toDate\"]")
    WebElement tbx_ToDate;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div/form/div[7]/button")
    WebElement btn_FindTransactions;

    public FindTransactionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void enterBeforeAndAfterDateAndSearch(String BDate,String ADate){
        tbx_FromDate.sendKeys(BDate);
        tbx_ToDate.sendKeys(ADate);
        btn_FindTransactions.click();
    }



}
