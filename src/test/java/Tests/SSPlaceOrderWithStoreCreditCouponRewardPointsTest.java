package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SSPlaceOrderWithStoreCreditCouponRewardPointsTest {

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
    public void open_screen_setup() throws InterruptedException {

        driver.get("https://www.example.com");  //open magento
        driver.findElement(By.cssSelector("#username")).sendKeys("######");  //user name
        driver.findElement(By.cssSelector("#login")).sendKeys("######");  //password
        driver.findElement(By.cssSelector("#login-form > fieldset > div.form-actions > div.actions > button")).click();  //sign in
        driver.findElement(By.cssSelector("#menu-magento-catalog-catalog")).click();  // catalog
        driver.findElement(By.cssSelector("#menu-magento-catalog-catalog > div > ul > li.item-inventory.parent.level-1 > div > ul > li.item-catalog-products.level-2 > a")).click();  //products
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"fulltext\"]")).clear();  // product search field
        driver.findElement(By.xpath("//*[@id=\"fulltext\"]")).sendKeys("####"); //
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  // search
        driver.findElement(By.cssSelector("#idscheck413176")).click();  // checkbox
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > button")).click();  // mass action
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent > span")).click();  //change status
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div.admin__data-grid-header-row.row.row-gutter > div.col-xs-2 > div > div > ul > li._parent._visible > ul > li:nth-child(1) > span")).click();  //enable
        driver.findElement(By.cssSelector("#menu-magento-customer-customer")).click();  // customers
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#menu-magento-customer-customer > div > ul > li.item-customer-manage.level-1 > a")).click();  //all customers
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#fulltext")).clear();  //
        driver.findElement(By.cssSelector("#fulltext")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#container > div.admin__data-grid-outer-wrap > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  //search
        driver.findElement(By.cssSelector("#container > div.admin__data-grid-outer-wrap > div.admin__data-grid-wrap > table > tbody > tr:nth-child(2) > td.data-grid-actions-cell > a")).click();  //edit
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#tab_customerbalance_content")).click();  //store credit
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#_customerbalanceamount_delta")).sendKeys("100");  //
        driver.findElement(By.cssSelector("#tab_customer_edit_tab_reward_content")).click();  //reward points
        Thread.sleep(7000);
        driver.findElement(By.id("reward_store")).click();  //drop down
        {
            WebElement dropdownElement = driver.findElement(By.id("reward_store")); // Replace with actual ID

            // Create a Select object
            Select dropdown = new Select(dropdownElement);

            // Select by visible text
            dropdown.selectByVisibleText("#######");
        }
        driver.findElement(By.cssSelector("#reward_points_delta")).sendKeys("100");  //
        driver.findElement(By.cssSelector("#save")).click();  //save customer
        Thread.sleep(7000);
        driver.switchTo().newWindow(WindowType.TAB);
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        driver.get("https://www.example.com"); // test product
        driver.findElement(By.cssSelector("#smart-addtocart-button")).click();  // add t cart
        driver.findElement(By.cssSelector("#phone-number")).sendKeys("######");  // phone num
        driver.findElement(By.cssSelector("#html-body > div.modals-wrapper > aside > div.modal-inner-wrap > footer > button")).click();  // add t cart
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        Object[] windowHandles2 = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles2[2]);
        driver.get("https://www.raneen.com/ss_zayed/smartstore/screen/setup");
        driver.findElement(By.cssSelector("#screen_type")).click();  // screen type
        driver.findElement(By.cssSelector("#screen_type > option:nth-child(4)")).click();  //checkout screen
        driver.findElement(By.cssSelector("#identifier")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#password")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#screen-setup-form > div.actions-toolbar > div > button")).click();  // setup screen
        driver.findElement(By.cssSelector("#phone")).sendKeys("######");  //send OTP
        driver.findElement(By.cssSelector("#smartstore-otp > button")).click();  //send
        driver.switchTo().window((String) windowHandles2[0]); //magento
        driver.findElement(By.cssSelector("#menu-ocean-core-ocean > a")).click();  //ocean
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#menu-ocean-core-ocean > div > ul > li:nth-child(2) > ul > li:nth-child(1) > div > ul > li.item-smartotp.level-2 > a")).click();  //OTPs
        String OTP = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText(); //copy
        driver.switchTo().window((String) windowHandles2[2]); //magento
        driver.findElement(By.cssSelector("#otp")).sendKeys(OTP);  //paste
        driver.findElement(By.cssSelector("#smartstore-login > button")).click();  // check otp
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#form-validate > div.cart.main.actions > button.action.update")).click();  //update cart
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector("#cart-totals > div > table > tbody > tr.grand.totals > td > strong > span")).getText(), is("EGP 620.00"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.cart-container > div.cart-summary._sticky > ul > li > button")).click();  //proceed to checkout page
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();  //shipping info
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#block-discount-heading")).click();  //coupon
        driver.findElement(By.cssSelector("#discount-code")).sendKeys("######");  //coupon code
        driver.findElement(By.cssSelector("#discount-form > div.actions-toolbar > div > button")).click();  //apply coupon
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#use-customer-balance")).click();  //apply store credit
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#reward-points-buttons-container > div > button")).click();  //apply reward points
        Thread.sleep(7000);
        assertThat(driver.findElement(By.cssSelector("#opc-sidebar > div.opc-block-summary > table > tbody > tr.totals.discount > td > span")).getText(), is("-EGP 100.00"));      //coupon
        assertThat(driver.findElement(By.cssSelector("#opc-sidebar > div.opc-block-summary > table > tbody > tr.totals.rewardpoints > td > span")).getText(), is("-EGP 10.00"));   //reward points
        assertThat(driver.findElement(By.cssSelector("#opc-sidebar > div.opc-block-summary > table > tbody > tr.totals.balance > td > span")).getText(), is("-EGP 100.00"));       //store credit
        assertThat(driver.findElement(By.cssSelector("#opc-sidebar > div.opc-block-summary > table > tbody > tr.grand.totals > td > strong > span")).getText(), is("EGP 410.00")); //totals
        driver.findElement(By.cssSelector("#online_payment")).click();  //pay online
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#ocean_NBEGate_cash")).click();  //NBE visa
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#agreement_ocean_NBEGate_cash_3")).click();  //terms button
        driver.findElement(By.cssSelector("#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button")).click();  //place order
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span")).getText(), is("تم استلام طلبك بنجاح!")); //success page
        driver.switchTo().window((String) windowHandles2[0]); //magento
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > a")).click();  //sales
        Thread.sleep(50000);
        driver.findElement(By.cssSelector("#menu-magento-sales-sales > div > ul > li:nth-child(1) > ul > li > div > ul > li.item-sales-order.level-2 > a")).click();  //orders
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#fulltext")).clear();  //
        driver.findElement(By.cssSelector("#fulltext")).sendKeys("######");  //
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-header > div:nth-child(1) > div.data-grid-search-control-wrap > button")).click();  //search
        driver.findElement(By.cssSelector("#container > div > div.admin__data-grid-wrap > table > tbody > tr:nth-child(1) > td.data-grid-actions-cell > a")).click();  //view
        assertThat(driver.findElement(By.cssSelector("#sales_order_view_tabs_order_info_content > section.admin__page-section.order-view-billing-shipping > div.admin__page-section-content > div.admin__page-section-item.order-payment-method > div.admin__page-section-item-content > div.order-payment-method-title")).getText(), is("بطاقات الدفع الالكتروني"));
        assertThat(driver.findElement(By.cssSelector("#sales_order_view_tabs_order_info_content > section:nth-child(8) > div.admin__page-section-content > div.admin__page-section-item.order-totals > table > tbody > tr.col-1 > td:nth-child(2) > span")).getText(), is("-EGP 100.00")); // coupon
        assertThat(driver.findElement(By.cssSelector("#sales_order_view_tabs_order_info_content > section:nth-child(8) > div.admin__page-section-content > div.admin__page-section-item.order-totals > table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText(), is("-EGP 10.00")); // reward points
        assertThat(driver.findElement(By.cssSelector("#sales_order_view_tabs_order_info_content > section:nth-child(8) > div.admin__page-section-content > div.admin__page-section-item.order-totals > table > tbody > tr:nth-child(5) > td:nth-child(2)")).getText(), is("-EGP 100.00")); //store credit
        assertThat(driver.findElement(By.cssSelector("#sales_order_view_tabs_order_info_content > section:nth-child(8) > div.admin__page-section-content > div.admin__page-section-item.order-totals > table > tfoot > tr.col-0 > td:nth-child(2) > strong")).getText(), is("EGP 410.00")); //grand total
    }
}
