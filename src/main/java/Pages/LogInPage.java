package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {

    // Locators for the login page
    private By logInButton = By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[3]");
    private By emailField = By.id("email");
    private By passwordField = By.id("am-pass");
    private By submitLogInButton = By.id("customer-form-login-popup-send2");
    private By googleLoginButton = By.cssSelector("#amsl-login-content > div.amsl-social-wrapper > div > div > div:nth-child(1) > a ");
    private By facebookLoginButton = By.cssSelector("#amsl-login-content > div.amsl-social-wrapper > div > div > div:nth-child(2) > a");

    // Constructor
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    // Method to click the login button
    public void clickLoginButton() {
        Utility.clickingOnElement(driver, logInButton);
    }

    // Method to enter email
    public void enterEmail(String email) {
        Utility.sendData(driver, emailField, "######");
    }

    // Method to enter password
    public void enterPassword(String password) {
        Utility.findWebElement(driver, passwordField).sendKeys("######");
    }

    // Method to click the login button
    public void clickSubmitLogIn() {
        Utility.clickingOnElement(driver, submitLogInButton);
    }

    // Method to click Google Login
    public void clickGoogleLoginButton() {
        Utility.findWebElement(driver, googleLoginButton).click();
    }

    // Method to click Facebook Login
    public void clickFacebookLoginButton() {
        Utility.findWebElement(driver, facebookLoginButton).click();
    }

    // Method to perform login
    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
