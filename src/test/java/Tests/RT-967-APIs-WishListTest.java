package Tests;

import BaseApi.BaseApiTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ApiWishlistTest extends BaseApiTest {
    private static final Logger log = LoggerFactory.getLogger(ApiWishlistTest.class);

    // ✅ Keep these as constants; they are not secrets
    private final int storeIdAR = #;
    private final int storeIdEN = #;

    // ✅ This can be kept if it's not sensitive (otherwise move to ENV too)
    private final int productId = ######;

    // IDs captured from responses
    private int itemIdAR;
    private int itemIdEN;
    private int secItemIdAR;
    private int secItemIdEN;
    private String cartItemIdAR;
    private String cartItemIdEN;

    private String customerToken;

    @BeforeClass
    public void init() {
        customerToken = System.getenv("CUSTOMER_TOKEN");
        if (customerToken == null || customerToken.isBlank()) {
            throw new SkipException("CUSTOMER_TOKEN is not set. Skipping authenticated wishlist tests.");
        }
    }

    // --------------------
    // Helpers (safe logging)
    // --------------------
    private void logSafe(Response response, String action) {
        // ✅ avoid prettyPrint() - can leak tokens/emails/internal data
        log.info("[{}] status={} contentType={}", action, response.statusCode(), response.contentType());
        try {
            JsonPath json = response.jsonPath();
            Boolean success = json.getBoolean("success");
            String message = json.getString("message");
            log.info("[{}] success={} message={}", action, success, message);
        } catch (Exception ignored) {
        }
    }

    // =========================
    // AR Store Flow
    // =========================

    @Test(priority = 1)
    public void add_To_Wishlist_AR() {
        log.info("Adding product to wishlist (AR) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdAR)
                .formParam("productId", productId)
                .formParam("customerToken", customerToken)
                .post("##########");

        logSafe(response, "add_To_Wishlist_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("message", containsString("تمت إضافة المنتج إلى قائمة الرغبات"));

        itemIdAR = response.jsonPath().getInt("itemId");
        log.info("Captured itemIdAR={}", itemIdAR);
    }

    @Test(priority = 2)
    public void get_Wishlist_AR() {
        log.info("Getting wishlist items (AR) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdAR)
                .formParam("customerToken", customerToken)
                .get("/########");

        logSafe(response, "get_Wishlist_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("wishList", not(empty()));
    }

    @Test(priority = 3)
    public void wishList_To_Cart_AR() {
        log.info("Moving wishlist item to cart (AR) ...");

        Response response = withDefaultHeaders()
                .formParam("itemId", itemIdAR)
                .formParam("storeId", storeIdAR)        // ✅ FIX: storeId only once
                .formParam("customerToken", customerToken)
                .post("/###########");

        logSafe(response, "wishList_To_Cart_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 4)
    public void cart_Details_AR() {
        log.info("Getting cart details (AR) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdAR)
                .formParam("customerToken", customerToken)
                .get("/#########");

        logSafe(response, "cart_Details_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("items", not(empty()));

        cartItemIdAR = response.jsonPath().getString("items[0].id");
        log.info("Captured cartItemIdAR={}", cartItemIdAR);
    }

    @Test(priority = 5)
    public void wishList_From_Cart_AR() {
        log.info("Moving cart item to wishlist (AR) ...");

        Response response = withDefaultHeaders()
                .formParam("itemId", cartItemIdAR)
                .formParam("storeId", storeIdAR)
                .formParam("customerToken", customerToken)
                .post("/##############");

        logSafe(response, "wishList_From_Cart_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 6)
    public void remove_From_WishList_AR() {
        log.info("Refreshing wishlist to get latest item ID before removal (AR) ...");

        Response wishlistResponse = withDefaultHeaders()
                .formParam("storeId", storeIdAR)
                .formParam("customerToken", customerToken)
                .get("/############");

        logSafe(wishlistResponse, "wishlist_refresh_AR");

        wishlistResponse.then().statusCode(200)
                .body("success", equalTo(true))
                .body("wishList", not(empty()));

        secItemIdAR = wishlistResponse.jsonPath().getInt("wishList[0].wishlistItemId");
        log.info("Removing wishlistItemIdAR={}", secItemIdAR);

        Response response = withDefaultHeaders()
                .queryParam("storeId", storeIdAR)
                .queryParam("itemId", secItemIdAR)
                .queryParam("customerToken", customerToken)
                .delete("/###############");

        logSafe(response, "remove_From_WishList_AR");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }

    // =========================
    // EN Store Flow
    // =========================

    @Test(priority = 7)
    public void add_To_Wishlist_EN() {
        log.info("Adding product to wishlist (EN) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdEN)
                .formParam("productId", productId)
                .formParam("customerToken", customerToken)
                .post("/##############");

        logSafe(response, "add_To_Wishlist_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true));

        itemIdEN = response.jsonPath().getInt("itemId");
        log.info("Captured itemIdEN={}", itemIdEN);
    }

    @Test(priority = 8)
    public void get_Wishlist_EN() {
        log.info("Getting wishlist items (EN) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdEN)
                .formParam("customerToken", customerToken)
                .get("/################");

        logSafe(response, "get_Wishlist_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("wishList", not(empty()));
    }

    @Test(priority = 9)
    public void wishList_To_Cart_EN() {
        log.info("Moving wishlist item to cart (EN) ...");

        Response response = withDefaultHeaders()
                .formParam("itemId", itemIdEN)
                .formParam("storeId", storeIdEN)        // ✅ FIX: storeId only once
                .formParam("customerToken", customerToken)
                .post("/#################");

        logSafe(response, "wishList_To_Cart_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 10)
    public void cart_Details_EN() {
        log.info("Getting cart details (EN) ...");

        Response response = withDefaultHeaders()
                .formParam("storeId", storeIdEN)
                .formParam("customerToken", customerToken)
                .get("/###############");

        logSafe(response, "cart_Details_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true))
                .body("items", not(empty()));

        cartItemIdEN = response.jsonPath().getString("items[0].id");
        log.info("Captured cartItemIdEN={}", cartItemIdEN);
    }

    @Test(priority = 11)
    public void wishList_From_Cart_EN() {
        log.info("Moving cart item to wishlist (EN) ...");

        Response response = withDefaultHeaders()
                .formParam("itemId", cartItemIdEN)
                .formParam("storeId", storeIdEN)
                .formParam("customerToken", customerToken)
                .post("/################");

        logSafe(response, "wishList_From_Cart_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 12)
    public void remove_From_WishList_EN() {
        log.info("Refreshing wishlist to get latest item ID before removal (EN) ...");

        Response wishlistResponse = withDefaultHeaders()
                .formParam("storeId", storeIdEN)
                .formParam("customerToken", customerToken)
                .get("/#############");

        logSafe(wishlistResponse, "wishlist_refresh_EN");

        wishlistResponse.then().statusCode(200)
                .body("success", equalTo(true))
                .body("wishList", not(empty()));

        secItemIdEN = wishlistResponse.jsonPath().getInt("wishList[0].wishlistItemId");
        log.info("Removing wishlistItemIdEN={}", secItemIdEN);

        Response response = withDefaultHeaders()
                .queryParam("storeId", storeIdEN)
                .queryParam("itemId", secItemIdEN)
                .queryParam("customerToken", customerToken)
                .delete("/###############");

        logSafe(response, "remove_From_WishList_EN");

        response.then().statusCode(200)
                .body("success", equalTo(true));
    }
}
