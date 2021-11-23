package com.selenium.assignment6.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParasoftLoginPage {

    public String URL = "https://parabank.parasoft.com/parabank/index.htm";

    WebDriver driver;

    @FindBy(xpath= "//div[@id=\"loginPanel\"]/form/div[1]/input")
    WebElement tbx_Username;

    @FindBy(xpath= "//div[@id=\"loginPanel\"]/form/div[2]/input")
    WebElement tbx_Password;

    @FindBy(xpath= "//div[@id=\"loginPanel\"]/form/div[3]/input")
    WebElement btn_Login;

    public ParasoftLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void launchParasoftLoginPage() throws InterruptedException {
        driver.get(URL);
        String URL = driver.getCurrentUrl();
        Thread.sleep(3000);

    }

    public void enterUsernameAndPasswordAndClickLogin(String username, String password) throws InterruptedException {
        tbx_Username.sendKeys(username);
        tbx_Password.sendKeys(password);
        btn_Login.click();
        Thread.sleep(3000);

    }



}
