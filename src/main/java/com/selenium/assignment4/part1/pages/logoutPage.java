package com.selenium.assignment4.part1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutPage {
    WebDriver driverx;

    public logoutPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }
    public String getLogoutPageUrl(){
        String logoutUrl= driverx.getCurrentUrl();
        return logoutUrl;
    }
}

