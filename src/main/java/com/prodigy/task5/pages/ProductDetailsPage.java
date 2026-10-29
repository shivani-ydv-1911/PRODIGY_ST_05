package com.prodigy.task5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for Shoplane Product Details Page
 */
public class ProductDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By productContainer = By.id("containerProduct");
    private final By productImage = By.id("imgDetails");
    private final By addToCartButton = By.cssSelector("#button button");
    private final By cartBadge = By.id("badge");
    private final By cartLink = By.cssSelector(".addedToCart");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productContainer)).isDisplayed();
    }

    public void clickAddToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        // Use scroll and JS click to guarantee interaction across responsive layouts
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);
        // Wait for badge text to update
        wait.until(ExpectedConditions.textToBePresentInElementLocated(cartBadge, "1"));
    }

    public String getCartBadgeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText().trim();
    }

    public void goToCart() {
        try {
            WebElement cart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user a[href*='cart'], a[href*='cart']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);
            wait.until(ExpectedConditions.urlContains("cart"));
        } catch (Exception e) {
            driver.get("https://shoplane-by-lassie.netlify.app/cart.html");
        }
    }
}
