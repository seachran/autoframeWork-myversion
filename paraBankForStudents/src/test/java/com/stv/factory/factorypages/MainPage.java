package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.stv.framework.core.utils.Waiters.waitForElementVisible;

public class MainPage extends BasicPage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginPageLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLoginPage() {
        loginPageLink.click();
        return new LoginPage(driver);
    }

    public MainPage waitForAllowCookies() {
        waitForElementVisible(driver,
                Duration.ofSeconds(25),
                acceptCookiesButton);
        return this;
    }

    public MainPage acceptCookiesIfPresent() {
        acceptCookiesButton.click();
        return this;
    }
}