package com.selenium.assignment6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayment {

    WebDriver driver;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input")
    WebElement tbx_PayeeName;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input")
    WebElement tbx_Address;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input")
    WebElement tbx_City;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
    WebElement tbx_State;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[5]/td[2]/input")
    WebElement tbx_ZipCode;

    @FindBy(xpath= "//input[@name='payee.phoneNumber']")
    WebElement tbx_PhoneNumber;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[8]/td[2]/input")
    WebElement tbx_PayeeAccountNumber;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[2]/input")
    WebElement tbx_VerifyPayeeAccountNumber;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[11]/td[2]/input")
    WebElement tbx_Amount;

    @FindBy(xpath= "//div[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")
    WebElement btn_SendPayment;

    @FindBy(xpath= "//span[@id=\"amount\"]")
    WebElement ntf_BillPaymentComplete;

    @FindBy(xpath= "//div[@id=\"leftPanel\"]/ul/li[2]/a")
    WebElement clickAccountsOverview;


    public BillPayment(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void performBillPayment(String name, String address, String city, String state, String zip, String phoneNumber, String accountNumber, String amount) throws InterruptedException {
    tbx_PayeeName.sendKeys(name);
    tbx_Address.sendKeys(address);
    tbx_City.sendKeys(city);
    tbx_State.sendKeys(state);
    tbx_ZipCode.sendKeys(zip);
    tbx_PhoneNumber.sendKeys(phoneNumber);
    tbx_PayeeAccountNumber.sendKeys(accountNumber);
    tbx_VerifyPayeeAccountNumber.sendKeys(accountNumber);
    tbx_Amount.sendKeys(amount);
    btn_SendPayment.click();
    Thread.sleep(3000);
    }

    public String billPaymentConfimation(){

        String message =ntf_BillPaymentComplete.getText();
        return message;

    }

    public void clickAccountsOverview(){
        clickAccountsOverview.click();
    }
}
