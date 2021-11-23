package com.selenium.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CardNumberFetchPage {

    String S,C1,C2,C4,Y3,M3;

    WebDriver driverx;

    @FindBy(xpath = "//p[@style = 'text-align:center']//following-sibling::h4[1]")
    WebElement cardNumber;

    @FindBy(xpath = "//p[@style = 'text-align:center']//following-sibling::h4[2]")
    WebElement cvv;

    @FindBy(xpath = "//p[@style = 'text-align:center']//following-sibling::h4[3]")
    WebElement exp;

    @FindBy(xpath = "//p[@style = 'text-align:center']//following-sibling::h4[4]")
    WebElement creditLimit;

    @FindBy(xpath = "//nav[@id='nav']//child::a[1]")
    WebElement cart;


    public CardNumberFetchPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }


 public  String allotFetchCardNumber() throws InterruptedException {
        String Cardnumber = cardNumber.getText();
        String C1 = Cardnumber.substring(14,30);
        this.C1=C1;
        return this.C1;

        }

         public  String allotFetchCvv() throws InterruptedException {
        String Cvv= cvv.getText();
        C2 = Cvv.substring(6,9);
        return C2;
        }

        public  String allotFetchExpiryYear() throws InterruptedException {
        String Exp = exp.getText();
        Y3 =Exp.substring(9,13);
        return Y3;
        }

        public  String allotFetchExpiryMonth() throws InterruptedException {
        String Exp = exp.getText();
        M3 =Exp.substring(6,8);
        return M3;
        }

         public  String allotFetchCardlimit() throws InterruptedException {
        String Creditlimit = creditLimit.getText();
        C4 = Creditlimit.substring(13,19);
        return C4;
        }



    public  void displayCardNumberPageElementToUser() throws InterruptedException {

        System.out.println("Credit card details are as follows:");
        System.out.println("Credit Card Number: " + C1 + " CVV: " + C2 + " ExpYear: " +Y3+ " ExpMonth: " +M3 + " Credit Limit: "+ C4);
        clickCartButton();
        }

    public void clickCartButton() throws InterruptedException {
        cart.click();
        String currentWindows = String.valueOf(driverx.getWindowHandles());
        List<String> arrayOfWindow = new ArrayList<>(driverx.getWindowHandles());
        driverx.switchTo().window(arrayOfWindow.get(1));
        }


        }

