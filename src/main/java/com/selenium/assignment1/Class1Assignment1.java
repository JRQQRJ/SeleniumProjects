package com.selenium.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class1Assignment1 {

    WebDriver driver;
    String URL = " https://opensource-demo.orangehrmlive.com/index.php/auth/login ";


    @BeforeMethod
    public void setUP() throws InterruptedException {

        // Instantiating Chrome browser

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Binary\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @Test
    public void testValidLogin() throws InterruptedException { // Positive/Valid login Scenario

        // Navigating to the Website (Url)

        driver.get(URL);

        // Identifying,Clicking on Username textbox and entering correct username

        WebElement username = driver.findElement(By.xpath("//input[@id ='txtUsername']"));
        username .click();
        username .sendKeys("Admin");

        // Identifying,Clicking on Password textbox and entering correct password

        WebElement password = driver.findElement(By.xpath("//input[@id ='txtPassword']"));
        password.click();
        password.sendKeys("admin123");

        // Identifying,Clicking on login

        WebElement LogInBotton = driver.findElement(By.xpath("//input[@id ='btnLogin']"));
        LogInBotton.click();

        // Validate Successful login

        // Checkpoint: Validating if Text "Welcome" is displayed in the top right corner

        WebElement welcomeMsg= driver.findElement(By.xpath("//a[@class = 'panelTrigger' ]"));
        Assert.assertTrue(welcomeMsg.isDisplayed());
        Assert.assertTrue(welcomeMsg.getText().contains("Welcome"));

        // Checkpoint: Validating the Url

        String validCreditialPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(validCreditialPageUrl.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
        System.out.println("Login is successful (while using valid username and password), and it is verified that the user is logged in.");
    }


    @Test
    public void testInvalidLogin() throws InterruptedException {  // Invalid login Scenario

        // Navigating to the Website (Url)

        driver.get(URL);

        // Identifying,Clicking on Username Textbox and entering incorrect username

        WebElement username = driver.findElement(By.xpath("//input[@id ='txtUsername']"));
        username .click();
        username .sendKeys("ssssssss");

        // Identifying,Clicking on Password Textbox and entering incorrect password

        WebElement password = driver.findElement(By.xpath("//input[@id ='txtPassword']"));
        password.click();
        password.sendKeys("Testi123");

        // Identifying,Clicking on login

        WebElement LogInBotton = driver.findElement(By.xpath("//input[@id ='btnLogin']"));
        LogInBotton.click();

        // Validate unsuccessful login

        // Checkpoint: Validating if Text "Invalid credentials" is displayed

        WebElement msg= driver.findElement(By.xpath("//span[@id = 'spanMessage' ]"));
        String text = msg.getText();
        Assert.assertTrue(msg.isDisplayed());
        Assert.assertEquals(text,"Invalid credentials", "Texts dont match");

        // Checkpoint: Validating the Url

        String invalidCreditialPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(invalidCreditialPageUrl.equals("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials"));
        System.out.println("Login is unsuccessful(while using invalid username and password) and it is verified that the user is on same page.");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.close();
    }
}
