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

public class HomePageCategoryViewARTest {

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

        driver.get("https://www.raneen.com/ar");

        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.link.authorization-link")).getText(), is("تسجيل الدخول"));
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li.greet.welcome")).getText(), is("مرحبا بك"));
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li:nth-child(2)")).getText(), is("ابدأ البيع على رنين"));
        assertThat(driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper > div > ul > li:nth-child(4)")).getText(), is("قم بإنشاء حساب"));
        driver.findElement(By.cssSelector("#ammenu-header-container > div.panel.wrapper")).isDisplayed();  //hearder
        driver.findElement(By.cssSelector("#switcher-language")).isDisplayed();          //languageSelector
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > a")).isDisplayed();     //raneen
        driver.findElement(By.cssSelector("#autocomplete-0-input")).click();                                             //search bar
        driver.findElement(By.cssSelector("#ammenu-header-container > div.header.content > div.minicart-wrapper")).isDisplayed(); //add T cart
        driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.ammenu-menu-wrapper > div.ammenu-nav-sections.-topmenu.-hamburger")).isDisplayed();     //categories bar
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(5)")).isDisplayed(); //main banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(6)"));    // categories section
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
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("كل اجهزة البيت من مكان واحد"));
        //refrigerators & freezers div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //refrigerators & freezers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("الثلاجات والفريزر"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).click(); //refrigerators & freezers div
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
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("الغسالات والمجففات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).click(); // washer and dryers div
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
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("بوتاجازات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).click(); //cookers div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //air conditioners div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //air conditioners div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("تكييفات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); // air conditioner title
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
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div")).isDisplayed();  //For Easier Cooking div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("لطبخ أسهل"));
        //pots div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //pots div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("حلل"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //pots title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //frying pan div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //frying pan div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("قلايات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //frying pan title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //dinner ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //dinner ware div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("أطقم عشاء"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //dinnerware title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all products
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //oven trays div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //oven trays div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("صواني فرن"));
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
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div")).isDisplayed();  //towards a modern home div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("نحو منزل عصرى حديث"));
        //televisions & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //televisions & accessories
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("أكسسوارات التلفزيونات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //Televisions Accessories title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Televisions
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //televisions div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("التلفزيونات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //televisions title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //computers & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //computers & accessories div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("أكسسوارات الكمبيوتر"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //computers & accessories title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //laptops
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //laptops div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("لاب توب"));
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
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //Cold or warm home ? make it as you want div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("بيت دافئ؟ بارد؟ أجعله كما تريد"));
        //vacuum cleaners
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed();  //vacuum cleaner div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("مكانس كهربائية"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click();  //vacuum cleaner title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //irons
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed();  //irons div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("مكاوي"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click();  //irons title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //fans
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed();  //fans div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("مراوح"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click();  //fans title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //heaters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed();  //heaters div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(14) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("دفايات"));
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
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(15) > div > div > div > div:nth-child(2)")).isDisplayed(); //wait every day div

        //Comfy rooms that hard to leave
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16)")).isDisplayed();  //comfy rooms div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > h2")).getText(), is("غرف مريحة يصعب عليك تركها"));
        //outdoor furniture
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed();  //outdoor furniture div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("أثاث خارجي"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click();  //outdoor furniture title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Rugs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed();  //rugs div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("سجاد"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click();  // rugs title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //home decor
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed();  //home decor div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("ديكور المنزل"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click();  //home decor title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();//all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();


        //Frames
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed();  //frames div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("براويز"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click();  //frames title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();

        //storage units
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3)")).isDisplayed();  //storage units div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).getText(), is("وحدات تخزين"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).click();  //storage units title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //mirrors
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3)")).isDisplayed();  //mirrors div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).getText(), is("مرايات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).click();  //mirrors title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //dinning room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4)")).isDisplayed();  //dinning room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).getText(), is("غرفة الطعام"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).click();  //dinning room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //L-shape sofa
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4)")).isDisplayed();  //L-shape sofa div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).getText(), is("كنبة ركنة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).click();  //l shape title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Bed-room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5)")).isDisplayed();  //bed-room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).getText(), is("غرفة النوم"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).click();  //bed-room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Lightings
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5)")).isDisplayed();  //lighttings div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).getText(), is("الإضاءة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).click();  //lightings title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //Living-room
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6)")).isDisplayed();  //living room div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).getText(), is("غرفة المعيشة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).click();  //living room title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed();  //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed();  //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed();  //1st prod div
        driver.navigate().back();
        //office furniture
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6)")).isDisplayed();  //office div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(16) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).getText(), is("أثاث المكتب"));
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

        //baby care banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(3)")).click(); //personal care div
        assertThat(driver.findElement(By.cssSelector("#page-title-heading > span")).getText(), is("العناية بالطفل"));
        driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.category-view")).isDisplayed(); //main div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //appliances banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(2)")).click(); //appliances div
        assertThat(driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.page-main > div.page-title-wrapper")).getText(), is("عروض الاجهزة المنزلية"));
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //personal banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(19) > div > div > div > div:nth-child(1)")).click(); //baby care div
        assertThat(driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.page-main > div.page-title-wrapper")).getText(), is("العناية الشخصية"));
        driver.findElement(By.cssSelector("#html-body > div.page-wrapper > div.category-view")).isDisplayed(); //main div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //2nd slider
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(21)")).isDisplayed(); //2nd slider div

        //mobile & accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("موبيلات و أكسسوارات"));
        //mobile
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed(); //mobile div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("الموبيلات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click(); //mobile title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //smart-watches
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed(); //smart-watches div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("الساعات الذكيه"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click(); //smart-watches title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Airpods
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed(); //airpods div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("ايربودز"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click(); //airpods title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //mobile accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("إكسسوارات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(1) > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Looking for kitchen for professionals
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //Looking for kitchen for professionals div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("هل تبحثى عن مطبخ لمحترفى الطبخ؟"));
        //sandwich maker
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //sandwich maker div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("محضر الساندوتش"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //coffee makers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //coffee makers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("صانع القهوة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //juicers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //juicers div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("عصارات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.navigate().back();
        //kitchen machine
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("محضر الطعام و العجان"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //shoes & clothes
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("الاحذية والملابس"));
        //clothes for men
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("ملابس الرجال"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //shoes for men
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("أحذية للرجال"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //clothes for women
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("ملابس النساء"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //shoes for women
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("أحذية للسيدات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Fancy serving tools
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("أدوات تقديم و أواني راقية"));
        //Dinnerware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("أوانى الطعام"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Drink ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("أدوات الشرب"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Serve ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("أدوات التقديم"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bowl
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("بولات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(24) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Beautiful home furnishings
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > h2")).getText(), is("مفروشات لبيت جميل"));
        //pillows
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).getText(), is("الوسائد"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //table cloth
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).getText(), is("مفارش طاولات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Towels
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).getText(), is("المناشف و الفوط"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Rugs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).getText(), is("سجاد & دواسات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //mattress
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).getText(), is("مراتب"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(3) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod
        driver.navigate().back();
        //Blanket
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).getText(), is("البطاطين"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(3) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod
        driver.navigate().back();
        //Chairs cover
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).getText(), is("أغطية الكراسي"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(4) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bed heater
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).getText(), is("دفايات السرير"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(4) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Bed sheets
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).getText(), is("ملايات السرير"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(5) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Quilt
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).getText(), is("لحاف"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(5) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Curtain
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).getText(), is("ستارة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(1) > div:nth-child(6) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Comforters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).getText(), is("كوفرتة"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div.pagebuilder-column-group > div:nth-child(2) > div:nth-child(6) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(25) > div > div > div > div > div > div:nth-child(3) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //appliances banner
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(28) > div > div")).isDisplayed(); // banner

        //bags to suit your needs
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("شنط تناسب احتياجاتك"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(1) > div > div > div > div > figure > a")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Happy Kid Happy Home
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is(" طفل سعيد بيت سعيد                                                                           "));
        //bike scooters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("درجات واسكوتر"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Baby
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("مستلزمات الطفل"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Action toys
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("العاب الحركة والنشاط"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Dolls
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("دمي والعاب"));
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
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("ما الذي ينقص مطبخك؟                                                                           "));
        //microwaves & ovens
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("المايكرويف والأفران"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //meat grinder
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("مفرمة اللحوم"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Mixers blenders
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("الخلاطات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Grinders
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("المطاحن"));
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
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("أجهزة منزل الأحلام                                                                            "));
        //Dish Washers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("غسالات الأطباق"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Water dispensers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("مبردات المياه"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Water heaters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("سخانات المياه"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Built-in-Appliances
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(29) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("أجهزة بلت إن"));
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
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > h2")).getText(), is("أجهزة عناية رائعة سهلة الاستخدام                                                         "));
        //Shaving grooming
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("الحلاقة والتشذيب"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Hair care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("أجهزة تصفيف الشعر"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Beauty body care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("العناية بالجسم"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Personal care
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("العناية الشخصية"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(1) > div > div > div > div > div:nth-child(4) > div > a")).click(); //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Perfect Kitchen ? What's Better Than That
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > h2")).getText(), is("مطبخ مثالي ؟ لا يوجد افضل من ذلك                                                                  "));
        //Fryers
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("قلايات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Grill
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("شوايات كهربائية"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Toasters
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("توستر"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Kettles
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("غلايات"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(2) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Wardrobe
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(3) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(3) > div > div > div > div > h2")).getText(), is("دولاب"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(3) > div > div > div > div > figure")).click(); //
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

        //Tools for a more organized kitchen
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > h2")).getText(), is("أدوات لمطبخ اكثر ترتيبا                                                          "));
        //Kitchen ware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).getText(), is("أدوات الطبخ"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Cookware
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).getText(), is("أدوات المطبخ"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(2) > div > div:nth-child(2) > div")).click(); //
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prod
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //Kitchen accessories
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).getText(), is("أكسسوار المطبخ"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();


        //accessories storage
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2)")).isDisplayed(); //div
        assertThat(driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).getText(), is("مستلزمات التخزين"));
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(3) > div > div:nth-child(2) > div")).click(); //title
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();
        //watch more
        driver.findElement(By.cssSelector("#maincontent > div.columns > div > div:nth-child(30) > div > div > div > div:nth-child(4) > div > div > div > div > div:nth-child(4) > div > a")).click(); //div
        driver.findElement(By.cssSelector("#maincontent > div.columns > div.sidebar.sidebar-main")).isDisplayed(); //filters
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol")).isDisplayed(); //all prods
        driver.findElement(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid.amscroll-page > ol > li:nth-child(1)")).isDisplayed(); //1st prod div
        driver.navigate().back();

    }
}
