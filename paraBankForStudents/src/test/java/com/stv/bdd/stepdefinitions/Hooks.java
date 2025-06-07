package com.stv.bdd.stepdefinitions;

import com.stv.bdd.core.WiggleTestBase;
import com.stv.framework.core.lib.WigglePageURLs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    @Before
    public void initializeTest() {
        final WebDriver browser = WiggleTestBase.getDriver();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        browser.manage().window().maximize();
        browser.get(WigglePageURLs.START_URL);

        final WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        try {
            WebElement cookiePopup = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))
            );
            cookiePopup.click();
        } catch (Exception ignored) {
            System.out.println("No cookie prompt found or already dismissed.");
        }

        try {
            WebElement loginLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("loginMenu"))
            );
            loginLink.click();
        } catch (Exception e) {
            throw new RuntimeException("Could not click on the login menu.", e);
        }
    }

    @After
    public void cleanUpTest() {
        WiggleTestBase.quitDriver();
    }
}
