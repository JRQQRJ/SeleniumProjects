package com.selenium.Assignment7;

import com.selenium.assignment7.framework.BaseTest;
import com.selenium.assignment7.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTests extends BaseTest {


    String username = "standard_user";
    String password = "secret_sauce";
    String userFirstName = "Tarun";
    String userLastName = "Sachdeva";
    String Zip = "M2J1L9";

        @Test
    public void allTestCases() throws InterruptedException {

            SwagLabsLogin swagLabsLoginElement = new SwagLabsLogin(driver);

            // Step 1 : Login to https://www.saucedemo.com/
            swagLabsLoginElement.launchswagLabsLoginPage();

            // Step 2 :Enter username "standard_user"
            // Step 3 : Enter password "secret_sauce"
            // Step 4 : Click Login
            swagLabsLoginElement.enterUsernameAndPasswordAndClickLogin(username,password);

            // Step 5:Add to cart "Sauce Labs Backpack"
            SwagLabsInventory swagLabsInventoryElement = new SwagLabsInventory(driver);
            swagLabsInventoryElement.clickAddToCart("SauceLabsBackpack");

            // Step 6 :Verify the cart Icon is updated and shows the Item number. For ex if you add Bagpack, it woud display number "1" on cart icon. (checkpoint 1)
            swagLabsInventoryElement.checkpoint1();

            // Step 7:Add to cart "Sauce Labs Fleece Jacket"
            swagLabsInventoryElement.clickAddToCart("SauceLabsFleeceJacket");

            // Step 8:Verify the cart is updated with the number of items in total (on cart icon). (checkpoint 2)
            swagLabsInventoryElement.checkpoint2();

            // Step 9:Click on Cart icon to checkout
            swagLabsInventoryElement.clickOnCartIcon();

            // Step 10:Verify your items (checkpoint 3)
            SwagLabsCart swagLabsCartElement = new SwagLabsCart(driver);
            swagLabsCartElement.checkPoint3();

            // Step 11:Click On Checkout button
            swagLabsCartElement.checkOut();

            // Step 12:Enter your checkout information and move to next page
            SwagLabsChekoutUserInfo swagLabsChekoutUserInfoElement = new SwagLabsChekoutUserInfo(driver);
            swagLabsChekoutUserInfoElement.enterInformationAndCntinue(userFirstName,userLastName,Zip);

            // Step 13:Verify that the shipping information is "FREE PONY EXPRESS DELIVERY!" , payment information is "SauceCard #31337" and
            //item total (excluding tax) is the total of all items that you placed on bag. (checkpoint 4)
            SwagLabsCheckout swagLabsChekoutElement = new SwagLabsCheckout(driver);
            swagLabsChekoutElement.checkPoiny4();

            // Step 11:Click on Finish button
            swagLabsChekoutElement.clickFinishButton();


            // Step 12:Close the browser

        }
    }

