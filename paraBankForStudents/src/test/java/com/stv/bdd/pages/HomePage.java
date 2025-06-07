package com.stv.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.PageFactory.*;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "txtSearch")
    WebElement searchField;

    @FindBy(id = "cmdSearch")
    WebElement searchButton;

    @FindBy(css = ".product-description")
    List<WebElement> productDescriptions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void searchFor(String keyword) {
        searchField.sendKeys(keyword);
        searchButton.click();
    }

    public List<String> getSearchResultDescriptions() {
        return productDescriptions.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}