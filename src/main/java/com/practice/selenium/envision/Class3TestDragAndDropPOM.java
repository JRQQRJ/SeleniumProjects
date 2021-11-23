package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Class3TestDragAndDropPOM extends POMBaseTest {

    String URL="https://demoqa.com/dragabble";


    @Test

    public void testDragDropAction() throws Exception {
        driver.get(URL);
        Thread.sleep(3000);
        WebElement type = driver.findElement(By.id("draggableExample-tab-axisRestriction"));
        type.click();
        Thread.sleep(3000);
        WebElement xItem = driver.findElement(By.id("restrictedX"));// this command can only be used if the tag is linked
        WebElement yItem = driver.findElement(By.id("restrictedY"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(xItem,yItem).build().perform();
        Thread.sleep(3000);
    }

}
