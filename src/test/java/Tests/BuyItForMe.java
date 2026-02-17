package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BuyItForMe {

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

        driver.get("https://example.com");
        Thread.sleep(3000);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

    @Test
    public void Buy_it_for_me() throws InterruptedException {

        driver.findElement(By.linkText("اشتريها من أجلي")).click();

        // Verify that url https://example.com
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://example.com";
        Assert.assertEquals(actualUrl, expectedUrl);

        // Verify that QR code is displayed
        driver.findElement(By.cssSelector("img.qr_code_image")).isDisplayed();
        Thread.sleep(5000);

        // Opens a new tab and switches to new tab to send buy request
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://example.com");
        Thread.sleep(5000);
        driver.findElement(By.id("product_link")).sendKeys("https://www.noon.com/egypt-en/3-piece-electric-milk-frother-and-whisk-set-multicolour/N46987822A/p/?o=d089c07aa93b89ff&gclid=CjwKCAjw0aS3BhA3EiwAKaD2ZWh8YIC3GhKbaQcbtkw_T64odNrd9HcV2QeghIRDJNIOnn07ZyIbuRoC6jQQAvD_BwE&utm_campaign=C1000151355N_eg_en_web_searchxxexactandphrasexxbrandpurexx08082022_noon_web_c1000088l_acquisition_sembranded_&utm_medium=cpc&utm_source=C1000088L");
        driver.findElement(By.id("product_qty")).clear();
        driver.findElement(By.id("product_qty")).sendKeys("#");
        driver.findElement(By.id("product_name")).sendKeys("مضرب");
        driver.findElement(By.id("customer_name")).sendKeys("####");
        driver.findElement(By.id("customer_phone_number")).sendKeys("######");
        Thread.sleep(5000);
        driver.findElement(By.id("submit")).click();

        // Opens a new tab and switches to new tab to see the request in admin dashboard
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://example.com");
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("######");
        driver.findElement(By.id("login")).sendKeys("######");
        driver.findElement(By.cssSelector(".action-login > span")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Ocean")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[@id='menu-ocean-core-ocean']/div/ul/li[2]/ul/li/div/ul/li[9]/a/span")).click();
        Thread.sleep(5000);

        // Locate all rows in the table using the class name
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.even, tr.odd")); // Adjust based on your table's row classes

        if (rows.size() > 0) {
            // Get the first row
            WebElement firstRow = rows.get(0);

            // Get all cells in the first row
            List<WebElement> cells = firstRow.findElements(By.tagName("td"));

            // Print the data from each cell
            System.out.print("First row content: ");
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println(); // New line for readability

            // Assert that the first row has cells
            Assert.assertTrue(cells.size() > 0, "First row does not have any cells.");

            // Expected values to be checked
            String expectedValue1 = "مضرب";
            String expectedValue2 = "######";

            boolean foundExpectedValue1 = false;
            boolean foundExpectedValue2 = false;

            // Loop through each cell in the first row and check for the expected values
            for (WebElement cell : cells) {
                String cellText = cell.getText().trim();
                System.out.print(cellText + " | ");

                // Check if the expected values are present in the first row's cells
                if (cellText.contains(expectedValue1)) {
                    foundExpectedValue1 = true;
                }
                if (cellText.contains(expectedValue2)) {
                    foundExpectedValue2 = true;
                }
            }

            System.out.println(); // New line for readability

            // After the loop, assert that both expected values were found in the first row
            Assert.assertTrue(foundExpectedValue1, "Expected value '" + expectedValue1 + "' not found in the first row.");
            Assert.assertTrue(foundExpectedValue2, "Expected value '" + expectedValue2 + "' not found in the first row.");
        } else {
            System.out.println("No rows found in the table.");
        }

        //find the Test Order and click on it
        driver.findElement(By.xpath("//td[contains(.,'######')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='delete']/span")).click();
        Thread.sleep(5000); // Wait for the delete confirmation dialog to appear
        driver.findElement(By.xpath("//span[contains(.,'OK')]")).click();
        Thread.sleep(2000);


    }
}
