package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasicPage
{
    @FindBy(css = "input#Login_EmailAddress")
    private WebElement emailInput;
    @FindBy(css = "input#Login_Password")
    private WebElement passwordInput;
    @FindBy(id = "Login_Password-error")
    private WebElement passwordError;
    @FindBy(css = "a#LoginButton")
    private WebElement signInButton;
    @FindBy(id = "Login_EmailAddress-error")
    private WebElement emailError;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public boolean emailErrorHasText(String error) {
        return emailError.getText().equals(error);
    }
    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage clickLogin() {
        signInButton.click();
        return this;
    }

    public boolean passwordErrorHasText(String error) {
        return passwordError.getText().equals(error);
    }
    public boolean isPasswordErrorVisible() {
        return passwordError.isDisplayed();
    }

}
