package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeTShirts {

    WebDriver driver;

    @FindBy(xpath= " //a[@title= 'Faded Short Sleeve T-shirts']//child::img")
    WebElement img_FadedShortSleeveTShirts;


    public AutomationPracticeTShirts(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickFadedShortSleeveTShirts() throws InterruptedException {
        img_FadedShortSleeveTShirts.click();
        Thread.sleep(3000);
    }


}


