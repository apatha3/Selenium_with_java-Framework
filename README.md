# Selenium with Java Framework

A Selenium WebDriver automation framework written in Java. The project uses Maven for dependency management and TestNG for test execution. It follows the Page Object Model so browser actions and page locators are separated from the test cases.

## Technology Stack

- Java 17 or newer
- Maven 3.9 or newer
- Selenium WebDriver 4.30.0
- TestNG 7.11.0
- Chrome browser
- WebDriverManager 5.9.3
- Jackson Databind for JSON test data

## AI Agent Capabilities

The AI coding agent in VS Code can help maintain and extend this Selenium framework. It can:

- Analyze the Maven project, package structure, page objects, TestNG suite, and existing tests.
- Diagnose compilation errors, broken imports, package mismatches, merge-conflict markers, and test-discovery problems.
- Add Selenium WebDriver and TestNG tests using the existing Page Object Model.
- Update page objects, locators, waits, test data handling, and reusable Selenium utilities.
- Run Maven compilation and TestNG tests, inspect Surefire reports, and explain failures in plain language.
- Review the target website behavior and use the observed UI to propose or automate critical test scenarios.
- Create supporting documentation, test-case workbooks, failure summaries, and troubleshooting steps.

### How the AI Agent Is Built

The AI agent is provided by GitHub Copilot in VS Code; it is not compiled into this Selenium project. Its work is based on four parts:

1. **Repository context**: It reads Java packages, page objects, TestNG configuration, Maven dependencies, README guidance, and relevant test reports.
2. **Reasoning and planning**: It identifies the class or test flow that controls the requested behavior and proposes the smallest compatible change.
3. **Development tools**: It edits source files, navigates Java symbols, runs Maven, and uses Selenium/TestNG for browser automation.
4. **Feedback loop**: It reviews compiler output, TestNG failures, and Surefire reports, then makes targeted fixes and reruns validation.

The agent follows the project’s existing Page Object Model. Test classes describe scenarios, page-object classes hold locators and browser actions, reusable components provide waits and shared utilities, and Maven/TestNG provide execution and reporting.

### How to Use the AI Agent

Open this repository in VS Code with GitHub Copilot enabled, then give the agent a specific task. For example:

```text
Analyze the existing Selenium tests and add a test for invalid login.
Use the current page objects, run the focused TestNG test, and fix any failure.
```

```text
Review all import errors in the framework, fix the package mismatches, and run
`mvn -DskipTests test-compile` to verify the project.
```

```text
Run the full TestNG suite, summarize failures from `target/surefire-reports`,
and update the README with the root cause.
```

For best results, include the target class or behavior, expected result, test data, and the command or test method to validate. The agent should inspect the existing code before editing and keep changes consistent with the current Selenium, TestNG, and Page Object patterns.

### Important Limits

- The agent cannot safely invent valid application credentials. Keep test credentials local and test-only.
- Browser-based tests require Chrome, ChromeDriver access through WebDriverManager, internet connectivity, and a graphical desktop session.
- The demo website is external and may change its locators or behavior independently of this repository.
- The agent can generate and run tests, but a passing compilation does not guarantee that every browser flow passes; always review the TestNG results.

## What the Project Tests

The automated tests use the demo e-commerce application at:

`https://rahulshettyacademy.com/client`

The current suite covers:

- Login using credentials from `src/main/java/jsonD.json`
- Product selection for `ZARA COAT 3`
- Cart navigation and payment flow
- Country selection during checkout
- Product search for `IPHONE 13 PRO`
- Adding selected products to the cart
- Registration-page field interaction
- Writing page text to `src/main/java/output.txt`

## Project Structure

```text
.
|-- pom.xml                         Maven configuration and dependencies
|-- testng.xml                      TestNG suite configuration
|-- src
|   |-- main
|   |   `-- java
|   |       |-- jsonD.json          Login test data
|   |       |-- output.txt          Generated output file
|   |       |-- Abstractcomponents   Reusable Selenium utilities
|   |       |-- pageObjectMethod      Page Object classes
|   |       `-- Resources             Project properties
|   `-- test
|       `-- java
|           |-- tests/test           Test classes
|           `-- tests/testcomponents  WebDriver setup and teardown
`-- README.md
```

## Prerequisites

Install the following before running the tests:

1. Java 17 or newer.
2. Apache Maven 3.9 or newer.
3. Google Chrome.
4. Git.
5. Internet access, because Maven downloads dependencies and WebDriverManager resolves the ChromeDriver.

Verify Java and Maven:

```bash
java -version
mvn -version
```

## Clone and Run the Tests

From a terminal:

```bash
git clone https://github.com/apatha3/Selenium_with_java-Framework.git
cd Selenium_with_java-Framework
mvn clean test
```

The Maven Surefire plugin is configured to execute `testng.xml`, so `mvn clean test` runs the configured TestNG suite automatically.

## Run from VS Code or IntelliJ IDEA

1. Clone and open the repository as a Maven project.
2. Allow Maven to download the project dependencies.
3. Ensure Java 17 or newer is selected as the project SDK.
4. Open `testng.xml`.
5. Run the suite with the TestNG runner.

You can also open `src/test/java/tests/test/functionalityTest.java` and run an individual `@Test` method from the editor when the TestNG plugin is installed.

## Test Data

Login data is stored in:

```text
src/main/java/jsonD.json
```

The file must contain a JSON array with `email` and `password` values:

```json
[
  {
    "email": "your-email@example.com",
    "password": "your-password"
  }
]
```

Do not commit real passwords or other secrets to a public repository. Use test-only credentials or a local, ignored configuration file for private values.

## Browser Execution

The base test class creates a new Chrome browser before every test method and closes it afterward. WebDriverManager downloads or selects a compatible ChromeDriver automatically.

Tests require a graphical desktop session. They are not currently configured for headless execution.

## Troubleshooting

### `mvn` is not recognized

Install Apache Maven and add its `bin` directory to the Windows `PATH`. Restart the terminal and verify:

```bash
mvn -version
```

### Tests are not discovered

Run the suite from the project root and confirm that `testng.xml` is present:

```bash
mvn clean test
```

The class names in `testng.xml` must match the Java package and class names exactly, including capitalization.

### ChromeDriver or browser startup fails

Confirm that Google Chrome is installed and can start normally. Ensure the machine has internet access so WebDriverManager can obtain the required driver.

### Login tests fail

Check that the credentials in `src/main/java/jsonD.json` are valid for the application. The application itself must also be reachable from the test machine.

## Useful Commands

```bash
# Compile and run the full TestNG suite
mvn clean test

# Compile the project without running tests
mvn clean compile

# Run Maven with detailed output
mvn clean test -e
```

## Notes

- Test results are written under `target/surefire-reports/` after Maven execution.
- Maven build output is generated under `target/` and is not committed to Git.
- The application under test is an external demo site, so changes to that site can affect locator-based tests.
