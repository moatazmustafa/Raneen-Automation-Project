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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WsOrderCycleTest {
    private static final Logger log = LoggerFactory.getLogger(WsOrderCycleTest.class);

    WebDriver driver;
    WebHomePage webHomePage;
    WebCategoryPage webCategoryPage;
    WebProductPage webProductPage;
    LogInPage logInPage;
    AdminPage adminPage;

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
        adminPage = new AdminPage(driver);
    }

    @AfterTest
    public void teardown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    @Description("Test script for verifying the web order cycle functionality")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Moataz Mustafa")
    @Link(name = "Raneen web order cycle", url = "https://www.example.com")
    @Issue("https://raneen.atlassian.net/browse/RT-840")
    @TmsLink("Zephyr Scale")
    @Epic("Testing Automation")
    @Feature("web order cycle")
    @Story("Verify web order cycle functionality")
    @Test
    public void testWebOrderCycleFunctionality() throws InterruptedException {

        // Step 1: Navigate to the homepage
        log.info("Starting test for web order cycle functionality...");
        log.info("open TV category page...");
        BasePage.openUrl("https://www.example.com");
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Clicking on login button...");
        logInPage.clickLoginButton();
        log.info("wait for 6 sec...");
        Thread.sleep(6000);
        log.info("Entering login credentials...");
        logInPage.enterEmail("*********");
        logInPage.enterPassword("*********");
        log.info("Submitting login form...");
        logInPage.clickSubmitLogIn();
        Utility.waitForPageToLoad(driver, 10); // Ensure the page is fully loaded
        log.info("Verifying login success...");
        log.info("click on search bar...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[2]/div[1]/div/form/div[2]/input")); // Click on the search bar
        log.info(" enter search term...");
        Utility.sendData(driver, By.xpath("/html/body/div[3]/header/div[2]/div[1]/div/form/div[2]/input"), "#####"); // Enter search term
        log.info("click on first product...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[8]/div[1]/section/ul/li[1]/a/div[1]")); // Click on the first search result
        log.info(" click on add to cart button...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div/div[3]/div[2]/div[4]/form/div/div/div[2]/button")); // Click on the "Add to Cart" button
        Thread.sleep(7000); // Wait for 7 seconds
        log.info("navigate to cart side bar...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[2]/div[2]/a")); // Click on the cart icon
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/header/div[2]/div[2]/div/div/div/div[2]/div[2]/div/span/span")); // Find the cart total element
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[2]/div/div/div/div[2]/div[2]/div/span/span")).getText(), is("500 جنيه")); // Verify the cart total
        log.info("navigate to cart page...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[2]/div[2]/div/div/div/div[2]/div[5]/div/a")); // Click on the "view cart" button
        Thread.sleep(6000); // Wait for 6 seconds
        log.info("Verifying cart page elements...");
        Utility.findWebElement(driver,By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/th"));
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/h1/span")).getText(), is("عربة التسوق")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/strong")).getText(), is("ملخص")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[1]/div[1]/strong")).getText(), is("تقدير قيمة الشحن")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/th")).getText(), is("المجموع الفرعي")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[2]/div/table/tbody/tr[1]/td/span")).getText(), is("500 جنيه")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[2]/div/table/tbody/tr[3]/th/strong")).getText(), is("المجموع الكلي")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span")).getText(), is("522 جنيه")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/ul/li/button")).getText(), is("ابدأ في تتفيذ الطلب")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/form/div[1]/table/thead/tr/th[1]/span")).getText(), is("منتج")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/form/div[1]/table/thead/tr/th[2]/span")).getText(), is("السعر")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/form/div[1]/table/thead/tr/th[3]/span")).getText(), is("الكمية")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/form/div[1]/table/thead/tr/th[4]/span")).getText(), is("المجموع الفرعي")); //
        log.info("navigate to shipping page ...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[4]/div/div[4]/div[1]/ul/li/button")); // Click on "proceed to checkout" button
        log.info("navigate to checkout page ...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[4]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")); // Click on "continue to checkout" button
        Thread.sleep(6000); // Wait for 6 seconds
        log.info("Verifying order shipping methods & totals...");
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/span")).getText(), is("ملخص الطلب")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[1]/th")).getText(), is("إجمالي العربة")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[1]/td/span")).getText(), is("500 جنيه")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[2]/th/span[1]")).getText(), is("إدخال بيانات الشحن")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[3]/th/strong")).getText(), is("المجموع الكلي")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[3]/td/strong/span")).getText(), is("522 جنيه")); //
        Utility.findWebElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[1]/div/div[1]")); // Find the cart products qty
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[2]/div/div[1]/div[1]/span")).getText(), is("الشحن إلى:")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[2]/div/div[2]/div[1]/span")).getText(), is("طريقة الشحن:")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/aside/div[2]/div/div/div[2]/div/div[2]/div[2]")).getText(), is("خدمات الشحن - رسوم ثابتة")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[1]")).getText(), is("طريقة الدفع او السداد")); //
        log.info("Verifying payment method options...");
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[1]/label/span")).getText(), is("الدفع عند الاستلام")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[3]/div[1]/label/span")).getText(), is("الدفع بالمحفظة")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[4]/div[1]/label/span")).getText(), is("امان")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[5]/div[1]/label/span")).getText(), is("كارت بريميوم")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[6]/div[1]/label/span")).getText(), is("سهولة")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[7]/div[1]/label/span")).getText(), is("بطاقات الدفع الالكتروني")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[8]/div[1]/label/span")).getText(), is("تقسيط البنك الأهلي")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[9]/div[1]/label/span")).getText(), is("تقسيط مع بنك قطر الوطني الاهلي")); //
        Utility.findWebElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[3]/div[1]")); // Find apply coupon code button
        Utility.findWebElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[5]/div[1]")); // Find apply gift card button
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[3]/div[1]/span/span")).getText(), is("تطبيق كود الخصم")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[4]/div[1]/span")).getText(), is("رصيد المحفظة")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[5]/div[1]/span/span")).getText(), is("تطبيق بطاقة هدية")); //
        Utility.findWebElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[4]/div[2]/div[2]/div/button")); // Find use store credit button
        log.info("click on COD payment method button...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[1]/input")); // Click on COD payment method button
        log.info("accept payment term & conditions...");
        Utility.clickingOnElement(driver, By.name("agreement[3]")); // accept payment terms & conditions
        assertThat(driver.findElement(By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div/label/button/span")).getText(), is("أوافق على شروط وأحكام الدفع"));
        log.info("click on place order button...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[4]/main/div[4]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button")); // place order button
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[2]/h1/span")); // find order confirmation message
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/h1/span")).getText(), is("تم استلام طلبك بنجاح!")); //
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[4]/div/div[3]/div/div/a")); // find continue shopping button
        log.info("navigating to account center...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/span/button")); // Click on the account center button
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")); // click on my account
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[2]/div/div[2]/ul/li[15]/a")); // click on my orders
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[4]/table/tbody/tr[1]/td[5]/a[1]")); // click on view order details
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tbody/tr/td[1]/strong"));
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tbody/tr/td[1]/strong")).getText(), is("#####")); //
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tfoot/tr[1]/td")).getText(), is("500 جنيه")); // subtotal
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tfoot/tr[2]/td")).getText(), is("22 جنيه")); // shipping fees
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tfoot/tr[3]/td")).getText(), is("12 جنيه")); // COD fees
        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[3]/div[1]/div[3]/div[2]/table/tfoot/tr[4]/td/strong")).getText(), is("534 جنيه")); // totals

        log.info("web order cycle test completed successfully.");
    }

    @Test(dependsOnMethods = {"testWebOrderCycleFunctionality"})
    public void testAdminOrderCycleFunctionality() throws InterruptedException {
        log.info("Starting assertions on admin for order cycle...");
        log.info("open Magento & login...");
        BasePage.openUrl("https://www.example.com");
        adminPage.login("*********", "*********");
        Utility.waitForPageToLoad(driver, 7000);
        log.info("wait for order to be recorded...");
        Thread.sleep(120000);
        log.info("click on sales...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/nav/ul/li[6]/a")); // click on sales
        log.info("click on orders...");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/nav/ul/li[6]/div/ul/li[1]/ul/li/div/ul/li[1]/a")); // click on orders
        Thread.sleep(9000);
        Utility.findWebElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[2]/input")).clear(); // clear search field
        log.info("search by testsellertow");
        Utility.sendData(driver,By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[2]/input"),"sellertow");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[2]/button")); // click on search button
        Thread.sleep(5000);
        log.info("start order assertions...");
        Utility.findWebElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[4]/table/tbody/tr[1]/td[10]/div")); // assert sold by
        Utility.findWebElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[4]/table/tbody/tr[1]/td[7]/div")); // assert grand total
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[4]/table/tbody/tr[1]/td[13]/a")); // click on view
        assertThat(driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div/div[1]/div[1]/section[6]/div[2]/div[2]/table/tfoot/tr[1]/td[2]/strong")).getText(), is("534 جنيه")); // assert totals
        log.info("admin order assertions test completed successfully.");
    }
}
