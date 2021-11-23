package com.selenium.assignment5.pages;


import com.selenium.practice.orangecrm.pages.DashboardPage;
import com.selenium.practice.orangecrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

    public String URL = "https://opensource-demo.orangehrmlive.com/";

    WebDriver driverx;

    @FindBy(xpath= "//input[@id = 'txtUsername']")
    WebElement tbx_Username;

    @FindBy(xpath= "//input[@name = 'txtPassword']")
    WebElement tbx_Password;

    @FindBy(xpath= "//input[@id = 'btnLogin']")
    WebElement btn_Submit;

    public OrangeHRMLoginPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx, this);
    }

    public String launchOrangeHRMLoginPAge() throws InterruptedException {
        driverx.get(URL);
        String URL = driverx.getCurrentUrl();
        Thread.sleep(3000);
        return URL;
    }
    public OrangeHRMLoginPage enterUserName(String username){
        tbx_Username.sendKeys(username);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        tbx_Password.sendKeys(password);
        return this;
    }

    public OrangeHRMLoginPage hitSubmit(){
        btn_Submit.click();
        return this;
    }



}
