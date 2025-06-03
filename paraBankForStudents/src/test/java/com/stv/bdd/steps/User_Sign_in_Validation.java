package com.stv.bdd.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainPage;
import com.stv.framework.core.drivers.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class User_Sign_in_Validation {

    private static final String EMPTY = "";

    private static final String EMAIL_CORRECT = "email@example.com";
    private static final String EMAIL_EMPTY_ERROR = "Please provide an email address";
    private static final String EMAIL_INVALID_ERROR = "The Email Address field is not a valid e-mail address.";
    private static final String PASSWORD_EMPTY_ERROR = "Please provide a password";
    private LoginPage loginPage;

    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    @Given("login page is loaded")
    public void loginPageLoaded() {
        var driver = getDriver();
        driver.get(START_URL);
        driver.manage().window().maximize();

        var mainPage = new MainPage(driver);
        loginPage = mainPage.waitForAllowCookies()
                .acceptCookiesIfPresent()
                .navigateToLoginPage();
    }

    @When("the user enters correct email into the email field")
    public void correctEmailEntered() {
        loginPage.enterEmail(EMAIL_CORRECT);
    }

    @When("the user enters empty password")
    public void emptyPasswordEntered() {
        loginPage.enterPassword(EMPTY);
    }

    @When("the user enters {string} into the password field")
    public void enterTextToPasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the sign in button")
    public void signInButtonClicked() {
        loginPage.clickLogin();
    }

    @When("the user enters {string} into the email field")
    public void enterTextToEmailField(String emailText) {
        loginPage.enterEmail(emailText);
    }

    @Then("the empty email error message is displayed")
    public void emailEmptyError() {
        Assert.assertTrue(loginPage.isEmailErrorVisible(), "The empty email error message should be displayed.");
        Assert.assertTrue(loginPage.emailErrorHasText(EMAIL_EMPTY_ERROR));
    }

    @Then("the empty password error message is displayed")
    public void passwordEmptyError() {
        Assert.assertTrue(loginPage.isPasswordErrorVisible(), "The empty password error message should be displayed.");
        Assert.assertTrue(loginPage.passwordErrorHasText(PASSWORD_EMPTY_ERROR));
    }

    @Then("the invalid email error message is displayed")
    public void emailIncorrectError() {
        Assert.assertTrue(loginPage.isEmailErrorVisible(), "The invalid email error message should be displayed.");
        Assert.assertTrue(loginPage.emailErrorHasText(EMAIL_INVALID_ERROR));
    }

    @After
    public void closeWebDriver() {
        getDriver().quit();
    }

    @Given("the login page is open")
    public void theLoginPageIsOpen() {
    }

    @When("the user enters a valid email address into the email field")
    public void theUserEntersAValidEmailAddressIntoTheEmailField() {
    }

    @And("the user leaves the password field empty")
    public void theUserLeavesThePasswordFieldEmpty() {
    }

    @And("the user clicks the sign in button")
    public void theUserClicksTheSignInButton() {
    }

    @Then("a password required error message should be shown")
    public void aPasswordRequiredErrorMessageShouldBeShown() {
    }

    @When("the user types {string} into the email field")
    public void theUserTypesIntoTheEmailField(String arg0) {
    }

    @And("the user types {string} into the password field")
    public void theUserTypesIntoThePasswordField(String arg0) {
    }

    @Then("an invalid email error message should be displayed")
    public void anInvalidEmailErrorMessageShouldBeDisplayed() {
    }
}
