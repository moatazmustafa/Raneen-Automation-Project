package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SSRegistrationPage extends BasePage {

    private By screenTypeDropdown = By.id("screen_type");
    private By identifierField = By.id("identifier");
    private By passwordField = By.id("password");
    private By phoneField = By.id("phone");
    private By submitButton = By.cssSelector("#screen-setup-form > div.actions-toolbar > div > button");
    private By generateMyBarcode = By.cssSelector("#smartstore-phone > button");
    private By otpField = By.id("otp");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By submitRegistration = By.cssSelector("#smartstore-register > button");

    public SSRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void selectScreenType(String option) {
        selectFromDropdown(screenTypeDropdown, option);
    }

    public void enterIdentifier(String identifier) {
        sendKeys(identifierField, identifier);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterPhone(String phone) {
        sendKeys(phoneField, phone);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void generateMyBarcode() {
        click(generateMyBarcode);
    }

    public void submitRegistration() {
        click(submitRegistration);
    }

    public void enterOtp(String otp) {
        sendKeys(otpField, otp);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }
}
