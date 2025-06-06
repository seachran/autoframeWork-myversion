package com.stv.bdd.pages;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "input[name='Login.EmailAddress']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//a[@id='LoginButton' and span[text()='Sign In Securely']]")
    WebElement signInButton;

    @FindBy(id = "Login_EmailAddress-error")
    WebElement errorMessage;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieAcceptButton;

    @FindBy(css = "button.show-password, .toggle-password, .eye-icon, .reveal-password")
    List<WebElement> showPasswordButtons;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        acceptCookiesIfPresent();
    }

    public void enterEmail(String email) {
        acceptCookiesIfPresent();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        acceptCookiesIfPresent();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        acceptCookiesIfPresent();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void acceptCookiesIfPresent() {
        try {
            if (cookieAcceptButton.isDisplayed()) {
                cookieAcceptButton.click();
            }
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
    }

    public String getPasswordFieldType() {
        return passwordField.getAttribute("type");
    }

    public boolean isShowPasswordFeaturePresent() {
        return !showPasswordButtons.isEmpty();
    }

    public void clickShowPasswordButton() {
        if (!showPasswordButtons.isEmpty()) {
            showPasswordButtons.get(0).click();
        }
    }
}
