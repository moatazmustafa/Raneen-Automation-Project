import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaymentMethodTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--disable-cache", "--disable-application-cache", "--incognito");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCODPayment() {
        driver.get("https://www.example.com");

        // Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login steps
        loginPage.clickSignIn();
        loginPage.enterUsername("*********");
        loginPage.enterPassword("*********");
        loginPage.showPassword();
        loginPage.clickLogin();

        // Handle welcome popup
        handleWelcomePopup(driver);

        // Product selection steps
        productPage.clickKidsAndToys();
        productPage.scrollTo(0, 338);
        productPage.clickToys();
        productPage.selectSorterOption("Product Name");
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        productPage.selectProduct();
        productPage.addToCart();

        // Wait for product to be added
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Cart and checkout steps
        cartPage.clickCartIcon();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        cartPage.proceedToCheckout();

        // Wait for checkout page
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Checkout process
        checkoutPage.scrollTo(0, 175);
        checkoutPage.proceedWithShipping();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        checkoutPage.selectCOD();
        checkoutPage.agreeToTerms();
        checkoutPage.placeOrder();

        // Wait for order confirmation
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Method to handle the welcome popup
    public void handleWelcomePopup(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for the popup close button to be visible and click it
            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-close-button"))); 
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Welcome popup did not appear. Continuing...");
        }
    }
}
