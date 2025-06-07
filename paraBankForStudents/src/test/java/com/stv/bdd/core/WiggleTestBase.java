package com.stv.bdd.core;

import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;

public class WiggleTestBase {

    private static WebDriver driver;

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            driver = MyDriver.getDriver();
        }
        return driver;
    }
    public static synchronized void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            MyDriver.resetDriver();
        }
    }
}

