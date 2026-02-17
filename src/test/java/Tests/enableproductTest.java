import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnableProductTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cache", "--disable-application-cache", "--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void enableProduct() {
        driver.get("https://www.example.com/admin/admin/");

        // Page Objects
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        EditProductPage editProductPage = new EditProductPage(driver);

        // Test Steps
        loginPage.enterUsername("######");
        loginPage.enterPassword("######");
        loginPage.clickLogin();

        dashboardPage.openCatalogMenu();
        dashboardPage.clickProductsSubMenu();

        productsPage.searchForProduct("Test");
        productsPage.openProductForEditing();

        editProductPage.enableProduct();
        editProductPage.saveProduct();
    }
}
