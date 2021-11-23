package com.selenium.assignment7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwagLabsInventory {

        WebDriver driver;

        String checkpoint1Value,Checkpoint2Value;

        @FindBy(xpath= "//button[@id=\"add-to-cart-sauce-labs-backpack\" and @class= 'btn btn_primary btn_small btn_inventory' ]")
        WebElement addSauceLabsBackpackToCart;

        @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
        WebElement addSauceLabsFleeceJacketToCart;

        @FindBy(xpath= "//div[@id=\"shopping_cart_container\"]//child::a//child::span")
        WebElement cartIconValue;

        @FindBy(xpath= "//div[@id=\"shopping_cart_container\"]//child::a")
        WebElement cartIcon;

        public SwagLabsInventory(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void clickAddToCart(String input) throws InterruptedException {

            if(input == "SauceLabsBackpack"){
                addSauceLabsBackpackToCart.click();
            Thread.sleep(3000);}

            else if(input == "SauceLabsFleeceJacket"){
                addSauceLabsFleeceJacketToCart.click();
            }

        }

        public void checkpoint1(){
            Assert.assertTrue(cartIconValue.isDisplayed());
            this.checkpoint1Value= cartIconValue.getText();
        }

        public void checkpoint2(){
            Assert.assertTrue(cartIconValue.isDisplayed());
            this.Checkpoint2Value= cartIconValue.getText();
            Assert.assertTrue(this.Checkpoint2Value!=this.checkpoint1Value,"Add to cart function unsuccessfull");

        }

        public void clickOnCartIcon(){
            cartIcon.click();
        }




    }


