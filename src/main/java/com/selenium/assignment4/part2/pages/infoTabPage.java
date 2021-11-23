package com.selenium.assignment4.part2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class infoTabPage {

    WebDriver driverx;


    @FindBy(xpath="//input[@type='text' and @name = 'personal[txtEmpFirstName]']")
    WebElement firstName;

    @FindBy(xpath="//input[@value='Collings']")
    WebElement lastName;

    @FindBy(xpath="//a[@id='welcome']")
    WebElement clickWel;

    @FindBy(xpath="//div[@id='welcome-menu']//child::a[@href='/index.php/auth/logout']")
    WebElement logout;

    public infoTabPage(WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }

    public String checkUrl(){
        String URL = driverx.getCurrentUrl();
        return URL;
    }

    public String checkFirstName(){
String firstname = firstName.getAttribute("value");
return firstname;
    }

    public String CheckLastName(){
        String lastname = lastName.getAttribute("value");
        return lastname;

    }
    public void clickLogout() throws InterruptedException {
        clickWel.click();
        Thread.sleep(3000);
        logout.click();
    }

}
