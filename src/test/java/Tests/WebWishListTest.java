package Tests;

import Pages.*;
import Utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebWishListTest {
    private static final Logger log = LoggerFactory.getLogger(WebWishListTest.class);

    WebDriver driver;
    WebHomePage webHomePage;
    WebCategoryPage webCategoryPage;
    WebProductPage webProductPage;
    LogInPage logInPage;

    @BeforeTest
    public void prepare() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions for Incognito Mode //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*"); // Fix potential CORS issues
        options.addArguments("--disable-extensions");
        // options.addArguments("--incognito"); // Enable incognito mode
        options.addArguments("--start-maximized"); // Start maximized
        options.addArguments("--disable-cache"); // Disable caching
        driver = new ChromeDriver(options); // Initialize driver with options

        // Clear cookies explicitly (if needed)
        driver.manage().deleteAllCookies();

        // Initialize WebHomePage object
        webHomePage = new WebHomePage(driver);
        webCategoryPage = new WebCategoryPage(driver);
        webProductPage = new WebProductPage(driver);
        logInPage = new LogInPage(driver);
    }

    @AfterTest
    public void teardown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    @Description("Test script for verifying the web wish list functionality")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Moataz Mustafa")
    @Link(name = "Raneen web wish list", url = "https://www.raneen.com/ar/")
    @Issue("https://raneen.atlassian.net/browse/RT-840")
    @TmsLink("Zephyr Scale")
    @Epic("Testing Automation")
    @Feature("web wish list")
    @Story("Verify web wish list functionality")
    @Test
    public void testWishListFunctionality() throws InterruptedException {

        // Step 1: Navigate to the homepage
        log.info("Starting test for wish list functionality...");
        log.info("open TV category page...");
        BasePage.openUrl("https://www.raneen.com/ar/electronics/televisions-accessories/tv?product_list_order=name");
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Clicking on login button...");
        logInPage.clickLoginButton();
        log.info("wait for 6 sec...");
        Thread.sleep(6000);
        log.info("Entering login credentials...");
        logInPage.enterEmail("");
        logInPage.enterPassword("");
        log.info("Submitting login form...");
        logInPage.clickSubmitLogIn();
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Adding a product to the wish list...");
        Thread.sleep(10000);
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[6]/div[1]/div[4]/div[2]/ol/li[4]/div/div[2]/div[4]/div/div[2]/a")); //click on wish list icon
        Utility.waitForPageToLoad(driver, 15); // Ensure the page is fully loaded
        log.info("Navigating to wish list dropdown...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/span/button")); //click on dropdown arrow
        log.info("Navigating to my wish list...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")); //click on my wish list button
        log.info("Verifying the product in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li")); //assert first product
        log.info("Verifying the product title in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/strong/a")); //assert product title
        log.info("Verifying the product price in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[2]")); //assert product price
        log.info("Verifying the add to cart button in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[2]/fieldset/div[2]/div/button")); //assert add to cart button
        log.info("verifying the edit button in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[3]/a[1]")); //assert edit button
        log.info("verifying the delete button in the wish list...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[3]/a[2]")); //click on delete button
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("first Test completed successfully!");

        log.info("Starting second test...");
        log.info("open (test) product page...");
        BasePage.openUrl("https://www.raneen.com/ar/catalog/product/view/id/413176"); //open (Test33) product page
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Adding product to wish list...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div/div[3]/div[2]/div[5]/div")); //click on add to wish list button
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Navigating to wish list dropdown...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/span/button")); //click on dropdown arrow
        log.info("Navigating to my wish list...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")); //click on my wish list button
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Verifying the product in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li")); //assert first product
        log.info("Verifying the product title in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/strong")); //assert product title
        log.info("Verifying the product price in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[2]")); //assert product price
        log.info("Verifying the edit button in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[3]/a[1]")); //assert edit button
        log.info("Verifying the product image in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/a")); //assert product image
        log.info("Verifying the add to cart button in the wish list...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[3]/a[2]")); //assert add to cart button
        log.info("delete item from wishlist...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/form/div[1]/ol/li/div/div[3]/div[3]/a[2]")); //delete product from my wish list

    }
}
