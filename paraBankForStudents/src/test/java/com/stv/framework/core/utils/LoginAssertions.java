package com.stv.framework.core.utils;

import com.stv.factory.factorypages.LoginPage;
import org.testng.Assert;

public class LoginAssertions {
    public static void assertEmailError(LoginPage page, String expectedMessage, String failureMessage) {
        Assert.assertTrue(page.isEmailErrorVisible(), failureMessage + ": not visible.");
        Assert.assertTrue(page.emailErrorHasText(expectedMessage), failureMessage + ": wrong message text.");
    }

    public static void assertPasswordError(LoginPage page, String expectedMessage, String failureMessage) {
        Assert.assertTrue(page.isPasswordErrorVisible(), failureMessage + ": not visible.");
        Assert.assertTrue(page.passwordErrorHasText(expectedMessage), failureMessage + ": wrong message text.");
    }
}
