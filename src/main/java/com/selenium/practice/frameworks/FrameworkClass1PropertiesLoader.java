package com.selenium.practice.frameworks;

import com.selenium.practice.frameworks.frameworkExceptions.ConfigrationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FrameworkClass1PropertiesLoader {

    static Properties configProperties;
    public static String runOnBrowser;
    public static Boolean takeScreenShot;
    public static String chromeDriverPath;
    public static String edgeDriverPath;
    public static String ieDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizeMode;
    public static Integer implicitWait;
    public static Integer explicitWait;
    public static Integer pageLoadWait;



    public  static void initializeProperties() throws IOException {
        if(configProperties==null){
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+ "//src//test//resources//config.properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser=configProperties.getProperty("RunOnrowser");
        takeScreenShot = Boolean.valueOf(configProperties.getProperty("TakeScreenShot"));
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        edgeDriverPath=configProperties.getProperty("EdgeDriverPath");
        ieDriverPath=configProperties.getProperty("IEDriverPath");
        firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
        maximizeMode = Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
        implicitWait=Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWait=Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadWait=Integer.valueOf(configProperties.getProperty("PageLoadWait"));

    }

    public static void validateConfigration() {
        if (runOnBrowser.equalsIgnoreCase("Chrome")) {
            if (chromeDriverPath.isEmpty()) {
                throw new ConfigrationException("ChromeDrivePath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Edge")) {
            if (edgeDriverPath.isEmpty()) {
                throw new ConfigrationException("EdgeDrivePath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("IE")) {
            if (ieDriverPath.isEmpty()) {
                throw new ConfigrationException("IEDrivePath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Firefox")) {
            if (firefoxDriverPath.isEmpty()) {
                throw new ConfigrationException("FirefoxDrivePath empty");
            }
        }
    }

}
