package com.selenium.assignment4.part1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class directoryPageSearchResult {

    WebDriver driverx;

    @FindBy(xpath="//b[text()= 'Anthony Nolan']")
    WebElement directySearchResultName;

    @FindBy(xpath="//a[@id='welcome']")
    WebElement clickWel;

    @FindBy(xpath="//div[@id='welcome-menu']//child::a[@href='/index.php/auth/logout']")
    WebElement logout;

    public directoryPageSearchResult (WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }

    public String searchResultName(){
        String Name = directySearchResultName.getText();
        return Name;
    }

    public void clickLogout() throws InterruptedException {
        clickWel.click();
        Thread.sleep(3000);
        logout.click();
    }
}
