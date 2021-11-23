package com.selenium.Assignment8;

import com.selenium.assignment8.framework.BaseTest;
import com.selenium.assignment8.pages.*;
import org.testng.annotations.Test;

public class Tests extends BaseTest {



        @Test
    public void allTestCases() throws InterruptedException {

            // Step 1 : Login to http://automationpractice.com/index.php
            AutomationPracticeMain automationPracticeMainElement = new AutomationPracticeMain(driver);
            automationPracticeMainElement.launchAutomationPracticeMain();

            // Step 2 : Login to the website using email : "hey@abc.com" and password: "Testing@123"
            automationPracticeMainElement.performSignIn("hey@abc.com","Testing@123");

            // Step 3:Click on sub menu 'T-shirts'
            AutomationPracticeMyAccount automationPracticeMyAccountElement = new AutomationPracticeMyAccount(driver);
            automationPracticeMyAccountElement.clickTShirts();

            // Step 4 : Click on Result Image : "Faded Short Sleeve T-shirts"
            AutomationPracticeTShirts automationPracticeTShirtsElements = new AutomationPracticeTShirts(driver);
            automationPracticeTShirtsElements.clickFadedShortSleeveTShirts();

            // Step 5:Click Add to cart
            AutomationPracticeFadedShortSleeveTShirts automationPracticeFadedShortSleeveTShirtsElement = new AutomationPracticeFadedShortSleeveTShirts(driver);
            automationPracticeFadedShortSleeveTShirtsElement.clickAddToCartFadedShortSleeveTShirts();

            // Step 6 :Verify that the product is added to cart by verifying the message "Product successfully added to your shopping cart"
            // Step 7: Click on Proceed to checkout
            automationPracticeFadedShortSleeveTShirtsElement.verifyMessageAndCheckout();

            // Step 8:On the shopping cart summary screen, fetch the total price.
            AutomationPracticeCartSummary automationPracticeCartSummaryElement = new AutomationPracticeCartSummary(driver);
            automationPracticeCartSummaryElement.fetchAndDisplayCartTotalPrice();

            // Step 9: Verify the price doesnt exceed total of 20 dollars
            // Step 10:Verify your items (checkpoint 3)
                automationPracticeCartSummaryElement.compareCartTotalPriceAndCheckOut();

            // Step 11:  Select terms of service (You can do it by simply clicking on the text - terms of service)
            AutomationPracticeShipping automationPracticeShippingElement =  new AutomationPracticeShipping(driver);
            automationPracticeShippingElement.clickTermsAndServiceCheckBox();

            // Step 12: Fetch the delivery fees, and verify that delivery fees is not more than 5 dollars
            // Step 13:Proceed to checkout
            automationPracticeShippingElement.compareShippingTotalPriceAndCheckOut();

            // Step 14: Select Pay by bank wire
            AutomationPracticePayment automationPracticePaymentElement = new AutomationPracticePayment(driver);
            automationPracticePaymentElement.clickLink_PayByBankWire();

            // Step 15: Click on "I Confirm my order"
            AutomationPracticeWireBankOrderConfirmation automationPracticeWireBankOrderConfirmationElement = new AutomationPracticeWireBankOrderConfirmation(driver);
            automationPracticeWireBankOrderConfirmationElement.clickIConfirmMyOrder();

            // Step 16: Verify successful order confirmation by validating the message "Your order on My Store is complete.
                AutomationPracticeOrderConfirmation automationPracticeOrderConfirmationElement = new AutomationPracticeOrderConfirmation(driver);
                automationPracticeOrderConfirmationElement.ensureConfirmMyOrder();

            // Step 17: Fetch the wire details: the total amount, name of account owner, name of bank
            automationPracticeOrderConfirmationElement.fetchWireDetails();


        }
    }

