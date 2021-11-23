package com.selenium.Assignment6;

import com.selenium.assignment5.framework.BaseTest;
import com.selenium.assignment5.pages.AddEmployeeUnderPIM;
import com.selenium.assignment5.pages.DashboardPage;
import com.selenium.assignment5.pages.LogoutFunction;
import com.selenium.assignment5.pages.OrangeHRMLoginPage;
import com.selenium.assignment6.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.UUID;

public class ParasoftTests extends BaseTest {


    String accountHolderUsername = "Username";
    String accountHolderPassword = "Parabank123";
    double accountBalance;
    int accountNumber;
    String payeeName = "Tarun Sachdeva";
    String payeeAddress = "123 Erinmills Road";
    String payeeCity="Mississauga";
    String payeeState="Ontario";
    String payeeZipcode="L6D1R2";
    String payeePhoneNumber= "647111111";
    String payeeAccountNumber=" 22222";
    String payeeAmount ="100";
    double amountToBeTransfered = Double.valueOf(payeeAmount);
    String beforeDateforTransactionSearch = "10-20-2021";
    String afterDateforTransactionSearch = "11-12-2021";

        @Test
    public void allTestCases() throws InterruptedException {

        ParasoftLoginPage parasoftLoginPageElement = new ParasoftLoginPage(driver);
        parasoftLoginPageElement.launchParasoftLoginPage();
        parasoftLoginPageElement.enterUsernameAndPasswordAndClickLogin(accountHolderUsername,accountHolderPassword);
        AccountsOverview accountsOverviewElement = new AccountsOverview(driver);
        accountNumber = accountsOverviewElement.fetchAccountNumber();
        accountBalance =accountsOverviewElement.fetchAccountBalance();
        System.out.println("Validation point 1");
        System.out.println("__________________");
        System.out.println("Your account balance is: "+ accountBalance);
        if(accountBalance>0){
            Assert.assertTrue(accountBalance>=0,"Account balance is less than or equal to zero");
            System.out.println("Your account balance is greater than 0 ");
        }else {
                return;
            }
        accountsOverviewElement.setClickBillPay();
        BillPayment billPaymentElement =new BillPayment(driver);
        double paidAmount = Double.valueOf(payeeAmount);
        if(accountBalance>amountToBeTransfered) {
            System.out.println();
            System.out.println("Validation point 2");
            System.out.println("__________________");
            System.out.println("You have suficient balance for this transfer");
            billPaymentElement.performBillPayment(payeeName, payeeAddress, payeeCity, payeeState, payeeZipcode, payeePhoneNumber, payeeAccountNumber, payeeAmount);
            String confirmationMessage =billPaymentElement.billPaymentConfimation();
            System.out.println();
            System.out.println("Validation point 3");
            System.out.println("__________________");
            if(confirmationMessage.contains(payeeAmount))
            {
                System.out.println("Transfer amount is displayed correctly on the Bill Payment Page");
            }else {
                System.out.println("Transfer amount is incorrectly displayed correctly on the Bill Payment Page");
            }
                System.out.println("You have successfully transfered: $"+ payeeAmount);
                billPaymentElement.clickAccountsOverview();
                double newAccountBalance = accountsOverviewElement.fetchAccountBalance();
                 if (newAccountBalance== (accountBalance - paidAmount)){
                     System.out.println();
                System.out.println("Validation point 4");
                     System.out.println("__________________");
                System.out.println("Your account balance after transaction is: "+ newAccountBalance);

                 }else {
                System.out.println("Incorrect account balance displayed");
                }

            accountsOverviewElement.clickOnAccount();
            AccountDetails accountDetailsElement = new AccountDetails(driver);
            accountDetailsElement.fetchTransaction();
            TransactionDetails transactionDetails = new TransactionDetails(driver);
            String transactionId =  transactionDetails.fetchTransactionId();
            String transactionDate =  transactionDetails.fetchTransactionDate();
            String transactionDescription = transactionDetails.fetchTransactionDescription();
            String transactionType =transactionDetails.fetchTransactionType();
            String transactionAmount =transactionDetails.fetchTransactionAmount();
            String transactionURL = transactionDetails.getCurrentURl();

            transactionDetails.clickFindTransactionPage();
            FindTransactionPage findTransactionPageElement = new FindTransactionPage(driver);
            findTransactionPageElement.enterBeforeAndAfterDateAndSearch(beforeDateforTransactionSearch,afterDateforTransactionSearch);
            TransactionResultPage transactionResultPageElement = new TransactionResultPage(driver);
            String transactionRecord = transactionResultPageElement.transactionOnPage();
            if(transactionRecord.contains("a")){
                System.out.println();
                System.out.println("Validation point 5");
                System.out.println("__________________");
                System.out.println("Your transaction is listed on the Transaction Results");
                transactionResultPageElement.clickTransactionOnPage();
            }
            String presentURL = driver.getCurrentUrl();
            System.out.println();
            System.out.println("Validation point 6");
            System.out.println("__________________");
            Assert.assertEquals(presentURL,transactionURL,"URL are not same hence all values are invalid");
            System.out.println("Transaction URL: " + transactionURL);
            System.out.println("Current URL: "+ presentURL);
            System.out.println("TransactionId:" +transactionId);
            System.out.println("TransactionDate:" +transactionDate);
            System.out.println("TransactionDescription:" +transactionDescription);
            System.out.println("TransactionType:" +transactionType);
            System.out.println("TransactionAmount:" +transactionAmount);


        }
    }
}
