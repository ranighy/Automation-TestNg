package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    private By usernameInputLocator = By.id("username");
    private By passwordInputLocator = By.id("password");
    private By submitButtonLocator = By.id("submit");
    private By errorMessageLocator = By.id("error");

    public LoginPage (WebDriver driver) {
        super(driver);

    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    //it returns an instance of SuccessfulLoginPage, indicating the next page the user is navigated to upon a successful login.
    public SuccessfulLoginPage executeLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
        return new SuccessfulLoginPage(driver);
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessageElement.getText();
    }
}