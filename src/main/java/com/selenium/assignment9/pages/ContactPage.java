package com.selenium.assignment9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactPage {

    WebDriver driver;

    @FindBy(xpath= "//*[@id=\"hs-eu-confirmation-button\"]")
    WebElement clickAccept;

    @FindBy(xpath= "//*[contains(text(),\"Please reach out with any questions\")]//parent::div//parent::div/following-sibling::div[2]/div")
    WebElement contactEmail;

    @FindBy(xpath= "//*[contains(text(),\"Please reach out with any questions\")]//parent::div//parent::div/following-sibling::div[3]/div/h4")
    WebElement contactAddress;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement tbx_FirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement tbx_LastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement tbx_EmailId;

    @FindBy(xpath = "//select[@name='industry']")
    WebElement tbx_industry;

    @FindBy(xpath = "//input[@name='city']")
    WebElement tbx_City;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_Submit;

    public ContactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyEmail(String expectedEmail) throws InterruptedException {
        clickAccept.click();
        Thread.sleep(3000);
        String email = contactEmail.getText();
        System.out.println(expectedEmail);
        System.out.println(email);
        Assert.assertEquals(email,expectedEmail,"Email mismatch");
        Thread.sleep(3000);
    }

    public void verifyAddress(String expectedAddress) throws InterruptedException {
        String Address = contactAddress.getText();
        System.out.println("aaaaaaaaaaa------"+expectedAddress);
        System.out.println(Address);
        Assert.assertEquals(Address,expectedAddress,"Address mismatch");
        Thread.sleep(3000);
    }

    public void Enter_FirstName(String firstName){
        tbx_FirstName.sendKeys(firstName);
         }
    public void Enter_LastName(String lastName){
        tbx_LastName.sendKeys(lastName);
    }
    public void Enter_Email(String email){
        tbx_EmailId.sendKeys(email);
    }
    public void Click_Industry(){
        tbx_industry.click();
        Select ddl_Industry = new Select(tbx_industry);
        ddl_Industry.selectByVisibleText("Banking");
    }
    public void Enter_City(String city){
        tbx_City.sendKeys(city);
    }
    public void ClickSubmit(){
        btn_Submit.click();
    }



}


