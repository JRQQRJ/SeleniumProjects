package com.selenium.practice.orangecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    @FindBy(id="welcome")
    WebElement lbl_WelcomeMsg;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage(){
    String elementText= lbl_WelcomeMsg.getText();
        return elementText;
    }
    public void clickAdminTab(){ //add all interactions as methods

    }



}
