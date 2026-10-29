package com.prodigy.task5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model for Shoplane E-Commerce Home Page
 */
public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public static final String HOME_URL = "https://shoplane-by-lassie.netlify.app/";

    // Locators
    private final By shopLogo = By.id("shopName");
    private final By clothingSection = By.id("containerClothing");
    private final By accessoriesSection = By.id("containerAccessories");
    private final By productLinks = By.cssSelector("#mainContainer a[href*='contentDetails.html']");
    private final By cartIcon = By.cssSelector(".addedToCart");
    private final By cartBadge = By.id("badge");
    private final By searchInput = By.id("input");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigate() {
        driver.get(HOME_URL);
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shopLogo)).isDisplayed();
    }

    public void selectFirstProduct() {
        // Wait for product cards to load dynamically via content.js
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLinks));
        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
            wait.until(ExpectedConditions.urlContains("contentdetails"));
        } else {
            throw new RuntimeException("No products found on Shoplane home page");
        }
    }

    public void selectProductByIndex(int index) {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLinks));
        if (index < products.size()) {
            WebElement prod = products.get(index);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prod);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", prod);
            wait.until(ExpectedConditions.urlContains("contentdetails"));
        } else {
            throw new IndexOutOfBoundsException("Product index " + index + " out of bounds");
        }
    }

    public void clickCartIcon() {
        try {
            WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user a[href*='cart'], a[href*='cart']")));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);
            wait.until(ExpectedConditions.urlContains("cart"));
        } catch (Exception e) {
            driver.get("https://shoplane-by-lassie.netlify.app/cart.html");
        }
    }

    public String getCartBadgeCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText().trim();
        } catch (Exception e) {
            return "0";
        }
    }

    public void searchProduct(String query) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchBox.clear();
        searchBox.sendKeys(query);
    }
}
