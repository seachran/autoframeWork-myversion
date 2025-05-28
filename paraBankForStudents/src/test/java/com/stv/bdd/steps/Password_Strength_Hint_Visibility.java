package com.stv.bdd.steps;

import com.stv.factory.factorypages.MainPage;
import com.stv.factory.factorypages.RegistrationPage;
import com.stv.framework.core.drivers.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class Password_Strength_Hint_Visibility {

    private RegistrationPage registrationPage;

    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    @Given("registration page is loaded")
    public void registrationPageLoaded() {
        var driver = getDriver();
        driver.get(START_URL);
        driver.manage().window().maximize();

        var mainPage = new MainPage(driver);
        var loginPage = mainPage.waitForAllowCookies()
                .acceptCookiesIfPresent()
                .navigateToLoginPage();

        registrationPage = loginPage.navigateToRegistrationPage();
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
}
