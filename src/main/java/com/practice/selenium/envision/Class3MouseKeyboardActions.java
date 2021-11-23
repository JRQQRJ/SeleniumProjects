package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Class3MouseKeyboardActions extends POMBaseTest {

    String URL="https://demoqa.com/menu#";


    @Test

    public void testMouseAction() throws Exception {
        driver.get(URL);

        //Selenium has a class called actions
       WebElement mainMenu = driver.findElement(By.linkText("Main Item 2"));// this command can only be used if the tag is linked
        Actions actions = new Actions(driver);
       // driver.findElement(By.linkText("Main Item")); --> anything with Main item will show up
        actions.moveToElement(mainMenu).build().perform();
        Thread.sleep(3000);
        WebElement subMenu = driver.findElement(By.linkText("SUB SUB LIST »"));
        actions.moveToElement(subMenu).build().perform();
        Thread.sleep(3000);
    }
}




