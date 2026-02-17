package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebProductPage extends BasePage {
    // Locators for the category page
    private By productTitle = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div.page-title-wrapper.product > h1");
    private By productPrice = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div.product-info-price");
    private By productImage = By.xpath("/html/body/div[3]/main/div[3]/div/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]");
    private By productBrand = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div.page-title-wrapper.product > div:nth-child(3)");
    private By productReviewsSummary = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div.product-reviews-summary");
    private By deliveryTimeButton = By.cssSelector("#delivery-time-button");
    private By addToWishList = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div.product-social-links > div > a");
    private By addToCartButton = By.cssSelector("#product-addtocart-button");
    private By qtySelector = By.cssSelector("#qty");
    private By productDescription = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-description");
    private By productAttributes = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-main > div.product-info-main > div:nth-child(8)");
    private By ReviewsSection = By.cssSelector("#reviews");
    private By writeReviewButton = By.cssSelector("#amreview-toform");
    private By sendReviewButton = By.cssSelector("#review-form > div > div > button");
    private By relatedProductsSection = By.cssSelector("#maincontent > div.columns > div > div.ocean-product-view-block.ocean-product-upsell > div > div > div > div > div > div > div:nth-child(1)");


    // Constructor
    public WebProductPage(WebDriver driver) {
        super(driver);
    }

    // Methods to locate web elements using Utility
    public void assertProductTitle() {
        Utility.findWebElement(driver, productTitle);
    }

    public void assertProductPrice() {
        Utility.findWebElement(driver, productPrice);
    }

    public void assertProductImage() {
        Utility.findWebElement(driver, productImage);
    }

    public void assertProductBrand() {
        Utility.findWebElement(driver, productBrand);
    }

    public void assertProductReviewsSummary() {
        Utility.findWebElement(driver, productReviewsSummary);
    }

    public void assertDeliveryTimeButton() {
        Utility.clickingOnElement(driver, deliveryTimeButton);
    }

    public void assertAddToWishList() {
        Utility.findWebElement(driver, addToWishList);
    }

    public void assertAddToCartButton() {
        Utility.findWebElement(driver, addToCartButton);
    }

    public void assertQtySelector() {
        Utility.findWebElement(driver, qtySelector);
    }

    public void assertProductDescription() {
        Utility.findWebElement(driver, productDescription);
    }

    public void assertProductAttributes() {
        Utility.findWebElement(driver, productAttributes);
    }

    public void assertReviewsSection() {
        Utility.findWebElement(driver, ReviewsSection);
    }

    public void assertWriteReviewButton() {
        Utility.findWebElement(driver, writeReviewButton);
    }

    public void assertSendReviewButton() {
        Utility.findWebElement(driver, sendReviewButton);
    }

    public void assertRelatedProductsSection() {
        Utility.findWebElement(driver, relatedProductsSection);
    }


}
