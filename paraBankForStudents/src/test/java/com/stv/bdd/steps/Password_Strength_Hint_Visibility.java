package com.stv.bdd.steps;

import com.stv.factory.factorypages.MainPage;
import com.stv.factory.factorypages.RegistrationPage;
import com.stv.framework.core.drivers.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Password_Strength_Hint_Visibility {

    private RegistrationPage registrationPage;

    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    @Given("registration page is loaded")
    public void registrationPageLoaded() {
        registrationPage = new MainPage(getDriver())
                .openMainPage()
                .prepareAndNavigateToLoginPage()
                .navigateToRegistrationPage();
    }

    @When("the user enters {string} into the new password field")
    public void enterTextToPasswordField(String password) {
        registrationPage.enterPassword(password);
    }

    @Then("the password note should be {string}")
    public void checkPasswordNoteVisibility(String visibility) {
        boolean shouldBeVisible = visibility.equalsIgnoreCase("visible");
        boolean isActuallyVisible = registrationPage.isPasswordNoteVisible();

        Assert.assertEquals(shouldBeVisible, isActuallyVisible);
    }

    @Given("the registration form is open")
    public void theRegistrationFormIsOpen() {
    }
}
