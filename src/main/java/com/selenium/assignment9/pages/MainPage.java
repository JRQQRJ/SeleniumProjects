package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public String URL = "https://prodigylabs.net/";

    WebDriver driver;

    @FindBy(xpath= "//li[@id=\"menu-item-5797\"]/a")
    WebElement btn_verify;

//    @FindBy(xpath= "//input[@id ='email']")
//    WebElement tbx_email;
//
//    @FindBy(xpath= "//input[@id ='passwd']")
//    WebElement tbx_password;
//
//
//    @FindBy(xpath= "//button[@name ='SubmitLogin']")
//    WebElement btn_Signin2;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void launchAutomationPracticeMain(){
        driver.get(URL);
    }

    public void clickBtnVerify(){
        btn_verify.click();
//        tbx_email.sendKeys(em);
//        tbx_password.sendKeys(p);
//        btn_Signin2.click();
}


}


