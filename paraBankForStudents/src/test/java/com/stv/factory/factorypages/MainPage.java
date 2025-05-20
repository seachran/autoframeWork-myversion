package com.stv.factory.factorypages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasicPage {
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookiesButton;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginPageLink;
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage navigateToLoginPage() {
        loginPageLink.click();
        return new LoginPage(driver);
    }
    public MainPage acceptCookiesIfPresent() {
        acceptCookiesButton.click();
        return this;
    }
}