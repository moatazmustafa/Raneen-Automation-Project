package Tests;

import Pages.*;
import Utilities.LogsUtils;
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

public class WebCategoryFiltrationsTest {
    public static final Logger log = LoggerFactory.getLogger(WebCategoryFiltrationsTest.class);
    public WebDriver driver;
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

        // Initialize Pages object
        webHomePage = new WebHomePage(driver);
        webCategoryPage = new WebCategoryPage(driver);
        webProductPage = new WebProductPage(driver);
        LogsUtils.cleanOldLogs();

    }

    @AfterTest
    public void teardown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    @Description("Test script for verifying the web category filtration functionality")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Moataz Mustafa")
    @Link(name = "Raneen web category filtration ", url = "https://www.example.com")
    @Issue("https://raneen.atlassian.net/browse/RT-518")
    @TmsLink("Zephyr Scale")
    @Epic("Testing Automation")
    @Feature("web category filtration")
    @Story("Verify web category filtration")
    @Test
    public void Build() throws InterruptedException {

        // Step 1: Navigate to the homepage
        LogsUtils.info("open appliances page...");
        BasePage.openUrl("https://www.example.com");
        LogsUtils.info("assert category name...");
        Utility.assertText(driver, By.cssSelector("#page-title-heading > span"), "الأجهزة المنزلية");
        LogsUtils.info("assert category filter section...");
        Utility.findWebElement(driver, By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")); //assert filters section
        LogsUtils.info("assert category ...");
        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(1) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(1) > div.filter-options-title"), "القسم");
        LogsUtils.info("assert brand ...");
        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(2) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(2) > div.filter-options-title"), "الماركة");
        LogsUtils.info("assert material ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(3) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(3) > div.filter-options-title"), "الخامة");
        LogsUtils.info("assert length ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(4) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(4) > div.filter-options-title"), "الطول");
        LogsUtils.info("assert wattage ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(5) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(5) > div.filter-options-title"), "القوة الكهربائية");
        LogsUtils.info("assert directions ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(6) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(6) > div.filter-options-title"), "الاتجاهات");
        LogsUtils.info("assert blades numbers ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(7) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(7) > div.filter-options-title"), "عدد الشفرات");
        LogsUtils.info("assert blades materials ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(8) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(8) > div.filter-options-title"), "خامة الشفرات");
        LogsUtils.info("assert style ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(9) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(9) > div.filter-options-title"), "الطراز");
        LogsUtils.info("assert watt ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(10) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(10) > div.filter-options-title"), "القدرة كهربائية");
        LogsUtils.info("assert color ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(11) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(11) > div.filter-options-title"), "اللون الأساسي");
        LogsUtils.info("assert warranty ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(12) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(12) > div.filter-options-title"), "الضمان");
        LogsUtils.info("assert offers & discounts ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(13) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(13) > div.filter-options-title"), "العروض والخصومات");
        LogsUtils.info("assert sold by raneen ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(14) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(14) > div.filter-options-title"), "مباع بواسطة رنين");
        LogsUtils.info("assert suction fan type ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(15) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(15) > div.filter-options-title"), "نوع الشفاط");
        LogsUtils.info("assert height ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(16) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(16) > div.filter-options-title"), "الأرتفاع");
        LogsUtils.info("assert depth ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(17) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(17) > div.filter-options-title"), "العمق");
        LogsUtils.info("assert iron style ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(18) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(18) > div.filter-options-title"), "طراز المكواة");
        LogsUtils.info("assert width ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(19) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(19) > div.filter-options-title"), "العرض");
        LogsUtils.info("assert price ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(20) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(20) > div.filter-options-title"), "السعر");
        LogsUtils.info("assert seller ...");

        Utility.findWebElement(driver, By.cssSelector("#narrow-by-list > div:nth-child(21) > div.filter-options-title")); //assert
        Utility.assertText(driver, By.cssSelector("#narrow-by-list > div:nth-child(21) > div.filter-options-title"), "البائع");
        Utility.waitForPageToLoad(driver, 5000);
        LogsUtils.info("select black color filter ...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[6]/div[2]/div/div[2]/div/div[11]/div[2]/form/div/div[1]/a/div")); //click on black color filter
        Utility.waitForPageToLoad(driver, 5000);
        LogsUtils.info("select 2 years warranty ...");
        Utility.waitForPageToLoad(driver, 5000);
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[6]/div[2]/div/div[2]/div[3]/div[11]/div[2]/form/ol/li[3]/a")); //2 years warranty
        LogsUtils.info("select sold by raneen ...");
        Utility.waitForPageToLoad(driver, 5000);
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[6]/div[2]/div/div[2]/div[3]/div[9]/div[2]/form/ol/li/a")); //checkmark Yes
        LogsUtils.info("assert selected filters ...");
        Utility.waitForPageToLoad(driver, 5000);

        Utility.findWebElement(driver, By.cssSelector("#am-shopby-container > ol > li:nth-child(1)")); // assert color
        Utility.findWebElement(driver, By.cssSelector("#am-shopby-container > ol > li:nth-child(2)")); // assert warranty
        Utility.findWebElement(driver, By.cssSelector("#am-shopby-container > ol > li:nth-child(3)")); // assert sold by raneen
        LogsUtils.info("clear all filters ...");
        Utility.clickingOnElement(driver, By.cssSelector("#layered-filter-block > div.block-content.filter-content > div.block-actions.filter-actions > a")); //clear all filters
        LogsUtils.info("assert products ...");
        Utility.findWebElement(driver, By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")); // assert products


    }
}
