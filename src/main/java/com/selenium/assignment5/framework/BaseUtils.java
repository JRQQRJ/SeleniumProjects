package com.selenium.assignment5.framework;

import com.selenium.practice.frameworks.FrameworkClass1PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseUtils {

    //contains all reuseable methods

    WebDriver driver;

    BaseUtils(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver launchBrowser(String browser){

        WebDriver driver =null;

        if(browser.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver", PropertiesLoader.chromeDriverPath);
            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("Edge")){

            System.setProperty("webdriver.edge.driver",PropertiesLoader.edgeDriverPath);
            driver = new EdgeDriver();

        }else if(browser.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver",PropertiesLoader.ieDriverPath);
            driver = new InternetExplorerDriver();

        }else if(browser.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver",PropertiesLoader.firefoxDriverPath);
            driver = new FirefoxDriver();

        }
        if(PropertiesLoader.maximizeMode){

            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(PropertiesLoader.pageLoadWait, TimeUnit.SECONDS);// if page loads with 30 secs its all fine
        driver.manage().timeouts().implicitlyWait(PropertiesLoader.implicitWait,TimeUnit.SECONDS);

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
