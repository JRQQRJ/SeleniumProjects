package com.selenium.assignment4.part1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHRMLoginPage {

    WebDriver driverx;

    String URL = "https://opensource-demo.orangehrmlive.com/";

    @FindBy(xpath="//input[@name= 'txtUsername']")
    WebElement userName;

    @FindBy(xpath="//input[@name= 'txtPassword']")
    WebElement password;

    @FindBy(xpath="//input[@name= 'Submit']")
    WebElement login;

    public orangeHRMLoginPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }

    public void launchOrangeHRMLoginPage() throws InterruptedException {
        driverx.get(URL);
        Thread.sleep(3000);
    }

    public void loginAction() throws InterruptedException {

        userName.sendKeys("Admin");
        Thread.sleep(3000);

        Thread.sleep(3000);
        password.sendKeys("admin123");
        login.click();
        Thread.sleep(3000);
    }

}
