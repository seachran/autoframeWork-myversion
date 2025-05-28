package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage
{
    @FindBy(xpath = "//a[@href='/registration?returnUrl=%2f']")
    private WebElement registrationPageLink;
    @FindBy(css = "input#Login_EmailAddress")
    private WebElement emailInput;

    @FindBy(id = "Login_EmailAddress-error")
    private WebElement emailError;

    @FindBy(css = "input#Login_Password")
    private WebElement passwordInput;

    @FindBy(id = "Login_Password-error")
    private WebElement passwordError;

    @FindBy(css = "a#LoginButton")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        signInButton.click();
        return this;
    }

    public RegistrationPage navigateToRegistrationPage() {
        registrationPageLink.click();
        return new RegistrationPage(driver);
    }

    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public boolean emailErrorHasText(String error) {
        return emailError.getText().equals(error);
    }

    public boolean isPasswordErrorVisible() {
        return passwordError.isDisplayed();
    }

    public boolean passwordErrorHasText(String error) {
        return passwordError.getText().equals(error);
    }
}
