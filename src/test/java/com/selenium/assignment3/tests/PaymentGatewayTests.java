package com.selenium.assignment3.tests;

import com.selenium.assignment3.frameworks.EntryExitBase;
import com.selenium.assignment3.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PaymentGatewayTests extends EntryExitBase {

    String Cvv,Cn,Expy,Expm,Cl,cLimit;
    int paymentAmount;

    @Test
    public void testPaymentGatewayLaunch() throws Exception {
        PaymentGateway paymentGatewayObject = new PaymentGateway(driverx);
        String currentURL = paymentGatewayObject.launchPaymentGateway();
        Assert.assertEquals(currentURL,"http://demo.guru99.com/payment-gateway/index.php", "Invalid URL" );
        paymentGatewayObject.clickGenerateCardNumber();

        CardNumberFetchPage cardNumberFetchPageObject = new CardNumberFetchPage(driverx);
        this.Cn = cardNumberFetchPageObject.allotFetchCardNumber();
        this.Cvv=cardNumberFetchPageObject.allotFetchCvv();
        this.Expy=cardNumberFetchPageObject.allotFetchExpiryYear();
        this.Expm=cardNumberFetchPageObject.allotFetchExpiryMonth();
        this.Cl= cardNumberFetchPageObject.allotFetchCardlimit();

        this.Cl= cardNumberFetchPageObject.allotFetchCardlimit();
        cLimit = Cl.substring(1,4);
        int creditLimit = Integer.valueOf(cLimit);
        cardNumberFetchPageObject.displayCardNumberPageElementToUser();
        cardNumberFetchPageObject.clickCartButton();

        PurchaseToyPage purchase = new PurchaseToyPage(driverx);
        int quantityPurchased = purchase.selectQuantityAndClickBuy();

        PaymentProcessing paymentProcessingObject = new PaymentProcessing(driverx);
        paymentAmount =paymentProcessingObject.checkDisplayAmount();
        if(paymentAmount == (quantityPurchased * 20)){
            System.out.println("The right amount is reflected on the Pay button");
        }
        paymentProcessingObject.enterCardDetails(Cn,Cvv,Expm,Expy);
        paymentProcessingObject.clickPayBtn();

        PaymentConfirmationPage paymentConfirmationPageObject = new PaymentConfirmationPage(driverx);
        paymentConfirmationPageObject.displayMsgCheck();
        paymentConfirmationPageObject.fetchOrderID();
        paymentConfirmationPageObject.clickCheckCreditCardLimit();

        CreditCardBalance creditCardBalanceObject = new CreditCardBalance(driverx);
        creditCardBalanceObject.enterCCNAndSumit(Cn);

        CreditCardSummary creditCardSummaryObject = new CreditCardSummary(driverx);
        int creditCardBalance= creditCardSummaryObject.creditCardCurrentBalance();
        System.out.println("Credit card balance is: $" + creditCardBalance);

        if (creditCardBalance == (creditLimit - (20 * quantityPurchased))){
            System.out.println("The credit card balance is correct");
        }
        creditCardSummaryObject.orderId();
        }
    }
