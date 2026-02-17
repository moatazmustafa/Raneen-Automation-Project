package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebCategoryPage extends BasePage {

    // Locators for the category page
    private By allProducts = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol");
    private By firstProduct = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(3)"); // First product in the grid
    private By secondProduct = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(4)"); // Second product
    private By thirdProduct = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(5)"); // Third product
    private By productTitle = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(3) > div > div.product.details.product-item-details > strong"); // Product title
    private By productPrice = By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(3) > div > div.product.details.product-item-details > div.price-box.price-final_price"); // Product price
    private By gridViewButton = By.cssSelector("#mode-grid"); // Grid view toggle button
    private By listViewButton = By.cssSelector("#mode-list"); // List view toggle button
    private By filtersSideBar = By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main"); // Filter by category
    private By sortByButton = By.cssSelector("#amasty-shopby-product-list > div:nth-child(1) > div.toolbar-sorter.sorter > a"); // Sort by dropdown
    private By sortByDropDownButton = By.cssSelector("#sorter");
    private By loadMoreButton = By.cssSelector(".toolbar .action.loadmore"); // Load more button (if available)

    // Constructor
    public WebCategoryPage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with elements

    public void assertallProductsDiv() {
        Utility.findWebElement(driver, allProducts);
    }

    public void assertFirstProduct() {
        Utility.findWebElement(driver, firstProduct);
    }

    public void assertSecondProduct() {
        Utility.findWebElement(driver, secondProduct);
    }

    public void assertThirdProduct() {
        Utility.findWebElement(driver, thirdProduct);
    }

    public String assertProductTitle() {
        return Utility.getText(driver, productTitle);
    }

    public void assertProductPrice() {
        Utility.findWebElement(driver, productPrice);
    }

    public void switchToGridView() {
        Utility.clickingOnElement(driver, gridViewButton);
    }

    public void switchToListView() {
        Utility.clickingOnElement(driver, listViewButton);
    }

    public void assertFiltersSideBar() {
        Utility.findWebElement(driver, filtersSideBar);
    }

    public void assertSortByButton() {
        Utility.findWebElement(driver, sortByButton);
    }

    public void assertSortByDropDownButton() {
        Utility.findWebElement(driver, sortByDropDownButton);
    }

}
