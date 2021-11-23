package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import com.selenium.practice.frameworks.TestAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Class3HoverToolTip extends POMBaseTest {

    @Test
    public void testToolTip() throws Exception{

        driver.get("https://demoqa.com/tool-tips");
        Thread.sleep(3000);
        WebElement element =driver.findElement(By.id("toolTipButton"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(3000);
        element =driver.findElement(By.id("toolTipButton"));
        String value = element.getAttribute("aria-describedby");
        System.out.println(value);
        TestAssertions.checkIFValuesAreEqual("buttonToolTip", value);

    }


}
