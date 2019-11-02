package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id=\"ordermsg\"]/textarea")
    public WebElement commentaryArea;

    @FindBy(name = "processAddress")
    public WebElement ProceedButton2;

    public void AdressTab(String text){
        commentaryArea.click();
        commentaryArea.sendKeys(text);
        ProceedButton2.click();
    }

    @FindBy(xpath = "//p[@class='checkbox']/div/span")
    public WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//p[@class='checkbox']//a[contains(., '(Read the Terms of Service)')]")
    public WebElement termsOfServiceDocumentNavigation;

    @FindBy(xpath = "//div[@class='fancybox-skin']//a[@title='Close']")
    public WebElement closeTermsOfServiceButton;

    @FindBy(name = "processCarrier")
    public WebElement ProceedButton3;
   //
    public void ShippingTab() throws InterruptedException {
        termsOfServiceDocumentNavigation.click();
        Thread.sleep(10000);
        closeTermsOfServiceButton.click();
        Thread.sleep(10000);
        termsOfServiceCheckbox.click();
        ProceedButton3.click();
    }

    @FindBy(className = "bankwire")
    public WebElement CardPaymentMethButton;

    @FindBy(xpath = "//button[@type='submit']//span[contains(., 'confirm')]")
    public WebElement confirmOrderButton;

    public void PaymentOrder(){
        CardPaymentMethButton.click();
        confirmOrderButton.click();
    }

}