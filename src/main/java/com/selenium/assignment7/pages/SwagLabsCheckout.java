package com.selenium.assignment7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwagLabsCheckout {

        WebDriver driver;

        @FindBy(xpath = "//div[@class = 'summary_value_label' and contains(text(),'PONY')]")
        WebElement shippingInfo;

        @FindBy(xpath = "//div[@id=\"checkout_summary_container\"]/div/div[2]/div[contains(text(), 'SauceCard')]")
        WebElement paymentInfo;

        @FindBy(xpath = "//a[@id = 'item_4_title_link']/following-sibling::div[2]//child::div")
        WebElement item1Price;

        @FindBy(xpath = "//a[@id = 'item_5_title_link']/following-sibling::div[2]//child::div")
        WebElement item2Price;

        @FindBy(xpath = "//div[@class=\"summary_info\"]//child::div[@class = 'summary_subtotal_label']")
        WebElement itemTotalPrice;

        @FindBy(css = "#finish")
        WebElement btn_finish;

         public SwagLabsCheckout(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void checkPoiny4() throws InterruptedException {

            Assert.assertEquals(shippingInfo.getText(),"FREE PONY EXPRESS DELIVERY!", "Invalid Shipping Information");
            Assert.assertEquals(paymentInfo.getText(),"SauceCard #31337", "Invalid Payment Information");
            Float itemPrice1 = Float.valueOf(item1Price.getText().substring(1,6));
            Float itemPrice2 = Float.valueOf(item2Price.getText().substring(1,6));
            Float total = Float.valueOf(itemTotalPrice.getText().substring(13,18));
            if(total == (itemPrice1+itemPrice2)){
              System.out.println("The total displayed is correct");
          }else
                System.out.println("Incorrect total");

        }

        public void clickFinishButton(){
             btn_finish.click();
        }

    }


