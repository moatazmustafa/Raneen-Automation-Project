package Tests;

import Utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminMarketplaceOrderCycleTest {

    WebDriver driver;
    WebDriverWait wait;

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

    }


    @AfterTest
    public void shutdown() {
        driver.quit();

    }

    @Description("this script for testing admin marketplace placing order")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Moataz Mustafa")
    @Link(name = "Magento", url = "https://www.example.com/")
    @Issue("https://raneen.atlassian.net/browse/RT-528")
    @TmsLink("Zephyr Scale")
    @Epic("Testing Automation")
    @Feature("Admin place order")
    @Story("valid admin placing order")
    @Test
    public void open_screen_setup() throws InterruptedException {

        driver.get("https://www.example.com/admin"); //Magento
        Utility.sendData(driver, By.cssSelector("#username"), "######");
        Utility.sendData(driver, By.cssSelector("#login"), "######");
        Utility.clickingOnElement(driver, By.cssSelector("#login-form > fieldset > div.form-actions > div.actions > button")); //Login

        Utility.clickingOnElement(driver, By.cssSelector("#menu-magento-catalog-catalog > a"));  //catalog
        Utility.clickingOnElement(driver, By.cssSelector("#menu-magento-catalog-catalog > div > ul > li.item-inventory.parent.level-1 > div > ul > li.item-catalog-products.level-2 > a"));  //products
        Thread.sleep(20000);
        Utility.findWebElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[5]/input")).clear();
        Utility.sendData(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[5]/input"), "test33");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[2]/div[1]/div[5]/button")); //search
        Utility.clickingOnElement(driver, By.cssSelector("#idscheck413176"));
        Utility.clickingOnElement(driver, By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > button")); //actions
        Utility.clickingOnElement(driver, By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent > span"));
        Utility.clickingOnElement(driver, By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent._visible > ul > li:nth-child(1) > span")); //enable product
        Utility.clickingOnElement(driver, By.cssSelector("#menu-magento-sales-sales > a")); //sales
        Utility.clickingOnElement(driver, By.cssSelector("#menu-magento-sales-sales > div > ul > li:nth-child(1) > ul > li > div > ul > li.item-sales-order.level-2 > a")); //orders
        Utility.clickingOnElement(driver, By.cssSelector("#add")); //create new order
        Utility.findWebElement(driver, By.cssSelector("#sales_order_create_customer_grid_filter_email")).clear();
        Utility.sendData(driver, By.cssSelector("#sales_order_create_customer_grid_filter_email"), "motaz.mostafa@raneen.com");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[3]/div[2]/div[1]/div[2]/div[1]/button[1]"));  //search
        Thread.sleep(10000);
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[3]/div[2]/div[2]/table/tbody/tr/td[3]"));
        Utility.clickingOnElement(driver, By.cssSelector("#store_2"));  //arabic store
        Thread.sleep(10000);
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[1]/div[1]/div/button[2]"));  //add product
        Utility.findWebElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/div[2]/div[2]/div[2]/table/thead/tr[2]/td[3]/input")).clear();
        Utility.sendData(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/div[2]/div[2]/div[2]/table/thead/tr[2]/td[3]/input"), "#####");
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")); //search
        Utility.clickingOnElement(driver, By.cssSelector("#id_413176"));
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/div[2]/div[1]/div/button")); //add selected prods to order
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector("#order-items_grid > table > tfoot > tr > td:nth-child(3) > strong > span")).getText(), is("EGP 100.00"));
        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[1]/div[3]/button")); //update qty
        Thread.sleep(10000);

        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[4]/div[2]/div[1]/div[3]/dl/dt[1]/input")); //COD
        Thread.sleep(5000);

        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[4]/div[2]/div[2]/div[2]/a")); //get shipping methods
        Thread.sleep(5000);

        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[4]/div[2]/div[2]/div[2]/dl/dd/ul/li/input"));  //flat rates 300 EGP
        Thread.sleep(5000);

        assertThat(driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[6]/div[2]/fieldset[2]/table/tbody/tr[4]/td[2]/strong/span")).getText(), is("EGP 412.00"));
        Thread.sleep(5000);

        Utility.clickingOnElement(driver, By.xpath("/html/body/div[3]/main/div[2]/div/div/form/div[5]/div/div[1]/section[6]/div[2]/fieldset[2]/div/div[3]/button")); //submit

    }
}
