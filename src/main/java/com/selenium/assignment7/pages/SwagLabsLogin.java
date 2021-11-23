package com.selenium.assignment7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLogin {

        public String URL = "https://www.saucedemo.com/";

        WebDriver driver;

        @FindBy(xpath= "//input[@id=\"user-name\" and @class = 'input_error form_input']")
        WebElement username;

       @FindBy(css = "#password")
        WebElement password;

        @FindBy(xpath= "//input[@id=\"login-button\" and @value = 'Login']")
        WebElement btn_Login;

        public SwagLabsLogin(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void launchswagLabsLoginPage() throws InterruptedException {
            driver.get(URL);
            String URL = driver.getCurrentUrl();
            Thread.sleep(3000);

        }

        public void enterUsernameAndPasswordAndClickLogin(String username, String password) throws InterruptedException {
            this.username.sendKeys(username);
            this.password.sendKeys(password);
            btn_Login.click();
            Thread.sleep(3000);

        }



    }


