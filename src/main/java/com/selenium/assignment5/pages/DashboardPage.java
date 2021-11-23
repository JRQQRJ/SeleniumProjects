package com.selenium.assignment5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath="//a[@id= 'welcome']")
    WebElement welcomeName;

    @FindBy(xpath="//ul[@id=\"mainMenuFirstLevelUnorderedList\"]/li[2]")
    WebElement PIM;

    @FindBy(xpath="//ul[@id=\"mainMenuFirstLevelUnorderedList\"]/li[2]//*[@id='menu_pim_addEmployee']")
    WebElement employeeListUnderPIM;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String welcomeNameCheck(){
        String welcomeText=welcomeName.getText();
        return welcomeText;
    }

    public void clickEmployeeListUnderPIM(){
        PIM.click();
        employeeListUnderPIM.click();
    }
}