package com.practice.selenium.envision;

import com.selenium.practice.frameworks.POMBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Class4FetchWebTableElement extends POMBaseTest {


    @Test
    public void fetchWebTableValues() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        System.out.println("7777");
        List<WebElement> tabelRows = driver.findElements(By.xpath("//div[contains(@class, 'rt-tr-group')]"));
        for (int i = 0; i < tabelRows.size(); i++) {

            WebElement currentRow = tabelRows.get(i);
            List<WebElement> allColumns = currentRow.findElements(By.xpath("//div[contains(@class, 'rt-tr-group')]["+(i+1)+"]//div[contains(@class,'rt-td')]"));
            for (int j = 0; j < allColumns.size(); j++) {
                String columnvalue = allColumns.get(j).getText();
                if(columnvalue.equalsIgnoreCase("Alden")){

                    WebElement edit =driver.findElement(By.xpath("//div[contains(@class, 'rt-tr-group')][\"+(i+1)+\"]//div[contains(@class,'rt-td')]//span[contains(@id,'edit-record')]"));
                    edit.click();
                    Thread.sleep(3000);
                    WebElement btn =driver.findElement(By.xpath("//button[@class='close']"));
                    btn.click();;
                    Thread.sleep(2000);
                    return;
                }
                System.out.print(columnvalue + "||");
            }
            System.out.println();
        }
        Thread.sleep(3000);
    }


}
