# 📋 Task 05 - Complete Guide & Step-by-Step Instructions

> **Yeh file special aapki friend ke liye banayi gayi hai**, taaki unhe Task-05 (E-Commerce Checkout Flow Automation), execution steps, issue reports aur submission process aasaani se samajh aa sake! 🎯

---

## 📌 Table of Contents (Index)
1. [Task-05 Overview & Requirements](#1-task-05-overview--requirements)
2. [Prodigy InfoTech Guidelines for Task-05](#2-prodigy-infotech-guidelines-for-task-05)
3. [Architecture & Frameworks Used](#3-architecture--frameworks-used)
4. [Detailed Test Cases Matrix](#4-detailed-test-cases-matrix)
5. [How to Run the Tests (Step-by-Step)](#5-how-to-run-the-tests-step-by-step)
6. [Issues Encountered During Automation (Report Summary)](#6-issues-encountered-during-automation-report-summary)
7. [GitHub Repository Setup & Push Guide (`PRODIGY_ST_05`)](#7-github-repository-setup--push-guide)
8. [LinkedIn Post Template (Mandatory Step)](#8-linkedin-post-template-mandatory-step)
9. [Submission Checklist](#9-submission-checklist)

---

## 1. Task-05 Overview & Requirements

- **Task Name:** Automated UI Tests for an E-Commerce Checkout Flow
- **Target Application:** [Shoplane E-Commerce](https://shoplane-by-lassie.netlify.app/)
- **Core Technology:** **Java 17, Selenium WebDriver 4.27, TestNG 7.10, Maven**
- **Mandatory Requirements:**
  1. Product ko cart me add karna automate karna.
  2. Cart review aur checkout summary verify karna.
  3. "Place Order" button click karke confirmation page par order success message ("Order Placed Successfully!") assert karna.
  4. Har page transition aur dynamic validation verify karna.
  5. Automation ke time jo technical issues ya challenges aaye unhe document karna (`CHECKOUT_FLOW_REPORT.md`).

---

## 2. Prodigy InfoTech Guidelines for Task-05

| Rule | Details |
| :--- | :--- |
| **GitHub Repo Name** | Format compulsory hai: `PRODIGY_TrackCode_TaskNumber`<br>👉 Task 5 ke liye: **`PRODIGY_ST_05`** |
| **Public Visibility** | Repository **Public** honi chahiye. |
| **LinkedIn Post** | Task complete hone ke baad LinkedIn par share karna **MANDATORY** hai. |
| **Documentation** | Automation output aur encountered issues document karna zaroori hai (`CHECKOUT_FLOW_REPORT.md`). |

---

## 3. Architecture & Frameworks Used

Project standard **Page Object Model (POM)** pattern par structured hai:

```
task_05_ecommerce_checkout/
├── pom.xml                                           # Maven dependencies (Selenium, TestNG, WebDriverManager)
├── src/
│   ├── main/java/com/prodigy/task5/pages/
│   │   ├── HomePage.java                             # POM: Homepage & catalog discovery
│   │   ├── ProductDetailsPage.java                   # POM: Product details & Add to Cart
│   │   ├── CartCheckoutPage.java                     # POM: Cart items review & Place Order
│   │   └── OrderConfirmationPage.java                # POM: Success message & confirmation validation
│   └── test/
│       ├── java/com/prodigy/task5/tests/
│       │   └── EcommerceCheckoutTest.java            # 5 Automated TestNG Test Cases
│       └── resources/
│           └── testng-task5.xml                      # TestNG Suite Runner XML
├── run_task5.bat                                     # 1-Click execution script for Windows
├── CHECKOUT_FLOW_REPORT.md                           # Technical report on issues & transitions
├── INSTRUCTIONS_TASK5.md                             # Complete Hindi + English guide
└── README.md                                         # GitHub repository documentation
```

---

## 4. Detailed Test Cases Matrix

Total **5 Comprehensive Automated Tests** include kiye gaye hain:

| Test ID | Test Scenario | Steps Executed | Expected Outcome |
| :--- | :--- | :--- | :--- |
| **TC-01** | Homepage Catalog Loading | Opens home page, verifies header logo and catalog | Header `#shopName` visible, title contains "E-COMMERCE" |
| **TC-02** | Product Details & Add to Cart | Clicks first product card, verifies PDP loads, clicks 'Add to Cart' | URL contains `contentdetails`, cart badge increments to `1` |
| **TC-03** | Cart Checkout Transition | Adds item, navigates to `/cart`, verifies summary | Checkout header visible, cart items container displayed |
| **TC-04** | **Full End-to-End Checkout Flow** | Home -> Select Product -> Add to Cart -> Open Cart -> Click Place Order -> Verify Success | Navigates to `orderplaced`, verifies heading *"Order Placed Successfully!"* and email confirmation |
| **TC-05** | Empty Cart Validation | Navigates directly to `/cart.html` without items | Cart loads cleanly, Total items counter displays `0` |

---

## 5. How to Run the Tests (Step-by-Step)

### Option 1: 1-Click Batch Runner (Windows)
1. Project folder me jayein: `task_05_ecommerce_checkout`
2. **`run_task5.bat`** file par double click karein.
3. Terminal me tests run honge aur finish hone par result dikhayenge.

### Option 2: Command Line (VS Code Terminal)
VS Code terminal me run karein:
```bash
..\mvn.cmd clean test
```
Ya direct:
```bash
mvn clean test
```

### Report Dekhne Ke Liye:
Execution ke baad TestNG ka HTML dashboard yahan generate hota hai:
```text
task_05_ecommerce_checkout/target/surefire-reports/index.html
```
Is file ko browser me open karke visual report dekh sakte hain.

---

## 6. Issues Encountered During Automation (Report Summary)

Task requirement ke mutabiq jo 4 technical issues resolve kiye gaye:
1. **Dynamic AJAX DOM Rendering:** Products dynamic JavaScript se load hote hain, jise Explicit Waits se solve kiya gaya.
2. **Netlify URL Rewriting:** Netlify URL ko lowercase me convert karta hai (`/contentdetails?1`), jise case-insensitive URL checks se handle kiya gaya.
3. **Button me Nested Anchor Tag:** Place Order button ke andar `<a>` tag ko direct trigger kiya gaya taaki navigation fail na ho.
4. **FontAwesome Icon Async CDN:** Icon ki jagah confirmation container aur success text ko assert kiya gaya jo 100% reliable hai.

---

## 7. GitHub Repository Setup & Push Guide (`PRODIGY_ST_05`)

Task 5 ke liye new public repository banani hai:

1. [GitHub](https://github.com/) par login karein aur **New Repository** banayein.
2. Repository Name: **`PRODIGY_ST_05`**
3. Visibility: **Public**
4. `task_05_ecommerce_checkout` folder ke andar terminal kholein aur run karein:

```bash
git init
git add .
git commit -m "feat: completed task 5 e-commerce checkout flow automation in Java Selenium TestNG"
git branch -M main
git remote add origin https://github.com/shivani-ydv-1911/PRODIGY_ST_05.git
git push -u origin main
```
*(Note: Agar aapka GitHub username alag hai toh use replace kar sakti hain).*

---

## 8. LinkedIn Post Template (Mandatory Step)

Direct yeh template copy-paste kar sakti hain:

```markdown
🚀 Thrilled to share that I have completed Task-05 of my Software Testing Internship at Prodigy InfoTech!

📌 Task Title: Automated UI Tests for an E-Commerce Checkout Flow
🌐 Target Website: Shoplane (https://shoplane-by-lassie.netlify.app/)
🛠️ Tech Stack: Java 17, Selenium WebDriver 4.27, TestNG 7.10, Maven, Page Object Model (POM)

Key Highlights of this Project:
✅ Designed a robust end-to-end automation test suite using the Page Object Model (POM) pattern for high maintainability.
✅ Automated the complete purchasing journey:
   - Dynamic product catalog loading and category selection
   - Product detail page (PDP) transitions and dynamic cart badge counter updates
   - Cart review and checkout total calculations
   - Order placement and purchase confirmation validation ("Order Placed Successfully!")
✅ Handled dynamic AJAX content rendering, asynchronous CDN resources, and Netlify client-side routing.
✅ Documented page transitions, validation states, and automation engineering challenges in a comprehensive checkout report.

📂 GitHub Repository: https://github.com/shivani-ydv-1911/PRODIGY_ST_05

A heartfelt thanks to Prodigy InfoTech for this wonderful opportunity to master automated UI testing and e-commerce QA engineering!

#ProdigyInfoTech #SoftwareTesting #AutomationTesting #Selenium #Java #TestNG #QualityAssurance #ECommerceTesting #Internship #QAEngineering
```

---

## 9. Submission Checklist

- [x] Repository ka naam exact **`PRODIGY_ST_05`** hai.
- [x] Repository Public hai.
- [x] `README.md` aur `CHECKOUT_FLOW_REPORT.md` files maujood hain.
- [x] Saare 5 test cases successfully pass ho rahe hain (5/5).
- [x] LinkedIn post live hai aur link copy kar liya hai.

---
**Task-05 complete! Ab Task-03, Task-04 aur Task-05 teeno fully ready hain! 🚀**
