package com.selenium.assignment4.part2tests;


import com.selenium.assignment4.part2.framewroks.openAndClose;
import com.selenium.assignment4.part2.pages.dashboardPage;
import com.selenium.assignment4.part2.pages.infoTabPage;
import com.selenium.assignment4.part2.pages.orangeHRMLoginPage;
import com.selenium.assignment4.part2.pages.logoutPage;
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
        welcomeNameCheck.clickInfoTab();
        infoTabPage checkUrl = new infoTabPage(driverx);
        String currentURL = checkUrl.checkUrl();
        Assert.assertEquals(currentURL,"https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails","Invalid Url");
        String fname = checkUrl.checkFirstName();
        String lname = checkUrl.CheckLastName();
        Assert.assertEquals(fname,"Paul","Name does not match");
        Assert.assertEquals(lname,"Collings","Name does not match");
        checkUrl.clickLogout();
        logoutPage logoutUrl= new logoutPage(driverx);
        String  currentUrl = logoutUrl.getLogoutPageUrl();
        Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/index.php/auth/login","Invalid Logout");
    }
}

