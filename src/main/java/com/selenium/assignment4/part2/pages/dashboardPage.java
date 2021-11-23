package com.selenium.assignment4.part2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {

    WebDriver driverx;

    @FindBy(xpath="//a[@id= 'welcome']")
    WebElement welcomeName;

    @FindBy(xpath="//a[@href = '/index.php/pim/viewMyDetails']")
    WebElement infoTab;

    public dashboardPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }

    public String welcomeNameCheck(){
        String welcomeText=welcomeName.getText();
        return welcomeText;
    }

    public void clickInfoTab(){
        infoTab.click();
    }
}