# 🧪 Automated UI Testing with Selenium & TestNG

This project contains automated test cases for a web application using the Page Object Model (POM) design pattern, Selenium WebDriver, and TestNG.

---

## 📄 Test Coverage

### ✅ Register Page

| Test Case Description                         | Test Type   | Expected Result                                                                 | Status |
|-----------------------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| Successful registration                       | Positive    | User is registered and redirected to the registration success page              | ✅     |
| Mismatched password and confirm password      | Negative    | Error message: "The password and confirmation password do not match."           | ✅     |
| Invalid email format                          | Negative    | Error message: "Wrong email" or similar appears                                 | ✅     |
| Submit empty required fields                  | Negative    | Validation messages appear for all required fields                              | ✅     |
| Gender radio button is selected               | Functional  | "Male" radio button is selected and holds correct value `M`                     | ✅     |
| Newsletter checkbox is unchecked              | Functional  | Newsletter checkbox is successfully unchecked                                   | ✅     |

---

### ✅ Login Page

| Test Case Description                         | Test Type   | Expected Result                                                                 | Status |
|-----------------------------------------------|-------------|---------------------------------------------------------------------------------|--------|
| Successful login                              | Positive    | User is logged in and redirected to dashboard or home page                      | ✅     |
| Invalid email                                 | Negative    | Error message is displayed indicating invalid credentials                       | ✅     |
| Wrong password                                | Negative    | Error message is displayed indicating invalid credentials                       | ✅     |
| Empty email field                             | Negative    | Error or validation message prompts user to enter an email                      | ✅     |
| Empty password field                          | Negative    | Error or validation message prompts user to enter a password                    | ✅     |
| "Remember Me" checkbox is clickable           | Functional  | Checkbox toggles correctly and state is retained upon submission                | ✅     |
| Show password button                          | Functional  | Password input becomes visible upon clicking the show/hide button               | ✅     |

---

## 🚀 How to Run the Tests

1. Clone or download this repository  
2. Open the project in **Eclipse**  
3. Navigate to any test class (e.g., `RegisterTest.java` or `LoginTest.java`)  
4. **Right-click** on the file → **Run As** → **TestNG Test**  
5. To view the test report:
   - Go to the `reports` folder  
   - **Right-click** the HTML file → **Open With** → **Web Browser** or **System Editor**

> Test reports are automatically generated in the `reports` folder after test execution.

---

## 🛠️ Tools & Technologies

- Java 17  
- Selenium WebDriver  
- TestNG  
- Maven  
- ExtentReports  
- Page Object Model (POM)

---
