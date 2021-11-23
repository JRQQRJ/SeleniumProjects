package com.selenium.assignment8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class AutomationPracticeFadedShortSleeveTShirts {

    WebDriver driver;
    String MainWindow;

    @FindBy(xpath= " //p[@id=\"add_to_cart\"]//child::button[@type= 'submit']")
    WebElement btn_AddToCartFadedShortSleeveTShirts;

    @FindBy(xpath= "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    WebElement msg_Frame;

    @FindBy(xpath= "//a[@class = 'btn btn-default button button-medium']")
    WebElement proceedToCheckout;


    public AutomationPracticeFadedShortSleeveTShirts(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickAddToCartFadedShortSleeveTShirts() throws InterruptedException {
        MainWindow = driver.getWindowHandle();
        btn_AddToCartFadedShortSleeveTShirts.click();
        Thread.sleep(3000);
    }

    public void verifyMessageAndCheckout() throws InterruptedException {

        String msg =msg_Frame.getText();
        String expectedMsg = "Product successfully added to your shopping cart";

Assert.assertEquals(msg,expectedMsg,"The Add to cart function failed");

          proceedToCheckout.click();
          Thread.sleep(3000);

    }


}


