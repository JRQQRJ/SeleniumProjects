package com.selenium.practice.orangeCRM.tests;

import com.selenium.practice.frameworks.FrameworkClass1BaseTest;
import com.selenium.practice.frameworks.POMBaseTest;
import com.selenium.practice.frameworks.TestAssertions;
import com.selenium.practice.orangecrm.pages.DashboardPage;
import com.selenium.practice.orangecrm.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends POMBaseTest{

    // Everytime the login test executes--> the before and after tests get called

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);

        // we are able to use below command only because we are specifying the class name as return type for respective methods

        DashboardPage dashboardPage = loginPage.launchOrangeCRMWebsite().enterUserName("Admin").enterPassword("admin123").hitSubmit();
        String text = dashboardPage.getWelcomeMessage();
        //Assert.assertTrue(text.contains("Welcome"));

        /*
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.hitSubmit();
        loginPage.launchOrangeCRMWebsite().enterUserName("Admin").enterPassword("admin123").hitSubmit();
        DashboardPage dashboardPage = new DashboardPage(driver); //initailizes all methods of the clas Dashboardpage using the constructor
        String text = dashboardPage.getWelcomeMessage();
        Assert.assertTrue(text.contains("Welcome"));

        */
        TestAssertions.checkIFValueContains("Welcome", text);// used instead of  Assert.assertTrue(text.contains("Welcome"));
     }

}
