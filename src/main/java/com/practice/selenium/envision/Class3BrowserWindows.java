package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Class3BrowserWindows extends POMBaseTest {

    @Test
    public void testNewTab() throws Exception{
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(3000);
        String currentWindows= String.valueOf(driver.getWindowHandles());
        System.out.println(currentWindows);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(12000);

        List<String> arrayOfWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(arrayOfWindow.get(1));
        WebElement newTabElement = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(newTabElement.isDisplayed());
        driver.close();
        driver.switchTo().window(currentWindows);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
        Thread.sleep(3000);
    }
}
