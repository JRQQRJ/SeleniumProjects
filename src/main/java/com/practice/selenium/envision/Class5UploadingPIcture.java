package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Class5UploadingPIcture extends POMBaseTest {


    @Test
    public void uploadPicture() throws InterruptedException, AWTException {

        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(3000);
        WebElement btn_upload= driver.findElement(By.xpath("//label[@for='uploadFile']"));
        new Actions(driver).moveToElement(btn_upload).click().build().perform();
        Thread.sleep(3000);
        String filePath= "C:\\Users\\admin\\Desktop\\Working Folder\\K1597.png";
        StringSelection se = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se,null);
        Thread.sleep(3000);
        Robot r =new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

//C:\Users\admin\Desktop\Working Folder\K1597.png

    }
}