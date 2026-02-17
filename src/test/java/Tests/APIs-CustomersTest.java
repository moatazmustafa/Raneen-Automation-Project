package Tests;

import BaseApi.BaseApiTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ApiAccountInfoDataTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiAccountInfoDataTest.class);

    private final String customerToken = System.getenv("RANEEN_CUSTOMER_TOKEN");
    private static final int STORE_AR = #;
    private static final int STORE_EN = #;

    private void requireTokenOrSkip() {
        if (customerToken == null || customerToken.isBlank()) {
            throw new SkipException("Skipping: set env RANEEN_CUSTOMER_TOKEN to run valid account info tests.");
        }
    }

    private void logSafe(Response response, String action) {
        log.info("[{}] status={} contentType={}", action, response.statusCode(), response.contentType());
        try {
            log.info("[{}] success={} message={}",
                    action,
                    response.jsonPath().getBoolean("success"),
                    response.jsonPath().getString("message"));
        } catch (Exception ignored) {}
    }

    @Test(priority = 1)
    public void testAccountInfoData_ValidToken_AR() {
        requireTokenOrSkip();
        log.info("Account Info Data (AR) - Valid token");

        Response response = withDefaultHeaders()
                .queryParam("customerToken", customerToken)
                .queryParam("storeId", STORE_AR)
                .get("############");

        logSafe(response, "AccountInfo_AR_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                // ✅ no PII assertions
                .body("email", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("firstName", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("lastName", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("mobile_number", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("eTag", notNullValue());
    }

    @Test(priority = 2)
    public void testAccountInfoData_InvalidToken_AR() {
        log.info("Account Info Data (AR) - Invalid token");
        String invalidCustomerToken = "invalid_token_123";

        Response response = withDefaultHeaders()
                .queryParam("customerToken", invalidCustomerToken)
                .queryParam("storeId", STORE_AR)
                .get("##############");

        logSafe(response, "AccountInfo_AR_Invalid");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("otherError", anyOf(equalTo("customerNotExist"), not(isEmptyOrNullString())))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }

    @Test(priority = 3)
    public void testAccountInfoData_ValidToken_EN() {
        requireTokenOrSkip();
        log.info("Account Info Data (EN) - Valid token");

        Response response = withDefaultHeaders()
                .queryParam("customerToken", customerToken)
                .queryParam("storeId", STORE_EN)
                .get("###############");

        logSafe(response, "AccountInfo_EN_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("email", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("firstName", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("lastName", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("mobile_number", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("eTag", notNullValue());
    }

    @Test(priority = 4)
    public void testAccountInfoData_InvalidToken_EN() {
        log.info("Account Info Data (EN) - Invalid token");
        String invalidCustomerToken = "invalid_token_123";

        Response response = withDefaultHeaders()
                .queryParam("customerToken", invalidCustomerToken)
                .queryParam("storeId", STORE_EN)
                .get("#################");

        logSafe(response, "AccountInfo_EN_Invalid");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("otherError", anyOf(equalTo("customerNotExist"), not(isEmptyOrNullString())))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }
}


public class ApiCreateNewAccountTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiCreateNewAccountTest.class);

    private final String createPassword = System.getenv().getOrDefault("######", "####");
    private final String existingEmailEnv = System.getenv("RANEEN_EXISTING_EMAIL"); // optional

    @Description("Create new account - public safe version (no secrets in repo)")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("########")
    @Link(name = "Create new account", url = "https://www.example.com/ar/")
    @Epic("Testing Automation")
    @Feature("Create new account")
    @Story("Create new account")

    @Test(priority = 1)
    public void validCreateNewAccount_AR() {
        log.info("Create account (AR) - Valid data (random email)");
        String randomEmail = randomEmail();

        Response response = given()
                .header("APIKey", API_KEY)
                .header("APISecret", API_SECRET)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Test")
                .multiPart("lastName", "User")
                .multiPart("email", randomEmail)
                .multiPart("password", createPassword)
                .multiPart("confirmation", createPassword)
                .multiPart("storeId", "2")
                .post("##########");

        log.info("status={} contentType={}", response.statusCode(), response.contentType());

        response.then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("success", equalTo(true))
                .body("customerId", notNullValue())
                .body("cartCount", equalTo(0))
                .body("customerEmail", equalTo(randomEmail))
                .body("customerToken", notNullValue());
    }

    @Test(priority = 2)
    public void invalidPassword_AR() {
        log.info("Create account (AR) - Invalid password");
        RestAssured.baseURI = baseUrl;
        String randomEmail = randomEmail();

        Response response = given()
                .config(RestAssured.config().encoderConfig(
                        encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("APIKey", API_KEY)
                .header("APISecret", API_SECRET)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Test")
                .multiPart("lastName", "User")
                .multiPart("email", randomEmail)
                .multiPart("password", "#")
                .multiPart("confirmation", createPassword)
                .multiPart("storeId", "#")
                .post("##############");

        log.info("status={}", response.statusCode());

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 3)
    public void invalidEmail_AR() {
        log.info("Create account (AR) - Invalid email");
        RestAssured.baseURI = baseUrl;

        String badEmail = "testuser" + System.currentTimeMillis() + "@.com";

        Response response = given()
                .config(RestAssured.config().encoderConfig(
                        encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("APIKey", API_KEY)
                .header("APISecret", API_SECRET)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Test")
                .multiPart("lastName", "User")
                .multiPart("email", badEmail)
                .multiPart("password", createPassword)
                .multiPart("confirmation", createPassword)
                .multiPart("storeId", "#")
                .post("##############");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 4)
    public void validateExistingEmail_AR() {
        // ✅ only run if env is provided, do not hardcode a real email
        if (existingEmailEnv == null || existingEmailEnv.isBlank()) {
            log.warn("Skipping: set env RANEEN_EXISTING_EMAIL to run existing-email test.");
            return;
        }

        log.info("Create account (AR) - Existing email (from env)");
        RestAssured.baseURI = baseUrl;

        Response response = given()
                .config(RestAssured.config().encoderConfig(
                        encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("APIKey", API_KEY)
                .header("APISecret", API_SECRET)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Test")
                .multiPart("lastName", "User")
                .multiPart("email", existingEmailEnv)
                .multiPart("password", createPassword)
                .multiPart("confirmation", createPassword)
                .multiPart("storeId", "#")
                .post("############");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 5)
    public void validCreateNewAccount_EN() {
        log.info("Create account (EN) - Valid data (random email)");
        RestAssured.baseURI = baseUrl;

        String randomEmail = randomEmail();

        Response response = given()
                .config(RestAssured.config().encoderConfig(
                        encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .header("APIKey", API_KEY)
                .header("APISecret", API_SECRET)
                .contentType("multipart/form-data")
                .multiPart("firstName", "Test")
                .multiPart("lastName", "User")
                .multiPart("email", randomEmail)
                .multiPart("password", createPassword)
                .multiPart("confirmation", createPassword)
                .multiPart("storeId", "#")
                .post("##############");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("customerId", notNullValue())
                .body("customerEmail", equalTo(randomEmail))
                .body("customerToken", notNullValue());
    }
}


public class ApiForgetPasswordTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiForgetPasswordTest.class);

    private final String existingEmailEnv = System.getenv("#######"); // optional

    @Test(priority = 1)
    public void testForgetPassword_ValidEmail_AR() {
        if (existingEmailEnv == null || existingEmailEnv.isBlank()) {
            log.warn("Skipping: set env RANEEN_EXISTING_EMAIL to run valid forget-password test.");
            return;
        }

        log.info("Forget password (AR) - Valid email (from env)");

        Response response = withDefaultHeaders()
                .multiPart("email", existingEmailEnv)
                .multiPart("storeId", "#")
                .multiPart("websiteId", "#")
                .post("###############/");

        log.info("status={}", response.statusCode());

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 2)
    public void testForgetPassword_InvalidEmail_AR() {
        log.info("Forget password (AR) - Invalid email format");

        String invalidEmail = "invalid-email-format";

        Response response = withDefaultHeaders()
                .multiPart("email", invalidEmail)
                .multiPart("storeId", "#")
                .multiPart("websiteId", "#")
                .post("############/");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 3)
    public void testForgetPassword_EmptyEmail_AR() {
        log.info("Forget password (AR) - Empty email");

        Response response = withDefaultHeaders()
                .multiPart("email", "")
                .multiPart("storeId", "#")
                .multiPart("websiteId", "#")
                .post("################/");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }
}




public class ApiLogInTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiLogInTest.class);

    private final String email = System.getenv("#######");
    private final String password = System.getenv("########");

    private void requireCredsOrSkip() {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            throw new SkipException("Skipping: set env RANEEN_LOGIN_EMAIL and RANEEN_LOGIN_PASSWORD to run valid login test.");
        }
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        requireCredsOrSkip();
        log.info("Login - Valid credentials (from env)");

        Response response = loginCustomer(email, password);

        log.info("status={}", response.statusCode());

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("customerId", notNullValue())
                .body("customerToken", notNullValue())
                .body("cartCount", notNullValue());
    }

    @Test(priority = 2)
    public void testLoginWithInvalidPassword() {
        log.info("Login - Invalid password");
        String safeEmail = (email != null && !email.isBlank()) ? email : "user@example.com";

        Response response = loginCustomer(safeEmail, "WrongPassword123");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 3)
    public void testLoginWithInvalidEmail() {
        log.info("Login - Invalid email");
        String invalidEmail = "wrong" + System.currentTimeMillis() + "@example.com";
        String safePassword = (password != null && !password.isBlank()) ? password : "WrongPassword123";

        Response response = loginCustomer(invalidEmail, safePassword);

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }

    @Test(priority = 4)
    public void testLoginWithEmptyCredentials() {
        log.info("Login - Empty credentials");

        Response response = loginCustomer("", "");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", not(isEmptyOrNullString()));
    }
}
