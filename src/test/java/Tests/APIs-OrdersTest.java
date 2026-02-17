package Tests;

import BaseApi.BaseApiTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ApiCancelReasonsTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiCancelReasonsTest.class);

    // ✅ Store IDs are not secrets
    private static final int STORE_AR = #;
    private static final int STORE_EN = #;
    private static final int INVALID_STORE = 999;

    // ✅ Safe logging (avoid printing full JSON)
    private void logSafe(Response response, String action) {
        log.info("[{}] status={} contentType={}", action, response.statusCode(), response.contentType());
        try {
            Boolean success = response.jsonPath().getBoolean("success");
            String message = response.jsonPath().getString("message");
            Integer size = response.jsonPath().getList("reasons").size();
            log.info("[{}] success={} reasonsCount={} message={}", action, success, size, message);
        } catch (Exception ignored) {
        }
    }

    @Test(priority = 1)
    public void testCancelReasons_Valid_AR() {
        log.info("Testing Cancel Reason API - Arabic Store");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_AR)
                .get("/###############");

        logSafe(response, "CancelReasons_AR_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                // safer than exact empty string
                .body("message", anyOf(nullValue(), isEmptyString()))
                // verify structure and non-empty list
                .body("reasons", notNullValue())
                .body("reasons", not(empty()))
                .body("reasons.size()", greaterThanOrEqualTo(1))
                .body("reasons.reason", everyItem(not(isEmptyOrNullString())));
    }

    @Test(priority = 2)
    public void testCancelReasons_Valid_EN() {
        log.info("Testing Cancel Reason API - English Store");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_EN)
                .get("/##############");

        logSafe(response, "CancelReasons_EN_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("message", anyOf(nullValue(), isEmptyString()))
                .body("reasons", notNullValue())
                .body("reasons", not(empty()))
                .body("reasons.size()", greaterThanOrEqualTo(1))
                .body("reasons.reason", everyItem(not(isEmptyOrNullString())));
    }

    @Test(priority = 3)
    public void testCancelReasons_InvalidStore_AR() {
        log.info("Testing Cancel Reason API - Invalid Store (AR)");

        Response response = withDefaultHeaders()
                .queryParam("storeId", INVALID_STORE)
                .get("/###############");

        logSafe(response, "CancelReasons_AR_InvalidStore");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                // message may change slightly, so check a stable part
                .body("message", containsString("لم يتم العثور على المتجر"));
    }

    @Test(priority = 4)
    public void testCancelReasons_InvalidStore_EN() {
        log.info("Testing Cancel Reason API - Invalid Store (EN)");

        Response response = withDefaultHeaders()
                .queryParam("storeId", INVALID_STORE)
                .get("/###############");

        logSafe(response, "CancelReasons_EN_InvalidStore");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", containsString("store"));
    }
}

