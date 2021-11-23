package com.selenium.practice.frameworks;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestAssertions {

    public static void checkIFTrue() {

    }

    public static void checkIFElementDisplayed(WebElement element) {

    }

    public static void checkIFValuesAreEqual(String value1, String value2) {

        Assert.assertEquals(value1, value2, "Value1 [\" + value1 + \"] and Value2 [\"+value2+\"] are not equal");
    }
    public static void checkIFValueContains(String valueToCheck, String value) {
        Assert.assertTrue(value.contains(valueToCheck),"Value1 [\" + value1 + \"] and Value2 [\"+value2+\"] are not equal");
    }

}
