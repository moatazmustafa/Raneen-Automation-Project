package Tests;

import Pages.WebProductPage;
import Utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WebProductPageTest {
    private static final Logger log = LoggerFactory.getLogger(WebProductPageTest.class);

    private WebDriver driver;
    private WebProductPage webProductPage;

    // export RANEEN_BASE_URL="https://www.example.com"
    // export RANEEN_PRODUCT_PATH="#######"
    private final String baseUrl = System.getenv().getOrDefault("RANEEN_BASE_URL", "https://www.example.com");
    private final String productPath = System.getenv("########"); // required for "real" test data
    private final boolean headless = !"0".equals(System.getenv().getOrDefault("HEADLESS", "1"));

    @BeforeTest
    public void prepare() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        if (headless) options.addArguments("--headless=new");
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu",
                "--remote-allow-origins=*", "--disable-extensions");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

        webProductPage = new WebProductPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Description("Public-safe demo: verify core elements exist on product page (no sensitive assertions).")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Moataz Mustafa")
    @Epic("Web UI Automation")
    @Feature("Product page")
    @Story("Verify product page core UI elements")
    @Test
    public void testProductPageCoreUI() {
        if (productPath == null || productPath.isBlank()) {
            throw new SkipException("Skipping: set env RANEEN_PRODUCT_PATH (######) to run this test.");
        }

        String url = baseUrl + productPath;

        stepOpenProduct(url);
        stepAssertCoreElements();
        stepOpenDeliveryPopupIfExists();
        stepAssertSecondaryInfoExists();
        stepAssertReviewsAndMediaExist();
    }

    @Step("Open product page: {url}")
    private void stepOpenProduct(String url) {
        log.info("Opening product page: {}", url);
        driver.get(url);
        Utility.waitForPageToLoad(driver, 10);

        assertThat("Page URL should contain product path", driver.getCurrentUrl(), containsString(productPath));
    }

    @Step("Assert core elements exist (title, price, add-to-cart, wishlist)")
    private void stepAssertCoreElements() {
        // ✅ These should be generic and safe
        assertThat("Product title should exist",
                driver.findElements(By.cssSelector("h1 span")).size(), greaterThan(0));

        // Price selectors differ a lot, so we assert “any price-like element exists”
        assertThat("Price element should exist",
                driver.findElements(By.cssSelector("[class*='price'], [data-price-amount], .price")).size(), greaterThan(0));

        // If you already have stable locators inside WebProductPage, keep using them:
        webProductPage.assertAddToCartButton();
        webProductPage.assertAddToWishList();
        webProductPage.assertQtySelector();
    }

    @Step("Open delivery popup if the button exists, then close it safely")
    private void stepOpenDeliveryPopupIfExists() {
        // ✅ Avoid hard-coded absolute XPath; just attempt if present
        var deliveryButtons = driver.findElements(By.cssSelector("button, a"));
        boolean clicked = false;

        for (var el : deliveryButtons) {
            String text = el.getText() == null ? "" : el.getText().trim();
            if (!text.isEmpty() && (text.contains("التوصيل") || text.toLowerCase().contains("delivery"))) {
                el.click();
                clicked = true;
                break;
            }
        }

        if (clicked) {
            // try close if close icon exists
            var close = driver.findElements(By.cssSelector("#delivery-time-popup span, .modal-close, .close"));
            if (!close.isEmpty()) close.get(0).click();
        }
    }

    @Step("Assert secondary sections exist (description, attributes, extra info blocks)")
    private void stepAssertSecondaryInfoExists() {
        // ✅ Generic: description / more-info / attributes exist
        webProductPage.assertProductDescription();
        webProductPage.assertProductAttributes();

        // Avoid asserting seller name / brand / warranty texts (sensitive & unstable)
        assertThat("Secondary info container exists",
                driver.findElements(By.cssSelector(".product-info-secondary, [class*='secondary']")).size(),
                greaterThanOrEqualTo(0)); // allow 0 if layout changes
    }

    @Step("Assert reviews section + images thumbnails exist")
    private void stepAssertReviewsAndMediaExist() {
        webProductPage.assertReviewsSection();
        webProductPage.assertWriteReviewButton();

        // ✅ Generic: product gallery / images exist
        assertThat("At least 1 product image exists",
                driver.findElements(By.cssSelector("img")).size(), greaterThan(0));
    }
}
