import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class testcasses {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeMethod
    public void setUp()
    {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Create ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize the ChromeDriver with options
        try {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("/usr/bin/chromedriver"))
                    .usingAnyFreePort()
                    .build();
            service.start();

            driver = new ChromeDriver(service, options);
            js = (JavascriptExecutor) driver;
            vars = new HashMap<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @org.testng.annotations.Test
    public void signUp() {
        {
            driver.get("https://www.example.com/en/");
            driver.manage().window().setSize(new Dimension(1440, 797));
            driver.findElement(By.linkText("Create an Account")).click();
            driver.findElement(By.id("firstname")).sendKeys("#####");
            driver.findElement(By.id("lastname")).click();
            driver.findElement(By.id("lastname")).sendKeys("#####");
            driver.findElement(By.id("mobile_number")).click();
            driver.findElement(By.id("mobile_number")).sendKeys("######");
            driver.findElement(By.id("am-email-address")).click();
            driver.findElement(By.id("am-email-address")).sendKeys("######");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("######");
            driver.findElement(By.id("password-confirmation")).click();
            driver.findElement(By.id("password-confirmation")).sendKeys("######");
            driver.findElement(By.id("customer_form_register_popup_showPassword")).click();
            driver.findElement(By.cssSelector("#customer-form-register-popup-send2 > span")).click();
            {
                WebElement element = driver.findElement(By.cssSelector("#customer-form-register-popup-send2 > span"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            {
                WebElement element = driver.findElement(By.tagName("body"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element, 0, 0).perform();
            }
        }
    }
}
