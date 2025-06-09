package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;
import static com.stv.framework.core.utils.Waiters.waitForElementVisible;

public class MainPage extends BasicPage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginPageLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(START_URL);
        driver.manage().window().maximize();
        return this;
    }

    public LoginPage prepareAndNavigateToLoginPage() {
        return this
                .waitForAllowCookies()
                .acceptCookiesIfPresent()
                .navigateToLoginPage();
    }

    private MainPage waitForAllowCookies() {
        waitForElementVisible(driver,
                Duration.ofSeconds(25),
                acceptCookiesButton);
        return this;
    }

    private MainPage acceptCookiesIfPresent() {
        acceptCookiesButton.click();
        return this;
    }

    private LoginPage navigateToLoginPage() {
        loginPageLink.click();
        return new LoginPage(driver);
    }
}