package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("login");
    private By loginButton = By.xpath("//form[@id='login-form']/fieldset/div[3]/div/button/span");
    private By oceanTab = By.xpath("//li[@id='menu-ocean-core-ocean']/a");
    private By otpTab = By.xpath("//li[@id='menu-ocean-core-ocean']/div/ul/li[2]/ul/li/div/ul/li[4]/a/span");
    private By otpValue = By.xpath("//tbody/tr/td[3]");
    private By customersTab = By.xpath("//nav/ul/li[8]/a/span");
    private By allCustomersTab = By.xpath("//li[8]/div/ul/li/a/span");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        Utility.clickingOnElement(driver, loginButton);
    }

    public void navigateToOtpTab() {
        click(oceanTab);
        click(otpTab);
    }

    public String getOtp() {
        return getText(otpValue);
    }

    public void navigateToCustomersTab() {
        click(customersTab);
        click(allCustomersTab);
    }
}
