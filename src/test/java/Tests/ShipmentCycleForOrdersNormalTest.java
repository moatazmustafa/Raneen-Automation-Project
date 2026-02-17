package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShipmentCycleForOrdersNormalTest {
    WebDriver driver;

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

    @Test
    public void Shipment_Normal() throws InterruptedException {
        driver.get("https://www.example.com"); //website
        driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.link.authorization-link")).click();  //
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#am-pass")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#customer_form_login_popup_showPassword")).click();  //
        driver.findElement(By.cssSelector("#customer-form-login-popup-send2")).click();  //sign in
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();  //add t cart
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > div.minicart-wrapper > a")).click();  //show cart
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();  //proceed to checkout
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();  //shipping method
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#cashondelivery")).click();  //
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#agreement_cashondelivery_3")).click();  //terms button
        driver.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")).click();  //place order
        Thread.sleep(10000);

        driver.switchTo().newWindow(WindowType.TAB);
        Object[] windowHandles1 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles1[1]);  // magento

        driver.get("https://www.example.com/admin");  //open magento
        driver.findElement(By.cssSelector("#username")).sendKeys("######");  //user name
        driver.findElement(By.cssSelector("#login")).sendKeys("######");  //password
        driver.findElement(By.cssSelector("#login-form > fieldset > div.form-actions > div.actions > button")).click();  //sign in
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > a")).click();  //sales
        Thread.sleep(70000);    //50000
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > div > ul > li:nth-child(1) > ul > li > div > ul > li.item-sales-order.level-2 > a")).click();  //orders
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#fulltext")).clear();  //
        driver.findElement(By.cssSelector("#fulltext")).sendKeys("#######");  //
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  //search button
        Thread.sleep(20000);
        String ordernumber2 = driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(2) > div")).getText(); // copy order number
        assertThat(driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td:nth-child(5) > div")).getText(), is("#######"));  //assert order status
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td.data-grid-actions-cell > a")).click();  //view
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#order_invoice")).click();  //invoice
        Thread.sleep(10000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/section[4]/section[2]/div[2]/div[2]/div[2]/div[3]/button")).click();  //submit
        Thread.sleep(50000);
        driver.navigate().refresh();
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#sales_order_view_tabs_order_shipments")).click();  //shipments
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#sales_order_view_tabs_order_shipments_content > div > div.admin__data-grid-wrap > table > tbody > tr > td.data-grid-actions-cell > a")).click();  //view shipment
        Thread.sleep(15000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/button[4]")).click();  //in process
        Thread.sleep(15000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/button[4]")).click();  //pack
        Thread.sleep(15000);
        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > a")).click();  //marketplace
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#menu-ocean-marketplaceseller-parent > div > ul > li:nth-child(2) > ul > li.item-statementitems.parent.level-1 > div > ul > li.item-marketplacestatementitem.level-2 > a")).click();  //statement items
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).clear();  //
        driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_post_filter_order_id")).sendKeys(#######);  //paste order number
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div[1]/div[2]/div[1]/button[1]")).click();  // search
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-seller_id")).getText(), is("#####"));
        assertThat(driver.findElement(By.cssSelector("#postGridMarketplaceStatementItem_table > tbody > tr > td.col-shipment_delivery_type")).getText(), is("Normal"));
        Thread.sleep(10000);
    }
}
