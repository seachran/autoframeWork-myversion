package com.stv.bdd.stepdefinitions;

import com.stv.bdd.pages.LoginPage;
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
import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = WiggleTestBase.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(WigglePageURLs.START_URL);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie consent not displayed or already handled.");
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginMenu")));
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Login button is not clickable", e);
        }
    }

    @After
    public void tearDown() {
        WiggleTestBase.quitDriver();
    }
}
