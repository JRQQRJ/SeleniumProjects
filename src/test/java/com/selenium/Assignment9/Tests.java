package com.selenium.Assignment9;

import com.selenium.assignment9.framework.BaseTest;
import com.selenium.assignment9.pages.*;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    String email ="info@prodigylabs.net";
    String Address ="80 Richmond St. West, Suite 1401\n" +
            "Toronto, ON";




        @Test
    public void allTestCases() throws InterruptedException {

            // Step 1 : Login to http://automationpractice.com/index.php
            MainPage mainPageElement = new MainPage(driver);
            mainPageElement.launchAutomationPracticeMain();

            // Step 2 : Click on verify button
            mainPageElement.clickBtnVerify();

            Thread.sleep(5000);

             // Step 3 : Verify Email
            ContactPage contactPageElement = new ContactPage(driver);
            contactPageElement.verifyEmail(email);

            // Step 4 : Verify Address
            contactPageElement.verifyAddress(Address);

            Thread.sleep(3000);

            // Step 5 : Enter credentials
            contactPageElement.Enter_FirstName("Glen");
            Thread.sleep(3000);
            contactPageElement.Enter_LastName("Strugis");
            Thread.sleep(2000);
            contactPageElement.Enter_Email("glen.stugis@hotmail.com");
            Thread.sleep(2000);
            contactPageElement.Click_Industry();
            Thread.sleep(2000);
            contactPageElement.Enter_City("Toronto");
            Thread.sleep(2000);
            contactPageElement.ClickSubmit();

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

