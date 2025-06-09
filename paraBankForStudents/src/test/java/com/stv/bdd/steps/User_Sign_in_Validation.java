package com.stv.bdd.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainPage;
import com.stv.framework.core.data.ErrorMessages;
import com.stv.framework.core.data.TestData;
import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.core.utils.LoginAssertions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class User_Sign_in_Validation {
    private LoginPage loginPage;

    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    @Given("login page is loaded")
    public void loginPageLoaded() {
        loginPage = new MainPage(getDriver())
                .openMainPage()
                .prepareAndNavigateToLoginPage();
    }

    @When("the user enters correct email into the email field")
    public void correctEmailEntered() {
        loginPage.enterEmail(TestData.EMAIL_CORRECT);
    }

    @When("the user enters empty password")
    public void emptyPasswordEntered() {
        loginPage.enterPassword(TestData.EMPTY);
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
        LoginAssertions.assertEmailError(loginPage, ErrorMessages.EMAIL_EMPTY_ERROR, "The empty email error message should be displayed");
    }

    @Then("the empty password error message is displayed")
    public void passwordEmptyError() {
        LoginAssertions.assertPasswordError(loginPage, ErrorMessages.PASSWORD_EMPTY_ERROR, "The empty password error message should be displayed");
    }

    @Then("the invalid email error message is displayed")
    public void emailIncorrectError() {
        LoginAssertions.assertEmailError(loginPage, ErrorMessages.EMAIL_INVALID_ERROR, "The invalid email error message should be displayed");
    }

    @After
    public void closeWebDriver() {
        getDriver().quit();
    }

}
