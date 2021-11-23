package com.selenium.assignment4.part1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class directoryPage {
    WebDriver driverx;

    @FindBy(xpath="//input[@type='text']")
    WebElement name;

    @FindBy(xpath="//select[@name ='searchDirectory[job_title]' ]//child::option[@value= '13']")
    WebElement jobTitle;

    @FindBy(xpath="//select[@name ='searchDirectory[location]' ]//child::option[2]")
    WebElement searchLocation;

    @FindBy(xpath="//input[@name ='_search']")
    WebElement searchBtn;


    public directoryPage (WebDriver driverx){
        this.driverx=driverx;
        PageFactory.initElements(driverx,this);
    }

    public String checkUrl(){
        String URL =driverx.getCurrentUrl();
        return URL;
    }

    public void searchDirectory() throws InterruptedException {
        name.sendKeys("Anthony Nolan");
        jobTitle.click();
        Thread.sleep(3000);
        searchLocation.click();
        Thread.sleep(3000);
        searchBtn.click();
        Thread.sleep(3000);
    }
}
