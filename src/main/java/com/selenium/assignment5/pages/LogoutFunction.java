package com.selenium.assignment5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutFunction {

    WebDriver driver;

    @FindBy(xpath="//a[@id='welcome']")
    WebElement welcomeUserNameBtn;

    @FindBy(xpath="//div[@id=\"welcome-menu\"]/ul/li[3]/a")
    WebElement logout;

    public LogoutFunction(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickWelcomeUsernameBtnAndLogout(){
        welcomeUserNameBtn.click();
        logout.click();
    }
}
