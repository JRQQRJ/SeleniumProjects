package com.selenium.assignment6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverview {

    WebDriver driver;

    @FindBy(xpath= "//table[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    WebElement accountNumber;

    @FindBy(xpath= "//table[@id=\"accountTable\"]/tbody/tr[2]/td[2]/b")
    WebElement accountBalance;

    @FindBy(xpath= "//div[@id=\"leftPanel\"]/ul/li[4]/a")
    WebElement clickBillPay;

    @FindBy(xpath= "//div[@id=\"leftPanel\"]/ul/li[5]/a")
    WebElement clickFindTransaction;

    @FindBy(xpath= "//table[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    WebElement clickOnAccountNumber;

    public AccountsOverview(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public int fetchAccountNumber(){
      String accountNum = accountNumber.getText();
      int accountNumber = Integer.valueOf(accountNum);
      return accountNumber;
    }

    public double fetchAccountBalance(){
        String amountOverview =accountBalance.getText();
        String amount =amountOverview.substring(1,6);
        double accountBalance = Double.valueOf(amount);
        return accountBalance;
    }

    public void setClickBillPay() throws InterruptedException {
        clickBillPay.click();
        Thread.sleep(3000);
    }

    public void clickFindTransaction() throws InterruptedException {
        clickFindTransaction.click();
        Thread.sleep(3000);
    }
    public void clickOnAccount() throws InterruptedException {
        clickOnAccountNumber.click();
        Thread.sleep(3000);
    }

}
