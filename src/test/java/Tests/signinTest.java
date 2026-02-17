package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
    private WebDriver driver;
    private BasePage basePage;

    // Define selectors
    private final By SIGN_IN_LINK = By.linkText("Sign In");
    private final By EMAIL_FIELD = By.id("email");
    private final By PASSWORD_FIELD = By.id("am-pass");
    private final By LOGIN_BUTTON = By.id("customer-form-login-popup-send2");
    private final By ERROR_MESSAGE = By.cssSelector("p.amsl-error.-default > div");
    // Using CSS Selector with class names


    // URL and credentials
    private final String URL = "https://www.raneen.com/en/";
    private final String VALID_EMAIL = "######";
    private final String VALID_PASSWORD = "######";
    private final String INVALID_EMAIL = "######";
    private final String INVALID_PASSWORD = "######";
    private final String EMPTY_STRING = "";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--disable-cache", "--disable-application-cache", "--incognito");
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        basePage.quitDriver();
    }

    // Positive Test Case: Successful login
    @Test
    public void testSuccessfulLogin() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        // Add assertion to verify login success
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed!");
    }

    // Negative Test Case: Invalid email and password
    @Test
    public void testInvalidEmailAndPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(INVALID_EMAIL, INVALID_PASSWORD);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Negative Test Case: Valid email with invalid password
    @Test
    public void testValidEmailInvalidPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(VALID_EMAIL, INVALID_PASSWORD);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Negative Test Case: Invalid email with valid password
    @Test
    public void testInvalidEmailValidPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(INVALID_EMAIL, VALID_PASSWORD);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Negative Test Case: Empty email and password
    @Test
    public void testEmptyEmailAndPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(EMPTY_STRING, EMPTY_STRING);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Negative Test Case: Empty email with valid password
    @Test
    public void testEmptyEmailValidPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(EMPTY_STRING, VALID_PASSWORD);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Negative Test Case: Valid email with empty password
    @Test
    public void testValidEmailEmptyPassword() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        loginPage.login(VALID_EMAIL, EMPTY_STRING);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Boundary Test Case: Email field max length
    @Test
    public void testEmailFieldMaxLength() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        String longEmail = "a".repeat(256) + "@test.com";
        loginPage.login(longEmail, VALID_PASSWORD);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // Boundary Test Case: Password field max length
    @Test
    public void testPasswordFieldMaxLength() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        String longPassword = "a".repeat(256);
        loginPage.login(VALID_EMAIL, longPassword);
        // Verify error message
        Assert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message not displayed!");
    }

    // UI Test Case: Verify Login Page Elements are Displayed
    @Test
    public void testLoginPageElementsDisplayed() {
        basePage.openUrl(URL);
        LoginPage loginPage = new LoginPage(driver, SIGN_IN_LINK, EMAIL_FIELD, PASSWORD_FIELD, LOGIN_BUTTON);
        loginPage.openLoginPage();
        // Verify elements are displayed
        Assert.assertTrue(driver.findElement(SIGN_IN_LINK).isDisplayed(), "Sign In link not displayed!");
        Assert.assertTrue(driver.findElement(EMAIL_FIELD).isDisplayed(), "Email field not displayed!");
        Assert.assertTrue(driver.findElement(PASSWORD_FIELD).isDisplayed(), "Password field not displayed!");
        Assert.assertTrue(driver.findElement(LOGIN_BUTTON).isDisplayed(), "Login button not displayed!");
    }
}
