package com.stv.bdd.stepdefinitions;

import com.stv.bdd.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private WebDriver browser;
    private LoginPage loginForm;

    @Given("I am on the login page")
    public void openLoginPage() {
        ChromeOptions config = new ChromeOptions();
        config.addArguments("--disable-blink-features=AutomationControlled");
        config.addArguments("start-maximized");

        browser = new ChromeDriver(config);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.wiggle.com/login");

        loginForm = new LoginPage(browser);
    }

    @When("I enter an invalid email and password")
    public void inputIncorrectCredentials() {
        loginForm.enterEmail("fake@example.com");
        loginForm.enterPassword("WrongPass123");
    }

    @And("I click the Sign In button")
    public void pressSignIn() {
        loginForm.clickSignIn();
    }

    @Then("I should see an error message {string}")
    public void checkErrorMessage(String expectedText) {
        String actualText = loginForm.getErrorMessage();
        Assert.assertTrue(actualText.contains(expectedText),
                "Expected error message: \"" + expectedText + "\", but found: \"" + actualText + "\"");
        browser.quit();
    }

    @Given("the user is on the login page")
    public void userNavigatesToLoginPage() {
        openLoginPage();
    }

    @Then("the password field should have a show password toggle")
    public void checkPasswordVisibilityToggle() {
        boolean toggleExists = loginForm.isShowPasswordFeaturePresent();
        Assert.assertTrue(toggleExists, "'Show password' toggle was expected but not found.");

        String initialType = loginForm.getPasswordFieldType();
        loginForm.clickShowPasswordButton();
        String newType = loginForm.getPasswordFieldType();

        Assert.assertEquals(initialType, "password", "Expected the input type to be 'password' initially.");
        Assert.assertEquals(newType, "text", "Expected the input type to change to 'text' after toggle.");
    }

    @Given("the user is on the <page> page")
    public void userIsOnPlaceholderPage() {
    }
}

