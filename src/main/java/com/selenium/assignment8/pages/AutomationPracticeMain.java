package com.selenium.assignment8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutomationPracticeMain {

    public String URL = "http://automationpractice.com/index.php";

    WebDriver driver;

    @FindBy(xpath= "//a[@class ='login']")
    WebElement btn_SignIn1;

    @FindBy(xpath= "//input[@id ='email']")
    WebElement tbx_email;

    @FindBy(xpath= "//input[@id ='passwd']")
    WebElement tbx_password;


    @FindBy(xpath= "//button[@name ='SubmitLogin']")
    WebElement btn_Signin2;

    public AutomationPracticeMain(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void launchAutomationPracticeMain(){
        driver.get(URL);
    }

    public void performSignIn(String em, String p){
        btn_SignIn1.click();
        tbx_email.sendKeys(em);
        tbx_password.sendKeys(p);
        btn_Signin2.click();
}


}


