package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePageCategoryViewENTest {


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
    public void open_screen_setup() {

        driver.get("https://www.example.com/en/");
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.link.authorization-link > a")).getText(), is("Sign In"));
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.greet.welcome > span")).getText(), is("Welcome to Raneen.com"));
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li:nth-child(2) > a")).getText(), is("Sell at Raneen"));
        assertThat(driver.findElement(By.xpath("//li[4]/a")).getText(), is("Create an Account"));
        driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div")).click();  //hearder
        driver.findElement(By.cssSelector("#switcher-language-trigger > strong > span")).click();          //languageSelector
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > a > img")).isDisplayed();     //raneen
        driver.findElement(By.cssSelector("#autocomplete-0-input")).click();                                             //search bar
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > div.minicart-wrapper > a")).isDisplayed(); //add T cart
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div:nth-child(3) > div > figure > a > img.pagebuilder-mobile-hidden")).isDisplayed();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(5) > div > div > div > div:nth-child(2) > div > div > div > div > div.slick-slide.slick-current.slick-active > div > div > a > div > div")).isDisplayed(); //main banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div"));    // categories section
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(1) > figure > a > img.pagebuilder-mobile-hidden")).click();  //laptop
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(2)")).click(); // home tools
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(3)")).click(); // health & beauty
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(3)")).click(); //carpets
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(5)")).click(); //air fryer
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(6)")).click(); //car care
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(7)")).click(); //office supplies
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(8)")).click(); //baby accessories
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(9)")).click(); //top-selling
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(10)")).click(); //security system
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(11)")).click(); //product B.tech
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6) > div > div > div > div:nth-child(12) > figure > a > img.pagebuilder-mobile-hidden")).click(); //lights corner
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(7) > div > div > div > div > figure > a > img.pagebuilder-mobile-hidden")).click();   //buy now pay later banner
        driver.navigate().back();
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(8) > div > div.pagebuilder-column-group > div > div:nth-child(1) > figure > a > img.pagebuilder-mobile-hidden")).isDisplayed(); //todays offer
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(8) > div > div.pagebuilder-column-group > div > div:nth-child(2) > figure > a > img.pagebuilder-mobile-hidden")).isDisplayed(); //one day offer
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(8) > div > div.pagebuilder-column-group > div > div:nth-child(3) > figure > a > img.pagebuilder-mobile-hidden")).isDisplayed(); //budget deal

        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(11) > div")); //bestselling section
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(13) > div > div > div > div > div > div > div > div > div > ol > li:nth-child(1) > div > a > img")).isDisplayed();  //first prod image
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(13) > div > div > div > div > div > div > div > div > div > ol > li:nth-child(1) > div > div > strong > a > span")).click(); //first prod title
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
        driver.navigate().back();

        //all home appliances div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(13) > div > div")).isDisplayed(); //all home appliances div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("All Home Appliances From One Place "));
        //refrigerators & freezers div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //refrigerators & freezers div
        assertThat(driver.findElement(By.xpath("//*[@id=\"ETFIWVR\"]")).getText(), is("Refrigerators and Freezers"));
        driver.findElement(By.xpath("//*[@id=\"ETFIWVR\"]")).click(); //refrigerators & freezers div
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all products
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); // filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); // 1 product
        driver.findElement(By.cssSelector("#product-item-info_77897 > a > span > span > img")).isDisplayed(); // 1 product image
        driver.findElement(By.cssSelector("#product-item-info_77897 > div > div.price-box.price-final_price")).isDisplayed(); // 1 product price
        driver.findElement(By.cssSelector("#product-item-info_77897 > div > strong")).click(); // 1 product title
        driver.findElement(By.cssSelector("#product-addtocart-button")).click(); // add T cart
        driver.navigate().back();
        driver.navigate().back();
        //washer and dryers div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //washer and dryers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div > p > a")).getText(), is("Washers and Dryers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div > p > a")).click(); // washer and dryers div
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); // all products
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); // filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); // 1st product
        driver.findElement(By.cssSelector("#product-item-info_102927 > a > span > span > img")).isDisplayed(); // 1st product image
        driver.findElement(By.cssSelector("#product-item-info_102927 > div > div.price-box.price-final_price")).isDisplayed(); // 1st product price
        driver.findElement(By.cssSelector("#product-item-info_102927 > div > strong > a")).click(); // 1st product title
        driver.findElement(By.cssSelector("#product-addtocart-button")).click(); // add T cart
        driver.navigate().back();
        driver.navigate().back();

        //cookers div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //cookers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > p > a")).getText(), is("Cookers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > p > a")).click(); //cookers div title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //air conditioners div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //air conditioners div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div > p > a")).getText(), is("Air conditioners"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div > p > a")).click(); // air conditioner title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); // filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); // all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); // 1st prod div
        driver.navigate().back();
        // 1st watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(4) > div > a")).click(); // 1st watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); // filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); // al products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); // 1st prod div
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); // 1st prod div
        driver.navigate().back();


        //For Easier Cooking div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div")).isDisplayed();  //For Easier Cooking div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("For Easier Cooking"));
        //pots div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //pots div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Pots"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //pots title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //frying pan div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //frying pan div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Frying Pan"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //frying pan title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //dinner ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //dinner ware div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Dinnerware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //dinnerware title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //oven trays div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //oven trays div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Oven Trays"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click();  //oven trays title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click();  //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //towards a modern home
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div")).isDisplayed();  //towards a modern home div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("To wrads a modern home"));
        //televisions & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //televisions & accessories
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Televisions Accessories"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //Televisions Accessories title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Televisions
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //televisions div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Televisions"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //televisions title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //computers & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //computers & accessories div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Computers Accessories"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //computers & accessories title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //laptops
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //laptops div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Laptops"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click();  //laptops title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(4) > div > a")).click();  //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //Cold or warm home ? make it as you want
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div")).isDisplayed(); //Cold or warm home ? make it as you want div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("Cold or warm home ? make it as you want"));
        //vacuum cleaners
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //vacuum cleaner div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Vacuum Cleaners"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //vacuum cleaner title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //irons
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //irons div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Irons"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //irons title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //fans
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //fans div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Fans"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //fans title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //heaters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //heaters div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Heaters"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click();  //heaters title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click();  //watch more div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //wait every day
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(15)")).isDisplayed(); //wait every day div

        //Comfy rooms that hard to leave
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16)")).isDisplayed();  //comfy rooms div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > h2")).getText(), is("Comfy rooms that hard to leave"));
        //outdoor furniture
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed();  //outdoor furniture div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("Outdoor Furniture"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click();  //outdoor furniture title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Rugs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed();  //rugs div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("Rugs"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click();  // rugs title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //home decor
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed();  //home decor div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("Home Decor"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click();  //home decor title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();//all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Frames
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed();  //frames div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("Frames"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click();  //frames title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //storage units
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3)")).isDisplayed();  //storage units div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).getText(), is("Storage Units"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).click();  //storage units title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //mirrors
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3)")).isDisplayed();  //mirrors div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).getText(), is("Mirrors"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).click();  //mirrors title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //dinning room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4)")).isDisplayed();  //dinning room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).getText(), is("Dining Room"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).click();  //dinning room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //L-shape sofa
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4)")).isDisplayed();  //L-shape sofa div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).getText(), is("L-Shape Sofa"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).click();  //l shape title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Bed-room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5)")).isDisplayed();  //bed-room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).getText(), is("Bed Room"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).click();  //bed-room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Lightings
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5)")).isDisplayed();  //lighttings div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).getText(), is("Lightings"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).click();  //lightings title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Living-room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6)")).isDisplayed();  //living room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).getText(), is("Living Room"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).click();  //living room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //office furniture
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6)")).isDisplayed();  //office div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).getText(), is("Office Furniture"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).click();  //office title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div:nth-child(3) > div > a")).click();  //watch more div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //personal care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(1)")).click(); //personal care div
        assertThat(driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.page-main > div.page-title-wrapper")).getText(), is("Personal Care"));
        driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.category-view")).isDisplayed(); //main div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Beko gift
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(2)")).click(); //beko gift div
        assertThat(driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.page-main > div.page-title-wrapper")).getText(), is("Beko Gift"));
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //baby care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(3)")).click(); //baby care div
        assertThat(driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.page-main > div.page-title-wrapper")).getText(), is("Baby Care"));
        driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.category-view")).isDisplayed(); //main div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //2nd slider
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(21)")).isDisplayed(); //2nd slider div

        //mobile & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("Mobile and Accessories"));
        //mobile
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed(); //mobile div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("Mobile"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click(); //mobile title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //smart-watches
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed(); //smart-watches div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("Smart Watches"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click(); //smart-watches title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Airpods
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed(); //airpods div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("Airpods"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click(); //airpods title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //mobile accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("Mobile Accessories"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Looking for kitchen for professionals
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //Looking for kitchen for professionals div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("Looking for kitchen for professionals"));
        //sandwich maker
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //sandwich maker div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Sandwich Makers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //coffee makers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //coffee makers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Coffee Makers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //juicers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //juicers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Juicers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.navigate().back();
        //kitchen machine
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Kitchen Machine"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //shoes & clothes
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("Shoes and Clothes"));
        //clothes for men
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Clothes For Men"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //shoes for men
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Shoes For Men"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //clothes for women
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Clothes For Women"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //shoes for women
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Shoes For Women"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Fancy serving tools
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("Fancy serving tools"));
        //Dinnerware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Dinnerware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Drink ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Drinkware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Serve ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Serveware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bowl
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Bowl"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(22) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Beautiful home furnishings
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > h2")).getText(), is("Beautiful home furnishings"));
        //pillows
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("Pillows"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //table cloth
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("Tablecloth"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Towels
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("Towels"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Rugs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("Rugs"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //mattress
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).getText(), is("Mattress"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod
        driver.navigate().back();
        //Blanket
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).getText(), is("Blanket"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod
        driver.navigate().back();
        //Chairs cover
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).getText(), is("Chairs Cover"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bed heater
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).getText(), is("Bed Heater"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bed sheets
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).getText(), is("Bed Sheets"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Quilt
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).getText(), is("Quilt"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Curtain
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).getText(), is("curtain"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Comforters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).getText(), is("Comforters"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(23) > div > div > div > div > div > div:nth-child(3) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //appliances banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24)")).isDisplayed(); // banner

        //bags to suit your needs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("Bags to suit your needs"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div > div > div > div > figure")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Happy Kid Happy Home
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("Happy Kid Happy Home "));
        //bike scooters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Bike Scooters"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Baby
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Baby"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Action toys
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Action Toys"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Dolls
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Dolls"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //What is missing in your kitchen?
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("What is missing in your kitchen?"));
        //microwaves & ovens
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Microwaves and Ovens"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //meat grinder
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Meat Grinders"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Mixers blenders
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Mixers Blenders"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Grinders
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Grinders"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Dream home appliances
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("Dream home appliances"));
        //Dish Washers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Dish Washers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Water dispensers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Water Dispensers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Water heaters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Water Heaters"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Built-in-Appliances
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Built-in-Appliances"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Great care devices that are easy to use
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("Great care devices that are easy to use"));
        //Shaving grooming
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Shaving Grooming"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Hair care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Hair Care"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Beauty body care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Beauty Body Care"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Personal care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Personal Care"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Perfect Kitchen ? What's Better Than That
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("Perfect Kitchen ? What's Better Than That"));
        //Fryers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Fryers"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Grill
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Grill"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Toasters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Toasters"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Kettles
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Kettles"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Wardrobe
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(3) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("Wardrobe"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(3) > div > div > div > div > figure")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Tools for a more organized kitchen
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("Tools for a more organized kitchen"));
        //Kitchen ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("Kitchenware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Cookware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("Cookware"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Kitchen accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("Kitchen Accessories"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //accessories storage
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("Accessories Storge"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(31) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

    }
}
