package com.selenium.assignment8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutomationPracticeOrderConfirmation {

    WebDriver driver;

    @FindBy(xpath= "//strong[contains(text(),'Your order on My Store is complete.')]")
    WebElement msg_OrderConfirmation;

    @FindBy(xpath= "//span[@class='price']/strong")
    WebElement totalAmount;

    @FindBy(xpath= "//div[@id=\"center_column\"]/div/strong[1]")
    WebElement accountHolderName;

    @FindBy(xpath= "//div[@id=\"center_column\"]/div/strong[3]")
    WebElement nameOfBank;

    public AutomationPracticeOrderConfirmation(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void ensureConfirmMyOrder() throws InterruptedException {
        Assert.assertEquals(msg_OrderConfirmation.getText(),"Your order on My Store is complete.", "Your order confirmation has failed");
        Thread.sleep(3000);
           }

    public void fetchWireDetails(){
        System.out.println("Total amount: "+ totalAmount.getText());
        System.out.println("Account holder name : "+ accountHolderName.getText());
        System.out.println("Name of bank: "+ nameOfBank.getText());
    }


}


