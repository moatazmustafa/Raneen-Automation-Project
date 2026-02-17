package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SellAtRaneenPage extends BasePage {


    // Locators
    private By sellerNameField = By.cssSelector("#full_name");
    private By phoneField = By.cssSelector("#phone_number");
    private By emailField = By.cssSelector("#email");
    private By nationalIDField = By.cssSelector("#national_id");
    private By companyNameField = By.cssSelector("#business_name");
    private By recaptcha = By.xpath("/html/body/div[3]/main/div[4]/main/form/div[6]/div/div/div/div");
    private By termsLinkText = By.cssSelector("#terms-link");
    private By closeTermsButton = By.cssSelector("#html-body > div.modals-wrapper > aside > div.modal-inner-wrap > footer > button");
    private By termsCheckbox = By.xpath("/html/body/div[3]/main/div[4]/main/form/div[7]/div/input");
    private By submitButton = By.cssSelector("#submit-button");

    // Constructor
    public SellAtRaneenPage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with elements
    public void enterSellerName(String sellerName) {
        Utility.sendData(driver, sellerNameField, sellerName);
    }

    public void enterPhone(String phone) {
        Utility.sendData(driver, phoneField, phone);
    }

    public void enterEmail(String email) {
        Utility.sendData(driver, emailField, email);
    }

    public void enterNationalID(String nationalID) {
        Utility.sendData(driver, nationalIDField, nationalID);
    }

    public void enterCompanyName(String companyName) {
        Utility.sendData(driver, companyNameField, companyName);
    }

    public void termsCheckbox() {
        Utility.clickingOnElement(driver, termsCheckbox);
    }

    public void TermsLinkText() {
        Utility.clickingOnElement(driver, termsLinkText);
    }

    public void CloseTermsButton() {
        Utility.clickingOnElement(driver, closeTermsButton);
    }

    public void recaptchaButton() {
        Utility.clickingOnElement(driver, recaptcha);
    }

    public void clickSubmit() {
        Utility.clickingOnElement(driver, submitButton);
    }
}

