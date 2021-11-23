package com.selenium.practice.orangecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    String URL = "https://opensource-demo.orangehrmlive.com";

    WebDriver driver;

    @FindBy(xpath= "//input[@id = 'txtUsername']")
    WebElement tbx_Username;

    @FindBy(xpath= "//input[@name = 'txtPassword']")
    WebElement tbx_Password;

    @FindBy(xpath= "//input[@id = 'btnLogin']")
    WebElement btn_Submit;

   public LoginPage(WebDriver driver){ //constructor of the class used to invoke all methods of the class
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage launchOrangeCRMWebsite(){
        driver.get(URL);
        return this;
    }

    public LoginPage enterUserName(String username){
        tbx_Username.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        tbx_Password.sendKeys(password);
        return this;
    }
    public void forgotPassword(){

    }

    public DashboardPage hitSubmit(){
        btn_Submit.click();
        return new DashboardPage(driver);
    }


}
