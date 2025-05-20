package com.stv.factory.factorytests;

import com.stv.factory.factorypages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private static final String EMPTY = "";
    private static final String EMAIL_EMPTY_ERROR = "Please provide an email address";
    private static final String EMAIL_INCORRECT_ERROR = "The Email Address field is not a valid e-mail address.";
    private static final String PASSWORD_EMPTY_ERROR = "Please provide a password";

    private static final String EMAIL_INCORRECT = "qwerty@";
    private static final String PASSWORD_CORRECT = "qwerty123";

    private static final String MAIN_URL = "https://www.wiggle.com";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
    }

    @Test(description = "Check login with empty email and password fields")
    public void signInWithEmptyFields() {

        var mainPage = new MainPage(driver);
        var loginPage = mainPage
                .acceptCookiesIfPresent()
                .navigateToLoginPage();

        loginPage.enterEmail(EMPTY)
                .enterPassword(EMPTY)
                .clickLogin();

        Assert.assertTrue(loginPage.isEmailErrorVisible(), "Empty email error message should be displayed.");
        Assert.assertTrue(loginPage.isPasswordErrorVisible(), "Empty password error message should be displayed.");

        Assert.assertTrue(loginPage.emailErrorHasText(EMAIL_EMPTY_ERROR));
        Assert.assertTrue(loginPage.passwordErrorHasText(PASSWORD_EMPTY_ERROR));
    }

    @Test(description = "Check login with invalid email")
    public void signInWithInvalidEmail() {

        var mainPage = new MainPage(driver);
        var loginPage = mainPage
                .acceptCookiesIfPresent()
                .navigateToLoginPage();

        loginPage.enterEmail(EMAIL_INCORRECT)
                .enterPassword(PASSWORD_CORRECT)
                .clickLogin();

        Assert.assertTrue(loginPage.isEmailErrorVisible(), "Invalid email error message should be displayed");
        Assert.assertTrue(loginPage.emailErrorHasText(EMAIL_INCORRECT_ERROR));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}