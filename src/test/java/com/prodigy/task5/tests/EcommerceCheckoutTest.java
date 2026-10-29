package com.prodigy.task5.tests;

import com.prodigy.task5.pages.CartCheckoutPage;
import com.prodigy.task5.pages.HomePage;
import com.prodigy.task5.pages.OrderConfirmationPage;
import com.prodigy.task5.pages.ProductDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Task-05: Automated UI Tests for E-Commerce Checkout Flow (Shoplane)
 */
public class EcommerceCheckoutTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductDetailsPage productPage;
    private CartCheckoutPage cartPage;
    private OrderConfirmationPage confirmationPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        productPage = new ProductDetailsPage(driver);
        cartPage = new CartCheckoutPage(driver);
        confirmationPage = new OrderConfirmationPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, description = "TC-01: Verify home page loads and product catalog renders")
    public void testHomePageCatalogLoading() {
        homePage.navigate();
        Assert.assertTrue(homePage.isPageLoaded(), "Shoplane home page header should be visible");
        Assert.assertTrue(driver.getTitle().contains("E-COMMERCE"), "Page title should confirm E-Commerce website");
    }

    @Test(priority = 2, description = "TC-02: Verify product detail page transition and Add to Cart action")
    public void testProductDetailsAndAddToCart() {
        homePage.navigate();
        homePage.selectFirstProduct();

        Assert.assertTrue(productPage.isLoaded(), "Product details page should load successfully");
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("contentdetails"), "URL should contain contentdetails");

        // Add to cart
        productPage.clickAddToCart();
        String badgeCount = productPage.getCartBadgeText();
        Assert.assertEquals(badgeCount, "1", "Cart badge should increment to 1 after adding product");
    }

    @Test(priority = 3, description = "TC-03: Verify cart checkout page navigation and item summary")
    public void testCartCheckoutPageNavigation() {
        homePage.navigate();
        homePage.selectFirstProduct();
        productPage.clickAddToCart();
        productPage.goToCart();

        Assert.assertTrue(cartPage.isLoaded(), "Cart checkout page should display Checkout header");
        Assert.assertTrue(cartPage.isCartContentDisplayed(), "Cart items container should be visible");
    }

    @Test(priority = 4, description = "TC-04: Full End-to-End E-Commerce Checkout Flow and Order Success Verification")
    public void testFullEndToEndCheckoutFlow() {
        // Step 1: Open Home Page
        homePage.navigate();
        Assert.assertTrue(homePage.isPageLoaded(), "Home page should be accessible");

        // Step 2: Select a Product
        homePage.selectFirstProduct();
        Assert.assertTrue(productPage.isLoaded(), "Product details should be displayed");

        // Step 3: Add Item to Cart
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.getCartBadgeText(), "1", "Cart badge should reflect 1 item");

        // Step 4: Proceed to Cart / Checkout Page
        productPage.goToCart();
        Assert.assertTrue(cartPage.isLoaded(), "Checkout page should open");

        // Step 5: Place the Order
        cartPage.clickPlaceOrder();

        // Step 6: Verify Order Confirmation
        Assert.assertTrue(confirmationPage.isLoaded(), "Should navigate to orderPlaced.html");
        Assert.assertEquals(confirmationPage.getSuccessHeading(), "Order Placed Successfully!", 
                "Success message heading must match expected");
        Assert.assertTrue(confirmationPage.getSuccessSubtext().contains("Order details"), 
                "Email confirmation subtext must be displayed");
        Assert.assertTrue(confirmationPage.isOrderContainerDisplayed(), 
                "Order success container should be visible");
    }

    @Test(priority = 5, description = "TC-05: Empty cart state verification")
    public void testEmptyCartState() {
        driver.get("https://shoplane-by-lassie.netlify.app/cart.html");
        Assert.assertTrue(cartPage.isLoaded(), "Cart page should load even when empty");
        Assert.assertTrue(cartPage.getTotalItemsText().contains("0"), "Total items should display 0 for empty cart");
    }
}
