package Tests;

import Pages.BasePage;
import Pages.WebCategoryPage;
import Pages.WebHomePage;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WebSideBarMenuTest {
    private static final Logger log = LoggerFactory.getLogger(WebSideBarMenuTest.class);

    WebDriver driver;
    WebHomePage webHomePage;
    WebCategoryPage webCategoryPage;

    @BeforeTest
    public void prepare() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions for Incognito Mode //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
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
    }

    @AfterTest
    public void teardown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    @Description("Test script for verifying the Web Sidebar functionality")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Moataz Mustafa")
    @Link(name = "Raneen Sidebar", url = "https://www.example.com/ar/")
    @Issue("https://raneen.atlassian.net/browse/RT-534")
    @TmsLink("Zephyr Scale")
    @Epic("Testing Automation")
    @Feature("Sidebar Menu")
    @Story("Verify sidebar menu functionality")
    @Test
    public void testSidebarMenuFunctionality() throws InterruptedException {
        // Step 1: Navigate to the homepage
        log.info("Navigating to the homepage...");
        BasePage.openUrl("https://www.example.com/ar/");
        log.info("Waiting for 10 sec...");
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        // Step 2: Interact with Sidebar Menu
        log.info("Opening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load

        // Click on each sidebar menu item
        log.info("Clicking on 'Account' tab...");
        webHomePage.clickAccountTab();
        log.info("Clicking on 'Sign In' from the account tab...");
        webHomePage.clickSignInFromAccount();
        log.info("Validating 'Sign In' text...");
        assertThat(Utility.findWebElement(driver, By.cssSelector("#ammenu-sidebar > section.ammenu-account-section > ul > li:nth-child(1) > a > p")).getText(), is("تسجيل الدخول"));
        log.info("Closing social login popup...");
        Utility.clickingOnElement(driver, By.cssSelector("#social-login-popup > button\n"));
        log.info("Clicking on 'Sign Up' from the account tab...");
        webHomePage.clickSignUpFromAccount();
        log.info("Validating 'Create New Account' page title...");
        assertThat(Utility.findWebElement(driver, By.cssSelector("#maincontent > div.page-title-wrapper > h1")).getText(), is("إنشاء حساب جديد"));
        log.info("Validating 'Sign Up' form...");
        Utility.findWebElement(driver, By.cssSelector("#form-validate"));  //assertions for signup forum
        log.info("Navigating back to the previous page...");
        driver.navigate().back();
        log.info("Waiting for 10 sec...");
        Utility.waitForPageToLoad(driver, 10); // Wait for menu to load
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickAccountTab();
        log.info("Clicking on 'Help and Settings'...");
        webHomePage.clickHelpAndSettings();
        log.info("Navigating through various categories...");
        webHomePage.clickMenuTab();
        log.info("clicking on appliances ...");
        webHomePage.clickAppliances();
        log.info("Validating appliances category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filters  ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by product ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        log.info("Clicking on 'Mobiles'...");
        webHomePage.clickMobiles();
        log.info("Validating mobiles category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");

        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        //   webHomePage.clickMenuTab();

        log.info("Clicking on 'Security and Surveillance Systems'...");
        webHomePage.clickSecuritySurveillanceSystems();
        log.info("Validating security and surveillance systems category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filters sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webHomePage.clickMenuTab();
        log.info("Waiting for 5 sec...");
        Thread.sleep(3000);
        log.info("Clicking on 'Home'...");
        webHomePage.clickHome();
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        log.info("Clicking on 'Kitchen'...");
        webHomePage.clickKitchen();
        log.info("Validating kitchen category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        log.info("Clicking on 'Textile'...");
        webHomePage.clickTextile();
        log.info("Validating textile category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        log.info("Clicking on 'Furniture'...");
        webHomePage.clickFurniture();
        log.info("Validating furniture category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by  ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        log.info("Waiting for 3 sec...");
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        Thread.sleep(3000);
        log.info("Clicking on 'Family Products'...");
        webHomePage.clickFamilyProducts();
        log.info("Validating family products category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        Thread.sleep(3000);
        log.info("Clicking on 'Fashion'...");
        webHomePage.clickFashion();
        log.info("Validating fashion category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        Thread.sleep(3000);
        log.info("Clicking on 'Lighting and Home Decor'...");
        webHomePage.clickLightingHomeDecore();
        log.info("Validating lighting and home decor category page...");
        webCategoryPage.assertallProductsDiv();
        log.info("Validating first product ...");
        webCategoryPage.assertFirstProduct();
        log.info("Validating second product ...");
        webCategoryPage.assertSecondProduct();
        log.info("Validating third product ...");
        webCategoryPage.assertThirdProduct();

        log.info("Validating filter sidebar ...");
        webCategoryPage.assertFiltersSideBar();
        log.info("Validating sort by ...");
        webCategoryPage.assertSortByButton();
        webCategoryPage.assertSortByDropDownButton();
        log.info("Validating list view ...");
        webCategoryPage.switchToListView();
        Thread.sleep(3000);
        webCategoryPage.switchToGridView();
        log.info("Reopening sidebar menu...");
        webHomePage.clickAllCategories(); // Open sidebar
        log.info("Waiting for 5 sec...");
        Utility.waitForPageToLoad(driver, 5); // Wait for menu to load
        webHomePage.clickMenuTab();
        Thread.sleep(3000);
        log.info("Test completed successfully.");


    }
}
