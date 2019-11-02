package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className="login")
    WebElement signin;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(id="SubmitLogin")
    WebElement submit;

    public void login(String username, String pass) throws InterruptedException {
        signin.click();
        Thread.sleep(3000);
        email.sendKeys(username);
        password.sendKeys(pass);
        submit.click();
    }

}
