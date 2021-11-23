package com.selenium.assignment8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeMyAccount {

    WebDriver driver;

    @FindBy(xpath= "//div[@id=\"block_top_menu\"]/ul/li[3]/a[@title ='T-shirts']")
    WebElement btn_tShirt;


    public AutomationPracticeMyAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void clickTShirts() throws InterruptedException {
        btn_tShirt.click();
        Thread.sleep(3000);
    }


}


