package com.selenium.assignment5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeeUnderPIM {

    WebDriver driver;

    @FindBy(xpath="//input[@id=\"firstName\"]")
    WebElement firstName;

    @FindBy(xpath="//input[@id=\"lastName\"]")
    WebElement lastName;

    @FindBy(xpath="//input[@id=\"employeeId\"]")
    WebElement employeeID;

    @FindBy(xpath="//input[@id=\"chkLogin\"]")
    WebElement createLoginDetailsCheckBox;

    @FindBy(xpath="//input[@id=\"user_name\"]")
    WebElement username;

    @FindBy(xpath="//input[@id=\"user_password\"]")
    WebElement password;

    @FindBy(xpath="//input[@id=\"re_password\"]")
    WebElement reEnterPassword;

    @FindBy(xpath="//input[@id=\"btnSave\"]")
    WebElement saveBtn;

    public AddEmployeeUnderPIM(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void inputFirstAndLastNameAndEnterEmployeeID(String firstname,String lastname,String empID) throws InterruptedException {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        employeeID.click();
        employeeID.clear();
        employeeID.sendKeys(empID);
    }

    public void clickOnCreateLoginDEtails(){
   createLoginDetailsCheckBox.click();
    }

    public void enterUniqueUsernameAndPasswordAndConfirmPasswordAndSave(String rUserName,String rPassword ) throws InterruptedException {
        username.sendKeys(rUserName);
        password.sendKeys(rPassword);
        reEnterPassword.sendKeys(rPassword);
        saveBtn.click();

    }
}