package com.selenium.assignment7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwagLabsChekoutUserInfo {

        WebDriver driver;

        @FindBy(css = "#first-name")
        WebElement firstName;

        @FindBy(css = "#last-name")
        WebElement lastName;

        @FindBy(css = "#postal-code")
        WebElement zip;

        @FindBy(css = "#continue")
        WebElement btn_Continue;

         public SwagLabsChekoutUserInfo(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void enterInformationAndCntinue(String fN, String lN, String zip) throws InterruptedException {
            firstName.sendKeys(fN);
            lastName.sendKeys(lN);
            this.zip.sendKeys(zip);
            btn_Continue.click();
            Thread.sleep(3000);
        }


    }


