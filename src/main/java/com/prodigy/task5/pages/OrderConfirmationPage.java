package com.prodigy.task5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for Shoplane Order Confirmation Page
 */
public class OrderConfirmationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By orderSuccessHeading = By.cssSelector("#aboutCheck h1");
    private final By orderSuccessSubtext = By.cssSelector("#aboutCheck p");
    private final By checkCircleIcon = By.cssSelector("#check i.fa-check-circle");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLoaded() {
        return wait.until(d -> d.getCurrentUrl().toLowerCase().contains("orderplaced"));
    }

    public String getSuccessHeading() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessHeading));
        return heading.getText().trim();
    }

    public String getSuccessSubtext() {
        WebElement subtext = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessSubtext));
        return subtext.getText().trim();
    }

    public boolean isOrderContainerDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderContainer"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
