package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebHomePage extends BasePage {


    // Locators
    private By allCategories = By.cssSelector("#ammenu-header-container > div.header.content > button");
    private By menuTap = By.cssSelector("#ammenu-sidebar > ul.ammenu-tabs-list > li:nth-child(1) > button");
    private By appliances = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(1) > a > p");
    private By mobiles = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(2) > a > p");
    private By electronics = By.name("Go to الإلكترونيات");
    private By SecuritySurveillanceSystems = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(4) > a > p");
    private By home = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(5) > a > p");
    private By kitchen = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(6) > a > p");
    private By textile = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(7) > a > p");
    private By furniture = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(8) > a > p");
    private By familyProducts = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(9) > a > p");
    private By fashion = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(10) > a > p");
    private By lightingHomeDecore = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(11) > a > p");
    private By homeEssentials = By.cssSelector("#ammenu-sidebar > ul.ammenu-items.-root > li:nth-child(12) > a > p");
    private By accountTap = By.cssSelector("#ammenu-sidebar > ul.ammenu-tabs-list > li:nth-child(2) > button");
    private By signInFromAccount = By.cssSelector("#ammenu-sidebar > section.ammenu-account-section > ul > li:nth-child(1) > a > p");
    private By signUpFromAccount = By.cssSelector("#ammenu-sidebar > section.ammenu-account-section > ul > li:nth-child(2) > a > p");
    private By helpAndSetting = By.cssSelector("#ammenu-sidebar > section.ammenu-account-section > ul > li:nth-child(3) > button > figure > svg");


    // Constructor
    public WebHomePage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with elements
    public void clickAllCategories() {
        Utility.clickingOnElement(driver, allCategories);
    }

    public void clickMenuTab() {
        Utility.clickingOnElement(driver, menuTap);
    }

    public void clickAppliances() {
        Utility.clickingOnElement(driver, appliances);
    }

    public void clickMobiles() {
        Utility.clickingOnElement(driver, mobiles);
    }

    public void clickElectronics() {
        Utility.clickingOnElement(driver, electronics);
    }

    public void clickSecuritySurveillanceSystems() {
        Utility.clickingOnElement(driver, SecuritySurveillanceSystems);
    }

    public void clickHome() {
        Utility.clickingOnElement(driver, home);
    }

    public void clickKitchen() {
        Utility.clickingOnElement(driver, kitchen);
    }

    public void clickTextile() {
        Utility.clickingOnElement(driver, textile);
    }

    public void clickFurniture() {
        Utility.clickingOnElement(driver, furniture);
    }

    public void clickFamilyProducts() {
        Utility.clickingOnElement(driver, familyProducts);
    }

    public void clickFashion() {
        Utility.clickingOnElement(driver, fashion);
    }

    public void clickLightingHomeDecore() {
        Utility.clickingOnElement(driver, lightingHomeDecore);
    }

    public void clickHomeEssentials() {
        Utility.clickingOnElement(driver, homeEssentials);
    }

    public void clickAccountTab() {
        Utility.clickingOnElement(driver, accountTap);
    }

    public void clickSignInFromAccount() {
        Utility.clickingOnElement(driver, signInFromAccount);
    }

    public void clickSignUpFromAccount() {
        Utility.clickingOnElement(driver, signUpFromAccount);
    }

    public void clickHelpAndSettings() {
        Utility.clickingOnElement(driver, helpAndSetting);
    }
}

