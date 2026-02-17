package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void openUrl(String url) {
        Utility.openUrl(driver, url);
    }

    public void click(By locator) {
        Utility.clickingOnElement(driver, locator);
    }

    public void sendKeys(By locator, String text) {
        Utility.sendData(driver, locator, text);
    }

    public String getText(By locator) {
        return Utility.getText(driver, locator);
    }

    public void selectFromDropdown(By locator, String option) {
        Utility.selectingFromDropDown(driver, locator, option);
    }

    public void waitForPageToLoad(int timeout) {
        Utility.waitForPageToLoad(driver, timeout);
    }
}
