package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "login")
    WebElement signin;
    @FindBy(id = "email_create")
    WebElement email;
    @FindBy(id = "SubmitCreate")
    WebElement submitcreate;

    public void createAccount(String username) throws InterruptedException {
        signin.click();
        Thread.sleep(3000);

        email.sendKeys(username);

        submitcreate.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id='id_gender2']")
    WebElement gender;
    @FindBy(id = "customer_firstname")
    WebElement firstname;
    @FindBy(id = "customer_lastname")
    WebElement lastname;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "days")
    WebElement day;
    @FindBy(id = "months")
    WebElement month;
    @FindBy(id = "years")
    WebElement year;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement add_city;
    @FindBy(id = "id_country")
    WebElement country;
    @FindBy(id = "id_state")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement zipcode;
    @FindBy(id = "phone_mobile")
    WebElement phoneno;
    @FindBy(id = "submitAccount")
    WebElement register;


    public void register(String fname, String lname, String pwd,
                         String address1, String city, String statename, String pincode, String countryname, String pnumber)
            throws InterruptedException {
        Thread.sleep(2000);
        gender.click();
        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        password.sendKeys(pwd);
        selectdate();
        address.sendKeys(address1);
        add_city.sendKeys(city);
        state.sendKeys(statename);
        zipcode.sendKeys(pincode);
        country.sendKeys(countryname);
        phoneno.sendKeys(pnumber);
        register.click();
    }

    public void selectdate() {
        Select selday = new Select(day);
        selday.selectByIndex(2);
        Select selmonth = new Select(month);
        selmonth.selectByIndex(2);
        Select selyear = new Select(year);
        selyear.selectByIndex(20);
    }

}
