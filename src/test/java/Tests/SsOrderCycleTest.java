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

public class SsOrderCycleTest {

    WebDriver driver;

    @BeforeTest
    public void prepare() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions for headless mode
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless"); // Enable headless mode
        chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
        chromeOptions.addArguments("--window-size=1920,1080"); // Set window size

        // Initialize ChromeDriver with the configured options
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.example.com");
        Thread.sleep(3000);
    }

    @AfterTest
    public void close() {

        driver.quit();


    }

    @Test
    public <WebElement> void Add_product_To_Cart() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.example.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(.,'أضف للعربة')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(.,'أضف للعربة')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='addtocart-popup']/div/input")).sendKeys("######");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//aside[2]/div[2]/footer/button/span")).click();
        Thread.sleep(5000);
        // Verify that the success message is displayed
        //driver.findElement(By.xpath("//span[contains(.,'تم إضافة المنتج إلى العربة بنجاح')]")).isDisplayed();

    }

    @Test
    public void Checkout() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.example.com");
        Thread.sleep(2000);
        WebElement List = driver.findElement(By.id("screen_type"));
        Thread.sleep(2000);
        Select droplist = new Select(List);
        droplist.selectByValue("Checkout");
        driver.findElement(By.xpath("//form[@id='screen-setup-form']/div[3]/div/input")).sendKeys("######");
        driver.findElement(By.xpath("//form[@id='screen-setup-form']/div[4]/div/input")).sendKeys("######");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//form[@id='smartstore-otp']/input")).sendKeys("######");
        driver.findElement(By.xpath("//form[@id='smartstore-otp']/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//form[@id='smartstore-login']/input")).sendKeys("######");
        driver.findElement(By.xpath("//form[@id='smartstore-login']/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//main[@id='maincontent']/div[4]/div/div[4]/div/ul/li/button/span")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@id='cashier_payment']/h3")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='checkout-payment-method-load']/div/div/div[12]/div[2]/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='checkout-payment-method-load']/div/div/div[12]/div[2]/div[3]/div/button/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(.,'تم استلام طلبك بنجاح!')]")).isDisplayed();

    }

    @Test

    public void Payment_On_Cashier_Screen() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.example.com");
        Thread.sleep(5000);
        WebElement List = driver.findElement(By.id("screen_type"));
        Thread.sleep(2000);
        Select droplist = new Select(List);
        droplist.selectByValue("Cashier");
        driver.findElement(By.xpath("//form[@id='screen-setup-form']/div[3]/div/input")).sendKeys("######");
        driver.findElement(By.xpath("//form[@id='screen-setup-form']/div[4]/div/input")).sendKeys("######");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//form[@id='screen-setup-form']/div[5]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//main[@id='maincontent']/div[4]/div/div[3]/a/img")).click();
        driver.findElement(By.xpath("//form[@id='smartstore-cashier-list']/input")).sendKeys("######");
        driver.findElement(By.xpath("//form[@id='smartstore-cashier-list']/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div/div[3]/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//label[contains(.,'كاش')]")).click();
        driver.findElement(By.id("reference-number")).sendKeys("######");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//form[@id='complete-payment-form']/div[6]/div")).click();
        driver.findElement(By.xpath("//form[@id='complete-payment-form']/div[5]/input")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("downpayment-collection")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(.,'إتمام عملية الدفع')]")).click();
        Thread.sleep(3000);


    }

}
