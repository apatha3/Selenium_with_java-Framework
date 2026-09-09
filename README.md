# Selenium with Java Framework

A simple Selenium WebDriver automation framework using Java, Maven, TestNG, and the Page Object Model.

The tests run against DUMMY E-COMMERECE site:


## What Is Included

- Selenium WebDriver 4.30.0 for browser automation
- TestNG 7.11.0 for test execution
- Maven for building and running the project
- WebDriverManager for ChromeDriver setup
- Page Objects for login, products, cart, and payment pages
- Reusable waits and browser utilities
- JSON-based login test data
- Critical tests for invalid login, password recovery, registration validation, and orders
- Optional MCP configuration in `.vscode/mcp.json` for Copilot Agent workflows

## Project Layout

```text
pom.xml                         Dependencies and Maven commands
testng.xml                      TestNG suite
src/main/java/                  Page Objects and reusable components
src/main/java/Resources/        Test data and properties
src/test/java/tests/            Test classes and base test setup
.vscode/mcp.json                Optional MCP server configuration
```

## Quick Start

### 1. Install prerequisites

Install:

- Java 17 or newer
- Maven 3.9 or newer
- Google Chrome
- Git
- Internet access for Maven and ChromeDriver downloads

Check Java and Maven:

```bash
java -version
mvn -version
```

### 2. Clone the project

```bash
git clone https://github.com/apatha3/Selenium_with_java-Framework.git
cd Selenium_with_java-Framework
```

### 3. Configure test credentials

The login data is stored in:

```text
src/main/java/Resources/JsonD.json
```

Use test-only credentials that work on the practice website. Do not commit real passwords. Keep private credentials in a local ignored file when possible.

### 4. Run the framework

From the project root, run:

```bash
mvn clean test
```

This command compiles the project and runs the classes listed in `testng.xml`.

Test reports are created in:

```text
target/surefire-reports/
```

## Run One Test

To run the critical test class:

```bash
mvn -Dtest=Criticaltest test
```

You can also open a test class in VS Code and run an individual TestNG method if the TestNG extension is installed.

## How the Framework Works

1. `baseTest` opens Chrome before each test and closes it afterward.
2. Test classes describe the business scenario.
3. Page Object classes contain locators and browser actions.
4. `Reuseablecode` provides waits and JSON data loading.
5. TestNG runs the suite and Maven creates the reports.

To add a new test, create or update a Page Object first, add a TestNG method under `src/test/java/tests/test/`, and list the class in `testng.xml`.

## Use Copilot Agent with MCP

The optional MCP configuration is in `.vscode/mcp.json`. It contains these servers:

- `selenium` for Selenium browser workflows
- `playwright` for general browser inspection
- `mysql` for optional local MySQL access
- `excel` for optional workbook operations

For browser and Excel servers, install Node.js 18 or newer. For the MySQL server, install `uv` and have a local MySQL database if database access is needed. The first use downloads the MCP packages through `npx` or `uvx`.

Before starting VS Code, configure these MySQL environment variables only if you use the MySQL server:

```text
MYSQL_HOST
MYSQL_PORT
MYSQL_USER
MYSQL_PASSWORD
MYSQL_DATABASE
```

Open the cloned project in VS Code, open Copilot Chat, choose **Agent**, and ask for a specific Selenium task. For example:

```text
Add a TestNG test for searching a product. Follow the existing Page Object
Model, run the focused Maven test, and fix any compilation or locator errors.
```

The agent can inspect the project, update page objects and tests, run Maven, read test reports, and explain or fix failures. It cannot invent valid application credentials, and browser tests still require Chrome and network access.

## Common Problems

**`mvn` is not recognized**

Install Maven and add its `bin` directory to `PATH`, then restart the terminal.

**Login test fails**

Check that the credentials in `src/main/java/Resources/JsonD.json` are valid for the practice site.

**ChromeDriver does not start**

Confirm Chrome is installed and allow WebDriverManager to download a compatible driver.

**Tests are not discovered**

Run commands from the project root and confirm the class name and package in `testng.xml` match the Java files exactly.

## Useful Commands

```bash
mvn clean test                 # Build and run the full suite
mvn -DskipTests test-compile   # Compile without running browser tests
mvn -Dtest=Criticaltest test   # Run one test class
mvn clean test -e              # Show detailed Maven errors
```
