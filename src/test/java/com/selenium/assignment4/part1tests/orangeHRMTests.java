package com.selenium.assignment4.part1tests;


import com.selenium.assignment4.part1.frameworks.openAndClose;
import com.selenium.assignment4.part1.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class orangeHRMTests extends openAndClose {

    @Test
    public void orangeHRMLoginPageTest() throws InterruptedException {
        orangeHRMLoginPage launchLoginPage = new orangeHRMLoginPage(driverx);
        launchLoginPage.launchOrangeHRMLoginPage();
        launchLoginPage.loginAction();
        dashboardPage welcomeNameCheck = new dashboardPage(driverx);
        String text = welcomeNameCheck.welcomeNameCheck();
        Assert.assertTrue(text.contains("Welcome"), "welcome greeting invalid");
        welcomeNameCheck.clickDirectoryTab();
        directoryPage validateDirectryPageUrl = new directoryPage(driverx);
        String pageURL= validateDirectryPageUrl.checkUrl();
        Assert.assertEquals(pageURL,"https://opensource-demo.orangehrmlive.com/index.php/directory/viewDirectory/reset/1", "URL's dont match");
        validateDirectryPageUrl.searchDirectory();
        directoryPageSearchResult directorySearchResult= new directoryPageSearchResult(driverx);
        String searchFieldName =directorySearchResult.searchResultName();
        Assert.assertEquals(searchFieldName, "Anthony Nolan", "Invalid user");
        directorySearchResult.clickLogout();
        logoutPage logoutUrl= new logoutPage(driverx);
        String  currentUrl = logoutUrl.getLogoutPageUrl();
        Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/index.php/auth/login","Invalid Logout");
    }
}

