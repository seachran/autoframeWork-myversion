package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasicPage {

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(css = ".dnnFormItem.passwordNote")
    private WebElement passwordNote;
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public boolean isPasswordNoteVisible() {
        return passwordNote.isDisplayed();
    }
}
