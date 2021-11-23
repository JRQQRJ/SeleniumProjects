package com.selenium.Assignment5;

import com.selenium.assignment5.framework.BaseTest;
import com.selenium.assignment5.pages.AddEmployeeUnderPIM;
import com.selenium.assignment5.pages.DashboardPage;
import com.selenium.assignment5.pages.OrangeHRMLoginPage;
import com.selenium.assignment5.pages.LogoutFunction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.UUID;

public class Assignment5OrangHRMTests extends BaseTest {

    String firstname = "Tarun";
    String lastname ="Sachdeva";
    String empID= "001";
    String rUserName = UUID.randomUUID().toString();
    String rPassword = UUID.randomUUID().toString();

    @Test
    public void allTestCases() throws InterruptedException {

        OrangeHRMLoginPage loginPageElemenet = new OrangeHRMLoginPage(driver);
        loginPageElemenet.launchOrangeHRMLoginPAge();
        loginPageElemenet.enterUserName("Admin");
        loginPageElemenet.enterPassword("admin123");
        loginPageElemenet.hitSubmit();
        DashboardPage dashboardPageElement = new DashboardPage(driver);
        String text = dashboardPageElement.welcomeNameCheck();
        Assert.assertTrue(text.contains("Welcome"), "welcome greeting invalid");
        System.out.println("You have successfully logged in using the following credentials" );
        System.out.println("Username: Admin, Password: admin123" );
        dashboardPageElement.clickEmployeeListUnderPIM();
        AddEmployeeUnderPIM addEmployeeUnderPIMElement = new AddEmployeeUnderPIM(driver);
        addEmployeeUnderPIMElement.inputFirstAndLastNameAndEnterEmployeeID(firstname,lastname,empID);
        addEmployeeUnderPIMElement.clickOnCreateLoginDEtails();
        addEmployeeUnderPIMElement.enterUniqueUsernameAndPasswordAndConfirmPasswordAndSave(rUserName,rPassword);
        System.out.println("You have successfully added a new employee and you have created new login credentials" );
        System.out.println("New Employee Name : " + firstname + lastname +" , Employee ID: " + empID);
        System.out.println("Username: " + rUserName + " , Password: "+ rPassword );
        LogoutFunction logoutFunctionElement = new LogoutFunction(driver);
        logoutFunctionElement.clickWelcomeUsernameBtnAndLogout();
        loginPageElemenet.enterUserName(rUserName);
        loginPageElemenet.enterPassword(rPassword);
        loginPageElemenet.hitSubmit();
        String welcomeText = dashboardPageElement.welcomeNameCheck();
        Assert.assertTrue(welcomeText.contains("Welcome Tarun"), "welcome greeting invalid");
        System.out.println("New employee " + firstname+" "+ lastname + " is able to log in using the new  login credentials" );
        logoutFunctionElement.clickWelcomeUsernameBtnAndLogout();

    }

}
