# 🧪 Automated UI Testing with Selenium & TestNG

This project contains automated test cases for a web application using the Page Object Model (POM) design pattern, Selenium WebDriver, and TestNG.

---

## 📄 Test Coverage

| Page          | Test Case Description                         | Test Type   | Expected Result                                                                 | Status |
|---------------|-----------------------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| **Register**  | Successful registration                       | Positive    | User is registered and redirected to the registration success page              | ✅     |
|               | Mismatched password and confirm password      | Negative    | Error message: "The password and confirmation password do not match."           | ✅     |
|               | Invalid email format                          | Negative    | Error message: "Wrong email" or similar appears                                 | ✅     |
|               | Submit empty required fields                  | Negative    | Validation messages appear for all required fields                              | ✅     |
|               | Gender radio button is selected               | Functional  | "Male" radio button is selected and holds correct value `M`                     | ✅     |
|               | Newsletter checkbox is unchecked              | Functional  | Newsletter checkbox is successfully unchecked                                   | ✅     |

---

## 🚀 How to Run the Tests

1. Clone this repository  
2. Open it in Eclipse  
3. Run `mvn clean test` or execute tests via TestNG suite

> Test reports will be available in the `test-output` or `ExtentReports` folder.

---

## 🛠️ Tools & Technologies

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- ExtentReports
- Page Object Model (POM)

---
