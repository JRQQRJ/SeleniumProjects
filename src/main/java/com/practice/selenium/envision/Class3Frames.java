package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class3Frames extends POMBaseTest {

    @Test
    public void testNewTab() {
        driver.get("https://demoqa.com/frames");

        WebElement iFrame= driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iFrame);

        WebElement newTabElement = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(newTabElement.isDisplayed());
        driver.switchTo().defaultContent();


    }
}