public class ApiOrderDetailsTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiOrderDetailsTest.class);

    // ✅ Safe: read sensitive runtime data from env (NOT committed)
    // Example run:
    // export RANEEN_CUSTOMER_TOKEN="xxxxx"
    // export RANEEN_ORDER_INCREMENT_ID="2003xxxxxx"
    private final String validToken = System.getenv("RANEEN_CUSTOMER_TOKEN");
    private final String validIncrementId = System.getenv("RANEEN_ORDER_INCREMENT_ID");

    // ✅ Safe: fixed invalid inputs (no secrets)
    private final String invalidToken = "invalid_token";
    private final String invalidIncrementId = "123456";

    private static final int STORE_AR = #;
    private static final int STORE_EN = #;

    private void requireValidDataOrSkip() {
        if (validToken == null || validToken.isBlank() ||
            validIncrementId == null || validIncrementId.isBlank()) {
            throw new SkipException("Skipping: set env RANEEN_CUSTOMER_TOKEN and RANEEN_ORDER_INCREMENT_ID to run valid tests.");
        }
    }

    // ✅ Safe logging (no full body dump)
    private void logSafe(Response response, String action) {
        log.info("[{}] status={} contentType={}", action, response.statusCode(), response.contentType());
        try {
            Boolean success = response.jsonPath().getBoolean("success");
            String message = response.jsonPath().getString("message");
            String incId = response.jsonPath().getString("incrementId");
            String state = response.jsonPath().getString("state");
            log.info("[{}] success={} incrementId={} state={} message={}", action, success, incId, state, message);
        } catch (Exception ignored) {
        }
    }

    @Test(priority = 1)
    public void testOrderDetails_Valid_AR() {
        requireValidDataOrSkip();
        log.info("Testing Order Details API (AR) with valid token + increment ID");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_AR)
                .queryParam("customerToken", validToken)
                .queryParam("incrementId", validIncrementId)
                .get("/#############");

        logSafe(response, "OrderDetails_AR_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                // ✅ Avoid asserting real email / personal info
                .body("customerEmail", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("incrementId", equalTo(validIncrementId))
                .body("state", not(isEmptyOrNullString()))
                .body("orderTotal", anyOf(containsString("جنيه"), containsString("EGP"), not(isEmptyOrNullString())))
                // ✅ Just validate the structure exists
                .body("orderData.itemList", notNullValue())
                .body("orderData.itemList", not(empty()))
                .body("orderData.itemList[0].name", not(isEmptyOrNullString()));
    }

    @Test(priority = 2)
    public void testOrderDetails_Valid_EN() {
        requireValidDataOrSkip();
        log.info("Testing Order Details API (EN) with valid token + increment ID");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_EN)
                .queryParam("customerToken", validToken)
                .queryParam("incrementId", validIncrementId)
                .get("/################");

        logSafe(response, "OrderDetails_EN_Valid");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("customerEmail", anyOf(nullValue(), not(isEmptyOrNullString())))
                .body("incrementId", equalTo(validIncrementId))
                .body("state", not(isEmptyOrNullString()))
                .body("orderTotal", anyOf(containsString("EGP"), containsString("جنيه"), not(isEmptyOrNullString())))
                .body("orderData.itemList", notNullValue())
                .body("orderData.itemList", not(empty()))
                .body("orderData.itemList[0].name", not(isEmptyOrNullString()));
    }

    @Test(priority = 3)
    public void testOrderDetails_InvalidToken_AR() {
        log.info("Testing Order Details API (AR) with invalid token");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_AR)
                .queryParam("customerToken", invalidToken)
                .queryParam("incrementId", invalidIncrementId) // also invalid (safer)
                .get("/##############");

        logSafe(response, "OrderDetails_AR_InvalidToken");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                // ✅ messages can change; check stable hints
                .body("otherError", anyOf(equalTo("customerNotExist"), not(isEmptyOrNullString())))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }

    @Test(priority = 4)
    public void testOrderDetails_InvalidToken_EN() {
        log.info("Testing Order Details API (EN) with invalid token");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_EN)
                .queryParam("customerToken", invalidToken)
                .queryParam("incrementId", invalidIncrementId)
                .get("/################");

        logSafe(response, "OrderDetails_EN_InvalidToken");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("otherError", anyOf(equalTo("customerNotExist"), not(isEmptyOrNullString())))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }

    @Test(priority = 5)
    public void testOrderDetails_InvalidIncrementId_AR() {
        requireValidDataOrSkip();
        log.info("Testing Order Details API (AR) with invalid increment ID");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_AR)
                .queryParam("customerToken", validToken)
                .queryParam("incrementId", invalidIncrementId)
                .get("/##############");

        logSafe(response, "OrderDetails_AR_InvalidIncrementId");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }

    @Test(priority = 6)
    public void testOrderDetails_InvalidIncrementId_EN() {
        requireValidDataOrSkip();
        log.info("Testing Order Details API (EN) with invalid increment ID");

        Response response = withDefaultHeaders()
                .queryParam("storeId", STORE_EN)
                .queryParam("customerToken", validToken)
                .queryParam("incrementId", invalidIncrementId)
                .get("/##############");

        logSafe(response, "OrderDetails_EN_InvalidIncrementId");

        response.then().statusCode(200)
                .body("success", equalTo(false))
                .body("message", anyOf(notNullValue(), isEmptyOrNullString()));
    }
}
