package com.selenium.practice.frameworks;

import com.selenium.practice.orangecrm.pages.DashboardPage;
import com.selenium.practice.orangecrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameClass1LoginTest extends FrameworkClass1BaseTest {


    @Test
    public void testLogin() throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = loginPage.launchOrangeCRMWebsite().enterUserName("Admin").enterPassword("admin123").hitSubmit();
        String text = dashboardPage.getWelcomeMessage();

        TestAssertions.checkIFValueContains("Welcome", text);

    }

}
