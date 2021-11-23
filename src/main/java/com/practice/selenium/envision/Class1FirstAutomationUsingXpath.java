package com.practice.selenium.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class1FirstAutomationUsingXpath {
    WebDriver driver;
    String URL = "https://opensource-demo.orangehrmlive.com/license/addLicense";

    //------------------------------------------------------------------------------------------------------------

    @BeforeMethod // annotation are special comments/ instructions for compilers to understand the flow of code
    public void setUP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        // after 30 secs if element is not found--prog closes and throws an error
    /*
    the above default waits are applicable for all elements
     */

    }
    @Test
    public void testLogin() throws InterruptedException {
        driver.get(URL);
        //WebElement tbx_username = driver.findElement(By.id("txtUsername"));
        WebElement tbx_username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        tbx_username.clear();
        tbx_username.sendKeys("Admin");
        //Thread.sleep(1000);
        WebElement tbx_password = driver.findElement(By.xpath("//input[@name = 'txtPassword']"));
        tbx_password.click();
        tbx_password.sendKeys("admin123");
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click(); // clicks and opens the required page directly without creating a variable
        //Thread.sleep(1000);


        WebElement welcomeMsg = driver.findElement(By.id("welcome"));
        String  welcomeText = welcomeMsg.getText();
        Assert.assertTrue(welcomeMsg.isDisplayed());
        Assert.assertEquals(welcomeText,"Welcome Shri" , "Texts dont match");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
        //Thread.sleep(1000);
    }

}
