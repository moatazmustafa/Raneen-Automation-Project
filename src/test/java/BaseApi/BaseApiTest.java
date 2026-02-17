package BaseApi;

import Utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected WebDriver driver;

    // ✅ Configurable base URL (safe default)
    protected final String baseUrl = getEnv("BASE_URL", "https://example.com");

    // ✅ Never hardcode secrets in public repos
    // Use environment variables: RANEEN_API_KEY / RANEEN_API_SECRET
    protected final String apiKey = requireEnv("########");
    protected final String apiSecret = requireEnv("######");

    // ✅ Avoid personal/company email in code
    // Use env var EXISTING_EMAIL or keep it empty for public snapshot
    protected final String existingEmail = getEnv("EXISTING_EMAIL", "test.user@example.com");

    @BeforeClass
    public void setup() {
        setupRestAssured();
        setupWebDriver();
    }

    private void setupRestAssured() {
        RestAssured.baseURI = baseUrl;
        RestAssured.config = RestAssured.config().encoderConfig(
                EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)
        );
    }

    private void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless=new",
                "--window-size=1920,1080",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--remote-allow-origins=*",
                "--disable-extensions"
        );

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

        // ✅ Use safe/neutral path (your public repo shouldn’t force real prod pages)
        driver.get(baseUrl);
        Utility.waitForPageToLoad(driver, 10);
    }

    protected RequestSpecification withDefaultHeaders() {
        return RestAssured.given()
                .header("apiKey", apiKey)
                .header("apiSecret", apiSecret)
                .accept(ContentType.JSON);
    }

    public static String randomEmail() {
        return "testuser" + System.currentTimeMillis() + "@example.com";
    }

    public String existingEmail() {
        return existingEmail;
    }

    protected String extractToken(Response response) {
        // ✅ Never print tokens in logs
        return response.jsonPath().getString("customerToken");
    }

    protected Response loginCustomer(String email, String password) {
        return withDefaultHeaders()
                .multiPart("username", email)
                .multiPart("password", password)
                .multiPart("storeId", "2")
                .post("/mobileapi/customer/login");
    }

    protected String extractSessionId(Response response) {
        // ✅ Never print session id
        return response.getCookie("PHPSESSID");
    }

    protected void injectSessionIntoBrowser(String sessionId) {
        // ✅ Domain must match BASE_URL host. Don’t hardcode company domains.
        String host = hostFromUrl(baseUrl);

        Cookie sessionCookie = new Cookie.Builder("PHPSESSID", sessionId)
                .domain(host)
                .path("/")
                .isHttpOnly(true)
                .build();

        driver.manage().addCookie(sessionCookie);
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // -------------------------
    // Helpers
    // -------------------------

    private static String getEnv(String key, String defaultValue) {
        String v = System.getenv(key);
        return (v == null || v.isBlank()) ? defaultValue : v.trim();
    }

    private static String requireEnv(String key) {
        String v = System.getenv(key);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException(
                    "#######" + key +
                            " (####)"
            );
        }
        return v.trim();
    }

    private static String hostFromUrl(String url) {
        // simple safe parsing without extra libs
        // example: https://www.example.com -> www.example.com
        String cleaned = url.replace("https://", "").replace("http://", "");
        int slash = cleaned.indexOf("/");
        return (slash == -1) ? cleaned : cleaned.substring(0, slash);
    }
}