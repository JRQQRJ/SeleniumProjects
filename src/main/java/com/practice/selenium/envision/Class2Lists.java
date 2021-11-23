package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Class2Lists {


    WebDriver driver;
    String URL = "https://demoqa.com/select-menu";

    @BeforeMethod
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }


//    public void selectOldStyleLists () throws InterruptedException {
//        driver.get(URL);
//        Thread.sleep(3000);
//        WebElement oldStyleList = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
//        //Using select method
//        Select ddl_colors = new Select(oldStyleList);
//        ddl_colors.selectByValue("7"); //This method takes string value
//        Thread.sleep(2000);
//        ddl_colors.selectByIndex(4); //Takes integer value
//        Thread.sleep(2000);
//        ddl_colors.selectByVisibleText("Aqua");
//        Thread.sleep(2000);
//
//    }
//
//    public void newStyleLists() throws InterruptedException {
//
//        driver.get(URL);
//        WebElement newStyleList = driver.findElement(By.xpath("//div[text() = 'Select Title']"));
//        newStyleList.click();
//        Thread.sleep(3000);
//        listOptions("Ms.");
//
//    }
//
//    public void listOptions(String option) throws InterruptedException {
//        List<WebElement> alloptions = driver.findElements(By.xpath("//div[contains(@id,'react-select-') and contains(@id,'-group')]/following-sibling::div/div[contains(@id,'react-select-') and contains(@id,'-option')]"));
//        for(int i=0; i<alloptions.size();i++){
//            if(alloptions.get(i).getText().equalsIgnoreCase(option)){
//                alloptions.get(i).click();
//                Thread.sleep(3000);
//                break;
//            }
//        }
//    }
    @Test
    public void writeLists() throws InterruptedException {

        driver.get(URL);
        WebElement writeList = driver.findElement(By.xpath("//b[contains(text(),'Multiselect')]/parent::p/following-sibling::div//div[contains(@class,'indicatorContainer')]"));
        writeList.click();
        Thread.sleep(3000);
        WebElement tbx_input = driver.findElement(By.xpath("//b[contains(text(),'Multiselect')]/parent::p/following-sibling::div//input"));
        tbx_input.sendKeys("Green");
        Thread.sleep(3000);
        tbx_input.sendKeys(Keys.TAB);
        tbx_input.sendKeys("Blue");
        Thread.sleep(3000);
        tbx_input.sendKeys(Keys.TAB);
////div[@class = ' css-26l3qy-menu']
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();

    }
}
