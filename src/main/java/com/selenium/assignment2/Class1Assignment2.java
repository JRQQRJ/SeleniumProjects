package com.selenium.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class1Assignment2 {

    WebDriver driver;
    String URL = " http://automationpractice.com/index.php";

    @BeforeMethod
    public void setUP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @Test
    public void testLogin() throws InterruptedException {

        // Navigating to the Website (Url)

        driver.get(URL);

        // Identifying and Clicking on SignIn button

        WebElement signIn = driver.findElement(By.xpath("//a[@class ='login']"));
        signIn.click();

        // Verifying if the SignIn page is open

        String signInPagetUrl = driver.getCurrentUrl();
        Assert.assertTrue(signInPagetUrl.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"));

        // Identifying,Clicking on Email address Textbox and entering Email address

        WebElement emailAddress = driver.findElement(By.xpath("//input[@id ='email']"));
        emailAddress.click();
        emailAddress.sendKeys("hey@abc.com");

        // Identifying,Clicking on Password Textbox and entering Password

        WebElement password = driver.findElement(By.xpath("//input[@id ='passwd']"));
        password.click();
        password.sendKeys("Testing@123");

        // Identifying,Clicking on SignInBotton

        WebElement SignInBotton = driver.findElement(By.xpath("//button[@name ='SubmitLogin']"));
        SignInBotton.click();

        // Validate if Login is successful

        // Checkpoint1 : Validating using URL

        String logedInPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(logedInPageUrl.equals("http://automationpractice.com/index.php?controller=my-account"));

        // Checkpoint2 : Validating using Text "Tarun Sachdeva"

        WebElement welcomeMsg = driver.findElement(By.xpath("//a[@class ='account']"));
        String  welcomeText = welcomeMsg.getText();
        Assert.assertEquals(welcomeText, "Tarun Sachdeva","Displayed msg does not matc requirement");
        System.out.println("Login is successful and it is validated");

        // Identifying,Clicking on SignOutBotton

        WebElement SignOutBotton = driver.findElement(By.xpath("//a[@class ='logout']"));
        SignOutBotton.click();

        // Validate if Signout is successful

        String signOutPagetUrl = driver.getCurrentUrl();
        Assert.assertTrue(signOutPagetUrl.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
        System.out.println("Logout is successful and it is validated");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
    }

}
