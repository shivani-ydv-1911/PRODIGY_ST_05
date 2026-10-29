# 🛒 PRODIGY_ST_05: Automated UI Tests for E-Commerce Checkout Flow

[![Java 17](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://www.oracle.com/java/)
[![Selenium WebDriver](https://img.shields.io/badge/Selenium-4.27.0-green?logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-red)](https://testng.org/)
[![Target Site](https://img.shields.io/badge/Target-Shoplane%20E--Commerce-orange)](https://shoplane-by-lassie.netlify.app/)
[![Tests](https://img.shields.io/badge/Tests-5%2F5%20Passed-brightgreen)](#-test-results-summary)
[![Internship Track](https://img.shields.io/badge/Prodigy%20InfoTech-Software%20Testing-blue)](https://prodigyinfotech.dev/)

This repository contains the completed **Task-05** for the **Software Testing Internship** at **Prodigy InfoTech**.

---

## 📌 Task Overview

- **Task ID:** Task-05
- **Title:** Automated UI Tests for an E-Commerce Checkout Flow
- **Target Application:** [Shoplane E-Commerce](https://shoplane-by-lassie.netlify.app/)
- **Core Technology:** **Java 17, Selenium WebDriver 4.27, TestNG 7.10, Maven**
- **Architecture:** **Page Object Model (POM)**
- **Objective:** Automate the end-to-end checkout process on an e-commerce platform, including product selection, adding items to cart, navigating through the cart/checkout page, placing the order, and verifying the purchase success message.

---

## 🏗️ Architecture: Page Object Model (POM)

```
PRODIGY_ST_05/
├── pom.xml                                           # Maven dependencies & test runner plugins
├── src/
│   ├── main/java/com/prodigy/task5/pages/
│   │   ├── HomePage.java                             # POM: Catalog loading & product selection
│   │   ├── ProductDetailsPage.java                   # POM: PDP details & Add to Cart action
│   │   ├── CartCheckoutPage.java                     # POM: Cart review & Place Order execution
│   │   └── OrderConfirmationPage.java                # POM: Confirmation page & success message assertion
│   └── test/
│       ├── java/com/prodigy/task5/tests/
│       │   └── EcommerceCheckoutTest.java            # 5 Automated TestNG Test Scenarios
│       └── resources/
│           └── testng-task5.xml                      # TestNG Suite Runner XML
├── run_task5.bat                                     # 1-Click execution script for Windows
├── CHECKOUT_FLOW_REPORT.md                           # Detailed report on page transitions & issues
├── INSTRUCTIONS_TASK5.md                             # Step-by-step intern guide
└── README.md                                         # Project documentation
```

---

## 🧪 Automated Test Scenarios

| Test ID | Scenario | Verification Focus | Status |
| :--- | :--- | :--- | :---: |
| **TC-01** | Home Page Catalog Loading | Validates header branding, dynamic product list rendering |  **Passed** |
| **TC-02** | Product Details & Add to Cart | Verifies PDP transition, dynamic cart badge count increment |  **Passed** |
| **TC-03** | Cart Checkout Page Navigation | Verifies cart container visibility and total item summary |  **Passed** |
| **TC-04** | **Full End-to-End Checkout Flow** | Complete flow: Catalog ➔ PDP ➔ Cart ➔ Place Order ➔ Success Confirmation ("Order Placed Successfully!") |  **Passed** |
| **TC-05** | Empty Cart State Verification | Verifies graceful loading and 0-item display on empty cart |  **Passed** |

---

## 🚀 Quick Start Guide

### Prerequisites
- **Java JDK 17+** (`java -version`)
- **Google Chrome** browser installed

### 1. Run Tests (One-Click)
Windows par project folder me `run_task5.bat` par double-click karein, ya terminal me run karein:
```bash
mvn clean test
```

### 2. View TestNG HTML Report
Test execution ke baad HTML report yahan generate hoti hai:
```text
target/surefire-reports/index.html
```

---

## 📑 Technical Issues & Automation Report

Detailed documentation of technical challenges solved (AJAX dynamic rendering, Netlify lowercase URL stripping, nested anchor navigation):  
👉 **[CHECKOUT_FLOW_REPORT.md](CHECKOUT_FLOW_REPORT.md)**

---

## 📊 Test Results Summary

```text
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite

  ✓ TC-01: Verify home page loads and product catalog renders
  ✓ TC-02: Verify product detail page transition and Add to Cart action
  ✓ TC-03: Verify cart checkout page navigation and item summary
  ✓ TC-04: Full End-to-End E-Commerce Checkout Flow and Order Success Verification
  ✓ TC-05: Empty cart state verification

Results:
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
Time elapsed: 29.61 s
[INFO] BUILD SUCCESS
```

---

## 📄 License
This project is open-source under the MIT License. Created as part of the Prodigy InfoTech Software Testing Internship.
