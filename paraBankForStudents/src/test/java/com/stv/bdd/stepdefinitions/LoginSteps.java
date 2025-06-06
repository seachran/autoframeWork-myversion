package com.stv.bdd.stepdefinitions;


import com.stv.bdd.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void goToLoginPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wiggle.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter an invalid email and password")
    public void enterInvalidCredentials() {
        loginPage.enterEmail("fake@example.com");
        loginPage.enterPassword("WrongPass123");
    }

    @And("I click the Sign In button")
    public void clickSignInButton() {
        loginPage.clickSignIn();
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected: " + expectedMessage + " but got: " + actualMessage);
        driver.quit();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        goToLoginPage();
    }

    @Then("the password field should have a show password toggle")
    public void verifyShowPasswordIsPresent() {
        boolean hasToggle = loginPage.isShowPasswordFeaturePresent();
        Assert.assertTrue(hasToggle, "Defect: 'Show password' toggle is missing but was expected.");
        String typeBefore = loginPage.getPasswordFieldType();
        loginPage.clickShowPasswordButton();
        String typeAfter = loginPage.getPasswordFieldType();
        Assert.assertEquals(typeBefore, "password", "Password field should initially be of type 'password'");
        Assert.assertEquals(typeAfter, "text", "Password field should toggle to 'text' after clicking the toggle");
    }

    @Given("the user is on the <page> page")
    public void theUserIsOnThePagePage() {
    }
}
