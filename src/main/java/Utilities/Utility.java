package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Utility {
    private static final String SCREENSHOTS_PATH = "test-outputs/Screenshots/";
    private static final ThreadLocal<WebDriverWait> threadLocalWait = new ThreadLocal<>();

    public static void clickingOnElement(WebDriver driver, By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(40))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (TimeoutException e) {
            LogsUtils.error("Failed to click on element. Locator: " + locator);
            throw e;
        }
    }

    public static WebElement findWebElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public static void sendData(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();

    }

    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebElement(driver, locator));
    }

    public static void selectingFromDropDown(WebDriver driver, By locator, String option) {
        new Select(findWebElement(driver, locator)).selectByVisibleText(option);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ssa").format(new Date());
    }

    /* public static void takeScreenShot(WebDriver driver, String screenshotName) {
         try {
             // Capture screenshot using TakesScreenshot
             File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

             // Save screenshot to a file if needed
             File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
             FileUtils.copyFile(screenshotSrc, screenshotFile);

             // Attach the screenshot to Allure
             Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
         } catch (Exception e) {
             LogsUtils.error(e.getMessage());
         }
     }
 */
    public static void takeFullScreenshot(WebDriver driver, By locator) {
        try {
            Shutterbug.shootPage(driver, Capture.FULL_SCROLL)
                    .highlight(findWebElement(driver, locator))
                    .save(SCREENSHOTS_PATH);
            LogsUtils.info("Screenshot saved successfully at: " + SCREENSHOTS_PATH);
        } catch (Exception e) {
            LogsUtils.error("Failed to take screenshot.");
        }
    }

    public static int generateRandomNumber(int upperBound) { //0 >> upper-1  > 5
        return new Random().nextInt(upperBound) + 1;
    }

    //Set >> unique >> 1,2,3,4,3 > condition
    public static Set<Integer> generateUniqueNumber(int numberOfProductsNeeded, int totalNumberOfProducts) //5 >> 50
    {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < numberOfProductsNeeded) { //11111 > 1 2 10 5 7
            int randomNumber = generateRandomNumber(totalNumberOfProducts);
            generatedNumbers.add(randomNumber);
        }
        return generatedNumbers;
    }


    public static String generateRandomNationalID() {
        StringBuilder nationalID = new StringBuilder("2"); // Start with "2"
        Random random = new Random();

        // Generate the remaining 13 digits
        for (int i = 0; i < 13; i++) {
            nationalID.append(random.nextInt(10)); // Appends a random digit (0-9)
        }

        return nationalID.toString();
    }

    /**
     * Generates a random email address ending with "@gmail.com".
     *
     * @return A random email address.
     */
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Allowed characters for email prefix
        StringBuilder emailPrefix = new StringBuilder();
        Random random = new Random();

        // Generate a random email prefix of length between 8 and 15 characters
        int prefixLength = 8 + random.nextInt(8); // Random length between 8 and 15
        for (int i = 0; i < prefixLength; i++) {
            emailPrefix.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Append the Gmail domain
        emailPrefix.append("@gmail.com");

        return emailPrefix.toString();
    }

    public static boolean VerifyURL(WebDriver driver, String expectedURL) {
        try {
            generalWait(driver).until(ExpectedConditions.urlToBe(expectedURL));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public static void restoreSession(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies)
            driver.manage().addCookie(cookie);
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0];
    }

    public static void refreshPage(WebDriver driver) {
        try {
            driver.navigate().refresh();
            LogsUtils.info("Page refreshed successfully.");
        } catch (Exception e) {
            LogsUtils.error("Failed to refresh page.");
            throw e;
        }
    }


    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void waitForPageToLoad(WebDriver driver, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }

    public static String generateRandomPhoneNumber(String prefix) {
        // Ensure the prefix has exactly 3 digits
        if (prefix == null || prefix.length() != 3 || !prefix.matches("\\d{3}")) {
            throw new IllegalArgumentException("Prefix must be exactly 3 digits.");
        }

        // Generate the remaining 8 digits randomly
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder(prefix);
        for (int i = 0; i < 8; i++) {
            phoneNumber.append(random.nextInt(10)); // Appends a random digit (0-9)
        }

        return phoneNumber.toString();
    }

}