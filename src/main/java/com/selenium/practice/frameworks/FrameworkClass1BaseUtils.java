package com.selenium.practice.frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FrameworkClass1BaseUtils {

    //contains all reuseable methods

    WebDriver driver;

    FrameworkClass1BaseUtils(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver launchBrowser(String browser){

        WebDriver driver =null;

        if(browser.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver",FrameworkClass1PropertiesLoader.chromeDriverPath);
            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("Edge")){

            System.setProperty("webdriver.edge.driver",FrameworkClass1PropertiesLoader.edgeDriverPath);
            driver = new EdgeDriver();

        }else if(browser.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver",FrameworkClass1PropertiesLoader.ieDriverPath);
            driver = new InternetExplorerDriver();

        }else if(browser.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver",FrameworkClass1PropertiesLoader.firefoxDriverPath);
            driver = new FirefoxDriver();

        }
        if(FrameworkClass1PropertiesLoader.maximizeMode){

            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(FrameworkClass1PropertiesLoader.pageLoadWait, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(FrameworkClass1PropertiesLoader.implicitWait,TimeUnit.SECONDS);

        this.driver=driver;
        return this.driver;
    }

    public void closeBrowser(WebDriver driver){

        driver.close();

    }

    public void closeAllBrowser(WebDriver driver){

        driver.quit();

    }
}
